package com.bickyraj.demo.stockmarket.entrypoint.rest;

import com.bickyraj.demo.stockmarket.infrastructure.beam.BeamKafkaToPostgresPipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/beam")
@RequiredArgsConstructor
public class BeamController {
    private final BeamKafkaToPostgresPipeline beamKafkaToPostgresPipeline;

    @PostMapping("/run-beam-pipeline")
    public ResponseEntity<String> runBeamPipeline() {
        String runId = UUID.randomUUID().toString();
        beamKafkaToPostgresPipeline.runPipeline(runId);  // Asynchronously run the pipeline
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("{\"runId\": \"" + runId + "\", \"message\": \"Pipeline execution started\"}");
    }

    @GetMapping("/pipeline-status/{runId}")
    public ResponseEntity<String> getPipelineStatus(@PathVariable String runId) {
        String status = beamKafkaToPostgresPipeline.getPipelineStatus(runId);
        if ("NOT_FOUND".equals(status)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pipeline run ID not found");
        } else {
            return ResponseEntity.ok("Pipeline status: " + status);
        }
    }
}
