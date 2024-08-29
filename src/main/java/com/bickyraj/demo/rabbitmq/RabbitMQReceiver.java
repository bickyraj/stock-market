package com.bickyraj.demo.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
