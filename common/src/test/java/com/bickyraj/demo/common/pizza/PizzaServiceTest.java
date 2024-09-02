package com.bickyraj.demo.common.pizza;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PizzaServiceTest {

    @Test
    public void getPizzaDescriptionCostPriceTest() {
        Pizza pizza = new PlainPizza();
        pizza = new CheeseDecorator(pizza);
        assertEquals(pizza.getCost(), 300);
        assertEquals(pizza.getDescription(), "this is plain pizza and with cheese");
        pizza = new ChickenDecorator(pizza);
        assertEquals(pizza.getCost(), 400);
        assertEquals(pizza.getDescription(), "this is plain pizza and with cheese and with chicken");

        pizza = new HamDecorator(pizza);
        assertEquals(pizza.getDescription(), "this is plain pizza and with cheese and with chicken and with Ham");
        assertEquals(pizza.getCost(), 550);
    }
}
