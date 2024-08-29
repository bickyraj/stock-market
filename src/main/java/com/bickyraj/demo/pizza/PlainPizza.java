package com.bickyraj.demo.pizza;

import com.bickyraj.demo.restaurant.BaseFood;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@ToString
public class PlainPizza extends BaseFood implements Pizza {
    @Override
    public String getName() {
        return "PlainPizza";
    }

    @Override
    public String getDescription() {
        return "a plain pizza";
    }

    @Override
    public double getPrice() {
        return 5;
    }
}
