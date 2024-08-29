package com.bickyraj.demo.stockmarket;

import java.text.DecimalFormat;

public class StockMonitor implements Runnable {
    private final AppleStock stock;
    private final StockListener stockListener;

    public StockMonitor(StockListener listener, AppleStock stock) {
        this.stock = stock;
        this.stockListener = listener;
    }

    @Override
    public void run() {
        for (int i = 0; i<=20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            double random = (Math.random() * 0.6) - 0.3;
            DecimalFormat df = new DecimalFormat("#.##");
            stock.setHigh(Double.parseDouble(df.format(stock.getHigh() + random)));
            stockListener.updateAppleStock(stock);
        }
    }
}
