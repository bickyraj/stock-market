package com.bickyraj.demo.restaurant;

public class LaPizzaRestaurant implements Restaurant {

    protected final FoodCart foodCart;

    public LaPizzaRestaurant() {
        foodCart = new FoodCart();
    }

    @Override
    public String getName() {
        return "La Pizza";
    }

    @Override
    public String getAddress() {
        return "Paris";
    }

    @Override
    public String getPhoneNumber() {
        return "0694588442";
    }

    @Override
    public FoodCart getFoodCart() {
        return foodCart;
    }
}
