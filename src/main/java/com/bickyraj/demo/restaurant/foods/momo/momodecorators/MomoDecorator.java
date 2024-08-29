package com.bickyraj.demo.restaurant.foods.momo.momodecorators;

import com.bickyraj.demo.restaurant.BaseFood;
import com.bickyraj.demo.restaurant.foods.momo.Momo;

public class MomoDecorator extends BaseFood implements Momo {
    public final Momo tempMomo;

    public MomoDecorator(Momo momo) {
        this.tempMomo = momo;
    }
    @Override
    public String getName() {
        return tempMomo.getName();
    }

    @Override
    public String getDescription() {
        return tempMomo.getDescription();
    }

    @Override
    public double getPrice() {
        return tempMomo.getPrice();
    }
}
