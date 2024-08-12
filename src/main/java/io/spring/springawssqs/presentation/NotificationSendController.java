package io.spring.springawssqs.presentation;

import io.spring.springawssqs.infrastructure.sqs.sender.NotificationSendResult;
import io.spring.springawssqs.application.NotificationSendUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/send-notification")
@RestController
public class NotificationSendController {

    private final NotificationSendUseCase notificationSendUseCase;

    @PostMapping
    public ResponseEntity<NotificationSendResult> send(@RequestBody String message) {
        return ResponseEntity.ok(notificationSendUseCase.sendNotification(message));
    }
}