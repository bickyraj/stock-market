package com.bickyraj.demo.restaurant.foods.ramen;

import com.bickyraj.demo.restaurant.BaseFood;

public class PlainRamen extends BaseFood implements Ramen {
    @Override
    public String getName() {
        return "Plain Ramen";
    }

    @Override
    public String getDescription() {
        return "Plain Ramen";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
