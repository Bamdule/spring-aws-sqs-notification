package io.spring.springawssqs.infrastructure.sqs.sender;

import io.spring.springawssqs.domain.notification.Notification;

public interface NotificationSender {
    NotificationSendResult sendNotification(Notification notification);
}