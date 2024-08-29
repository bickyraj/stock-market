package com.bickyraj.demo.clothes.jacket;

import lombok.ToString;

@ToString
public class LeatherJacket implements Jacket {
    @Override
    public String getType() {
        return "this is a leather jacket";
    }

    @Override
    public double getPrice() {
        return 500;
    }
}
