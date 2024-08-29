package com.bickyraj.demo.stockmarket.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "stock-market", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
