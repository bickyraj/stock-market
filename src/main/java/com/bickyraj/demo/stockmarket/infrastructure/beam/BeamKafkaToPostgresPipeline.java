package com.bickyraj.demo.stockmarket.infrastructure.beam;

import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class BeamKafkaToPostgresPipeline {
    private final PipelineOptions pipelineOptions;

    public BeamKafkaToPostgresPipeline(PipelineOptions pipelineOptions) {
        this.pipelineOptions = pipelineOptions;
    }

    @Value("${beam.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${beam.kafka.topic}")
    private String topic;

    @Value("${beam.jdbc.url}")
    private String jdbcUrl;

    @Value("${beam.jdbc.username}")
    private String username;

    @Value("${beam.jdbc.password}")
    private String password;

    private final ConcurrentHashMap<String, String> pipelineStatus = new ConcurrentHashMap<>();

    @Async
    public void runPipeline(String runId) {
        pipelineStatus.put(runId, "RUNNING");
        Pipeline pipeline = Pipeline.create(pipelineOptions);
        System.out.println("Pipeline created.");
        pipeline
                .apply("ReadFromKafka", KafkaIO.<String, String>read()
                        .withBootstrapServers(this.bootstrapServers)
                        .withTopic(this.topic)
                        .withKeyDeserializer(StringDeserializer.class)
                        .withValueDeserializer(StringDeserializer.class)
                        .withoutMetadata()
                )
                .apply("Deserialize JSON to StockMarketEntity", ParDo.of(new DeserializeJsonFn()))
                .setCoder(StockMarketEntityCoder.of())
                .apply("Process Data", ParDo.of(new ProcessDataFn()))
                .apply("WriteToPostgreSql", JdbcIO.<StockMarketEntity>write()
                        .withDataSourceConfiguration(JdbcIO.DataSourceConfiguration
                                .create(
                                        "org.postgresql.Driver",
                                        this.jdbcUrl)
                                .withUsername(this.username)
                                .withPassword(this.password))
                        .withStatement(("INSERT INTO kafka_stock_market (name, price) VALUES (?, ?)"))
                        .withPreparedStatementSetter(
                                (JdbcIO.PreparedStatementSetter<StockMarketEntity>)
                                        (element, preparedStatement) -> {
                                    preparedStatement.setString(1, element.name);
                                    preparedStatement.setDouble(2, element.price);
                                }));

        try {
            pipeline.run().waitUntilFinish();
            System.out.println("Pipeline finished successfully.");
        } catch (Exception e) {
            System.err.println("Pipeline execution failed.");
            e.printStackTrace();
        }
    }

    static class DeserializeJsonFn extends DoFn<KV<String, String>, StockMarketEntity> {
        private static final ObjectMapper objectMapper = new ObjectMapper();

        @ProcessElement
        public void processElement(@Element KV<String, String> record, OutputReceiver<StockMarketEntity> out) throws Exception {
            String json = record.getValue();
            StockMarketEntity entity = objectMapper.readValue(json, StockMarketEntity.class);
            out.output(entity);
        }
    }

    static class ProcessDataFn extends DoFn<StockMarketEntity, StockMarketEntity> {
        @ProcessElement
        public void processElement(@Element StockMarketEntity entity, OutputReceiver<StockMarketEntity> out) {
            StockMarketEntity updatedEntity = new StockMarketEntity(entity.getName(), entity.getPrice() * 1.1);  // Increase price by 10%
            out.output(updatedEntity);
        }
    }

    public String getPipelineStatus(String runId) {
        return pipelineStatus.getOrDefault(runId, "NOT_FOUND");
    }
}
