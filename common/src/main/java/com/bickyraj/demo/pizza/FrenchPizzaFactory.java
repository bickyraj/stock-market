package com.bickyraj.demo.pizza;

public class FrenchPizzaFactory implements PizzaFactory {
    @Override
    public String getName() {
        return "French Pizza Factory";
    }

    @Override
    public Pizza createPizza(PizzaType type) {
        if (PizzaType.CHEESE.equals(type)) {
            return new ChickenPizza();
        } else if (PizzaType.MUSHROOM.equals(type)) {
            return new MushroomPIzza();
        }
        return new PlainPizza();
    }
}
