package io.spring.springawssqs.domain.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Notification {

    private String message;
    private String messageId;
    private NotificationStatus status;
    private LocalDateTime createAt;

    public static Notification create(String message) {
        return new Notification(
            message,
            null,
            NotificationStatus.CREATED,
            LocalDateTime.now()
        );
    }

    public void queueSendSuccess(String messageId) {
        this.messageId = messageId;
        this.status = NotificationStatus.QUEUE_SEND_SUCCESS;
    }

    public void queueSendFailure() {
        this.status = NotificationStatus.QUEUE_SEND_FAILURE;
    }

}
