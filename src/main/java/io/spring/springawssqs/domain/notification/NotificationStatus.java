package io.spring.springawssqs.domain.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum NotificationStatus {
    CREATED("알림 생성"),
    QUEUE_SEND_SUCCESS("큐 알림 전송 성공"),
    QUEUE_SEND_FAILURE("큐 알림 전송 실패"),
    CONSUMER_RECEIVE_SUCCESS("컨슈머 큐 수신 성공"),
    NOTIFICATION_SEND_SUCCESS("사용자 알림 전송 성공"),
    NOTIFICATION_SEND_FAILURE("사용자 알림 전송 실패");

    private final String description;

}
