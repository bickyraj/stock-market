package com.bickyraj.demo.stockmarket.domain.entity;

import com.bickyraj.demo.stockmarket.infrastructure.beam.StockMarketEntityCoder;
import com.bickyraj.demo.stockmarket.infrastructure.reporitory.model.StockMarketModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.beam.sdk.coders.DefaultCoder;

@EqualsAndHashCode
@Data
@AllArgsConstructor
@Accessors(chain = true)
@DefaultCoder(StockMarketEntityCoder.class)
public class StockMarketEntity {
    @JsonProperty("name")
    public String name;
    @JsonProperty("price")
    public Double price;

    public StockMarketEntity() {}

    public StockMarketEntity(StockMarketEntity other) {
        this.name = other.name;
        this.price = other.price;
    }

    public static StockMarketModel toModel(StockMarketEntity stockMarketEntity) {
        StockMarketModel stockMarketModel = new StockMarketModel();
        return stockMarketModel
                .setName(stockMarketEntity.name)
                .setPrice(stockMarketEntity.price);
    }
}
