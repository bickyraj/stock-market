package com.bickyraj.demo.common.charger;

public class Iphone4sTo6sAdapter implements Charger {
    Iphone4sCharger iphone4sCharger;

    public Iphone4sTo6sAdapter() {
        iphone4sCharger = new Iphone4sCharger();
    }

    @Override
    public void charge() {
        iphone4sCharger.charge();
    }
}
