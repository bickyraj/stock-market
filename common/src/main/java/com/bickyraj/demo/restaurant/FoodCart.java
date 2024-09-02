package com.bickyraj.demo.restaurant;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FoodCart {
    public final List<Food> foods;

    public FoodCart() {
        foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Food food : foods) {
            sum += food.getPrice();
        }
        return sum;
    }
}
