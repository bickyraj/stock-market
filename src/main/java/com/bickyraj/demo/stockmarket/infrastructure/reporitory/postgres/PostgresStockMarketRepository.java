package com.bickyraj.demo.stockmarket.infrastructure.reporitory.postgres;

import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import com.bickyraj.demo.stockmarket.domain.repository.StockMarketRepository;
import com.bickyraj.demo.stockmarket.infrastructure.reporitory.jpa.JpaStockMarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgresStockMarketRepository implements StockMarketRepository {
    private final JpaStockMarketRepository jpaStockMarketRepository;

    @Override
    public void save(StockMarketEntity stockMarket) {
        jpaStockMarketRepository.save(StockMarketEntity.toModel(stockMarket));
    }
}
