package com.bickyraj.demo.stockmarket;

public interface Stock {
    String getSymbol();
    String getName();
    double getOpen();
    double getHigh();
    double getLow();
    double getClose();
    double getVolume();
}
