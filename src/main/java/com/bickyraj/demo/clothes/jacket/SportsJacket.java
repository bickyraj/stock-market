package com.bickyraj.demo.clothes.jacket;

import lombok.ToString;

@ToString
public class SportsJacket implements Jacket {
    @Override
    public String getType() {
        return "this is sports jacket";
    }

    @Override
    public double getPrice() {
        return 450;
    }
}
