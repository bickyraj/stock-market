package com.bickyraj.demo.stockmarket.entrypoint.rest;

import com.bickyraj.demo.stockmarket.application.CreateStockUseCase;
import com.bickyraj.demo.stockmarket.domain.entity.StockMarketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/stock-market")
public class StockMarketController {
    private final CreateStockUseCase createStockUseCase;

    @PostMapping
    public Boolean createStock(@RequestBody StockMarketEntity stockMarketEntity) {
        return createStockUseCase.execute(CreateStockUseCase.Request.of(stockMarketEntity))
                .getSuccess();
    }
}
