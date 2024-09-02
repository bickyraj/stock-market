package com.bickyraj.demo.restaurant.foods.ramen.ramendecorators;

import com.bickyraj.demo.restaurant.foods.ramen.Ramen;

public class SpicyRamen extends RamenDecorator {
    public SpicyRamen(Ramen tempRamen) {
        super(tempRamen);
    }

    @Override
    public String getDescription() {
        return "Spicy " + super.getDescription();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1;
    }
}
