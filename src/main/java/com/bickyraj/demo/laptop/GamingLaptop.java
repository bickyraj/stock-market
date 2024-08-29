package com.bickyraj.demo.laptop;

public class GamingLaptop extends LaptopDecorator{
    public GamingLaptop(Laptop laptop) {
        super(laptop);
    }
    @Override
    public String getDescription() {
        return decorateLaptop.getDescription() + " with extra graphics card";
    }

    @Override
    public double getPrice() {
        return decorateLaptop.getPrice() + 100;
    }
}
