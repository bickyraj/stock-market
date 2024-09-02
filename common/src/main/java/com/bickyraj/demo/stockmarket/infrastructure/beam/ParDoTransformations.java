package com.bickyraj.demo.stockmarket.infrastructure.beam;

import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

public class ParDoTransformations {

    public static class ReadMessagesFn extends DoFn<KV<String, StockMarketEntity>, KV<String, StockMarketEntity>> {
        @ProcessElement
        public void processElement(@Element KV<String, StockMarketEntity> element, OutputReceiver<KV<String, StockMarketEntity>> receiver) {
            System.out.println("Reading message: " + element.getValue());
            receiver.output(element);
        }
    }

    public static class TransformMessagesFn extends DoFn<KV<String, StockMarketEntity>, StockMarketEntity> {
        @ProcessElement
        public void processElement(@Element KV<String, StockMarketEntity> element, OutputReceiver<StockMarketEntity> receiver) {
            StockMarketEntity entity = element.getValue();
            System.out.println("Transforming message: " + entity);
            receiver.output(entity);
        }
    }
}
