package com.bickyraj.demo.common.pizza;

public class HamDecorator extends PizzaDecorator {
    public HamDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " and with Ham";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 150;
    }
}
