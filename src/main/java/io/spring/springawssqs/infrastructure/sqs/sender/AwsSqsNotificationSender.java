package io.spring.springawssqs.infrastructure.sqs.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.spring.springawssqs.domain.notification.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AwsSqsNotificationSender implements NotificationSender {

    @Value("${cloud.aws.sqs.queue.name}")
    private String queueName;

    private final ObjectMapper objectMapper;

    private final SqsTemplate template;

    @Override
    public NotificationSendResult sendNotification(Notification notification) {
        try {
            String message = objectMapper.writeValueAsString(notification);

            SendResult<String> result = template.send(to -> to
                .queue(queueName)
                .payload(message));

            notification.queueSendSuccess(result.messageId().toString());
        } catch (Exception e) {
            notification.queueSendFailure();
            log.error("send notification error : ", e);
        }

        return new NotificationSendResult(notification);
    }
}
