package com.bickyraj.demo.stockmarket.infrastructure.messaging;

import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import com.bickyraj.demo.stockmarket.domain.repository.StockMarketRepository;
import com.bickyraj.demo.stockmarket.infrastructure.kafka.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockReceiver {
    private final StockMarketRepository stockMarketRepository;
    private final KafkaProducerService producerService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void receiveMessage(String message) {
        try {
            StockMarketEntity stockMarketEntity = objectMapper.readValue(message, StockMarketEntity.class);
            stockMarketRepository.save(stockMarketEntity);
            producerService.sendMessage(stockMarketEntity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
