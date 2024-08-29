package com.bickyraj.demo.pizza;

import java.util.Optional;

public interface PizzaFactory {
    String getName();
    Pizza createPizza(PizzaType type);
}
