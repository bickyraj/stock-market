package com.bickyraj.demo.stockmarket.application;

import com.bickyraj.demo.rabbitmq.RabbitMQReceiver;
import com.bickyraj.demo.rabbitmq.RabbitMQSender;
import com.bickyraj.demo.stockmarket.infrastructure.kafka.KafkaProducerService;
import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import com.bickyraj.demo.stockmarket.domain.repository.StockMarketRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateStockUseCase {

    @Getter
    @AllArgsConstructor(staticName = "of")
    @EqualsAndHashCode
    @ToString
    public static class Request {
        private final StockMarketEntity stockMarketEntity;
    }

    @Getter
    @AllArgsConstructor(staticName = "of")
    @EqualsAndHashCode
    @ToString
    public static class Response {
        private final Boolean success;
    }

    private final RabbitMQSender rabbitMQSender;

    public Response execute(Request request) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String message = objectMapper.writeValueAsString(request.stockMarketEntity);
            rabbitMQSender.sendMessage(message);
        } catch (JacksonException e) {
            log.error(e.getOriginalMessage());
        }
        return Response.of(true);
    }
}