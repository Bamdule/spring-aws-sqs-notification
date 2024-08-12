package io.spring.springawssqs.infrastructure.sqs.sender;

import io.spring.springawssqs.domain.notification.Notification;

public record NotificationSendResult(
    Notification notification
) {
}
