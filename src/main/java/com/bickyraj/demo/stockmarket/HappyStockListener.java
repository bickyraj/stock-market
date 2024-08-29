package com.bickyraj.demo.stockmarket;

import java.util.HashMap;
import java.util.Map;

public class HappyStockListener implements StockListener {

    Map<Integer, StockObserver> observers = new HashMap<>();

    public AppleStock appleStock;

    @Override
    public void register(StockObserver observer) {
        observers.put(observer.id, observer);
    }

    @Override
    public void unregister(StockObserver observer) {
        observers.remove(observer.id);
    }

    @Override
    public void notifyAllObserver() {
        observers.forEach((id, so) -> {
            so.update(appleStock);
            System.out.println(so.id + " " + so.appleStockPrice);
        });
    }

    @Override
    public void updateAppleStock(AppleStock appleStock) {
        this.appleStock = appleStock;
        this.notifyAllObserver();
    }
}
