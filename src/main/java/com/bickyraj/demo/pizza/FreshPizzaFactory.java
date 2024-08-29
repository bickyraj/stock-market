package com.bickyraj.demo.pizza;

public class FreshPizzaFactory implements PizzaFactory {

    @Override
    public String getName() {
        return "Fresh Pizza Factory";
    }

    public Pizza createPizza(PizzaType pizzaType) {
        if (pizzaType.equals(PizzaType.PLAIN)) {
            return new PlainPizza();
        } else if (pizzaType.equals(PizzaType.CHICKEN)) {
            return new ChickenPizza();
        }
        return new PlainPizza();
    }
}
