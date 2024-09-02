package com.bickyraj.demo.stockmarket;

import java.util.Map;

public interface StockListener {
    public void register(StockObserver observer);
    public void unregister(StockObserver observer);
    public void notifyAllObserver();

    void updateAppleStock(AppleStock appleStock);
}
