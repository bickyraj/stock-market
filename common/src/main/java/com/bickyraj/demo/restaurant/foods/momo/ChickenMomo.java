package com.bickyraj.demo.restaurant.foods.momo;

import com.bickyraj.demo.restaurant.BaseFood;

public class ChickenMomo extends BaseFood implements Momo {
    @Override
    public String getName() {
        return "Chicken Momo";
    }

    @Override
    public String getDescription() {
        return "Chicken momo";
    }

    @Override
    public double getPrice() {
        return 12;
    }
}
