package com.bickyraj.demo.stockmarket;

public class StockApp {
    public static void main(String[] args) {
        AppleStock appleStock = AppleStock.getInstance();
        appleStock.setHigh(20);

        StockObserver john = new StockObserver();
        StockObserver anna = new StockObserver();

        StockListener stockListener = new HappyStockListener();

        stockListener.register(john);
        stockListener.register(anna);

        stockListener.updateAppleStock(appleStock);

        System.out.println(anna.appleStockPrice);
        stockListener.unregister(john);
        appleStock.setHigh(50);
        stockListener.updateAppleStock(appleStock);

        System.out.println("anna " + anna.appleStockPrice);
        System.out.println("john " + john.appleStockPrice);

        Runnable updateAppleStock = new StockMonitor(stockListener, appleStock);
        Thread thread = new Thread(updateAppleStock);
        thread.start();
    }
}
