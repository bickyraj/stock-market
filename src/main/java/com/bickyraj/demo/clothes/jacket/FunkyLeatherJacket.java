package com.bickyraj.demo.clothes.jacket;

import lombok.ToString;

@ToString
public class FunkyLeatherJacket extends LeatherJacketDecorator {

    public FunkyLeatherJacket(LeatherJacket jacket) {
        super(jacket);
    }

    @Override
    public String getType() {
        return leatherJacketDecorator.getType() + " with FunkyLeather";
    }

    @Override
    public double getPrice() {
        return leatherJacketDecorator.getPrice() + 500;
    }
}
