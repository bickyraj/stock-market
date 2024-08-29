package com.bickyraj.demo.common.charger;

public class Iphone4sCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("Charging with iphone 4s charger");
    }
}
