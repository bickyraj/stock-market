package com.bickyraj.demo.common.pizza;

abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }
}
