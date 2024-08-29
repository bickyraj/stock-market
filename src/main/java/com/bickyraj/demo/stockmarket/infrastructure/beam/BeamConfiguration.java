package com.bickyraj.demo.stockmarket.infrastructure.beam;

import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeamConfiguration {
    @Bean
    public PipelineOptions pipelineOptions() {
        return PipelineOptionsFactory.create();
    }
}
