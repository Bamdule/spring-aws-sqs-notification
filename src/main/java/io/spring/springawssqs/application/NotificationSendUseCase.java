package io.spring.springawssqs.application;

import io.spring.springawssqs.domain.notification.Notification;
import io.spring.springawssqs.infrastructure.sqs.sender.NotificationSendResult;
import io.spring.springawssqs.infrastructure.sqs.sender.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationSendUseCase {

    private final NotificationSender notificationSender;

    public NotificationSendResult sendNotification(String message) {
        return notificationSender.sendNotification(Notification.create(message));
    }
}
