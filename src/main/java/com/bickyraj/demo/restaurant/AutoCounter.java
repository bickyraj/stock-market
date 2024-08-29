package com.bickyraj.demo.restaurant;

public class AutoCounter {
    public static int counter;

    static {
        counter = 0;
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
