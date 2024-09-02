package com.bickyraj.demo.restaurant.foods.ramen.ramendecorators;

import com.bickyraj.demo.restaurant.BaseFood;
import com.bickyraj.demo.restaurant.foods.ramen.Ramen;

public class RamenDecorator extends BaseFood implements Ramen {
    public final Ramen tempRamen;

    public RamenDecorator(Ramen tempRamen) {
        this.tempRamen = tempRamen;
    }

    @Override
    public String getName() {
        return tempRamen.getName();
    }

    @Override
    public String getDescription() {
        return tempRamen.getDescription();
    }

    @Override
    public double getPrice() {
        return tempRamen.getPrice();
    }
}
