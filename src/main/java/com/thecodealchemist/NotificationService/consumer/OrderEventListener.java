package com.thecodealchemist.NotificationService.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @KafkaListener(id = "orderEventListener", topics = "orderTopic")
    @RetryableTopic(attempts = "3", backoff = @Backoff(delay = 2000L, maxDelay = 10000L, multiplier = 2))
    public void consumeOrderEvent(String record) {
        System.out.println("Received event:: " + record);
        throw new RuntimeException();
    }
}
