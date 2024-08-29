package com.bickyraj.demo.common.pizza;

public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "this is plain pizza";
    }

    @Override
    public double getCost() {
        return 250;
    }
}
