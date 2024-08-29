package com.bickyraj.demo.common.pizza;

public class ChickenDecorator extends PizzaDecorator {
    public ChickenDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " " + "and with chicken";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 100;
    }
}
