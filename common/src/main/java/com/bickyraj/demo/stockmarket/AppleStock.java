package com.bickyraj.demo.stockmarket;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class AppleStock implements Stock {
    private static AppleStock instance = null;
    public double open;
    public double close;
    public double high;
    public double low;
    public double volume;


    private AppleStock() {

    }

    public static AppleStock getInstance() {
        if (instance == null) {
            instance = new AppleStock();
        }
        return instance;
    }

    @Override
    public String getSymbol() {
        return "Euro";
    }

    @Override
    public String getName() {
        return "Apple Stocks";
    }

    @Override
    public double getOpen() {
        return this.open;
    }

    @Override
    public double getHigh() {
        return this.high;
    }

    @Override
    public double getLow() {
        return this.low;
    }

    @Override
    public double getClose() {
        return this.close;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
