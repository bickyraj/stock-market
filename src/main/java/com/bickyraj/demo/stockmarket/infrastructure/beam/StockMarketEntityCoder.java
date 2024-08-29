package com.bickyraj.demo.stockmarket.infrastructure.beam;

import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.beam.sdk.coders.AtomicCoder;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.coders.CoderException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StockMarketEntityCoder extends AtomicCoder<StockMarketEntity> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void encode(StockMarketEntity value, OutputStream outStream) throws CoderException, IOException {
        String json = objectMapper.writeValueAsString(value);
        outStream.write(json.getBytes());
    }

    @Override
    public StockMarketEntity decode(InputStream inStream) throws CoderException, IOException {
        byte[] bytes = inStream.readAllBytes();
        return objectMapper.readValue(bytes, StockMarketEntity.class);
    }

    @Override
    public void verifyDeterministic() throws NonDeterministicException {
        // Add deterministic verification code if necessary.
    }

    public static Coder<StockMarketEntity> of() {
        return new StockMarketEntityCoder();
    }
}
