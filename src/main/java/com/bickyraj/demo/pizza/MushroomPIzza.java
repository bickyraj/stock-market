package com.bickyraj.demo.pizza;

import com.bickyraj.demo.restaurant.BaseFood;

public class MushroomPIzza extends BaseFood implements Pizza {
    @Override
    public String getName() {
        return "Mushroom Pizza";
    }

    @Override
    public String getDescription() {
        return "Mushroom Pizza";
    }

    @Override
    public double getPrice() {
        return 7;
    }
}
