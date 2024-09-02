package com.bickyraj.demo.common.pizza;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " " + "and with cheese";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 50;
    }
}
