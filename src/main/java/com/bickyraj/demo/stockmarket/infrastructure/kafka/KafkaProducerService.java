package com.bickyraj.demo.stockmarket.infrastructure.kafka;

import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import com.bickyraj.demo.stockmarket.infrastructure.beam.KafkaProducerConsumerGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaProducerConsumerGenerator kafkaProducerConsumerGenerator;
    private static final String TOPIC = "stock-market";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(StockMarketEntity entity) {
        try {
            KafkaProducer<String, StockMarketEntity> producer = kafkaProducerConsumerGenerator.createKafkaProducer();
            producer.send(new ProducerRecord<>(TOPIC, "1", entity));
            System.out.println("Message sent " + entity.toString());
            producer.close();
        } catch (Exception e) {
            System.err.println("Failed to serialize StockMarketEntity: " + e.getMessage());
        }
    }
}
