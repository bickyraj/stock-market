package com.bickyraj.demo.stockmarket;

public class StockObserver implements Observer {
    public Integer id;
    public double appleStockPrice;

    public StockObserver() {
        id = IdGenerator.nextId();
    }
    @Override
    public void update(Stock stock) {
        appleStockPrice = stock.getHigh();
    }
}
