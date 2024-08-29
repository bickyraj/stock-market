package com.bickyraj.demo.pizza;

public enum PizzaType {
    PLAIN("plain"),
    CHEESE("cheese"),
    MUSHROOM("mushroom"),
    CHICKEN("chicken");

    public final String type;

    PizzaType(String type) {
        this.type = type;
    }
}
