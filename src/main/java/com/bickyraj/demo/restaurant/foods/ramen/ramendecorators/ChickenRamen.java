package com.bickyraj.demo.restaurant.foods.ramen.ramendecorators;

import com.bickyraj.demo.restaurant.foods.ramen.Ramen;

public class ChickenRamen extends RamenDecorator {
    public ChickenRamen(Ramen tempRamen) {
        super(tempRamen);
    }

    @Override
    public String getDescription() {
        return "Chicken " + super.getDescription();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 4;
    }
}
