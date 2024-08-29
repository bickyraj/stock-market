package com.bickyraj.demo.laptop;

public class NormalLaptop implements Laptop {
    @Override
    public String getDescription() {
        return "this is normal laptop";
    }

    @Override
    public double getPrice() {
        return 150;
    }
}
