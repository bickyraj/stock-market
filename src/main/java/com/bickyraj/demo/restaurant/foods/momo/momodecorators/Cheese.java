package com.bickyraj.demo.restaurant.foods.momo.momodecorators;

import com.bickyraj.demo.restaurant.foods.momo.Momo;

public class Cheese extends MomoDecorator {
    public Cheese(Momo momo) {
        super(momo);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with cheese";
    }

    @Override
    public double getPrice() {
        return tempMomo.getPrice() + 2;
    }
}
