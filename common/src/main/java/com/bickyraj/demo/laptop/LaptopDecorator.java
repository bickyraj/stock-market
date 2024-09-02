package com.bickyraj.demo.laptop;

abstract class LaptopDecorator implements Laptop {
    Laptop decorateLaptop;
    public LaptopDecorator(Laptop laptop) {
        this.decorateLaptop = laptop;
    }
}
