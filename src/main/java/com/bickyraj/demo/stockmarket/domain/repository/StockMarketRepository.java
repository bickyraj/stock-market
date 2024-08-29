package com.bickyraj.demo.stockmarket.domain.repository;

import com.bickyraj.demo.stockmarket.Stock;
import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;

public interface StockMarketRepository {
    void save(StockMarketEntity stockMarket);
}
