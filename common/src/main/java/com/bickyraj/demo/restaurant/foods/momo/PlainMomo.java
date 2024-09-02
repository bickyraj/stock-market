package com.bickyraj.demo.restaurant.foods.momo;

import com.bickyraj.demo.restaurant.BaseFood;

public class PlainMomo extends BaseFood implements Momo {
    @Override
    public String getName() {
        return "Plain Momo";
    }

    @Override
    public String getDescription() {
        return "This is a plain Momo";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
