package com.bickyraj.demo.stockmarket.infrastructure.reporitory.jpa;

import com.bickyraj.demo.stockmarket.infrastructure.reporitory.model.StockMarketModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStockMarketRepository extends JpaRepository<StockMarketModel, Long> {
}
