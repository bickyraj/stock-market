package com.bickyraj.demo.pizza;

public class ChickenPizza implements Pizza {

    @Override
    public String getName() {
        return "Chicken Pizza";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
