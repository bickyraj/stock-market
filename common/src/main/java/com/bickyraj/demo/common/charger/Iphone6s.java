package com.bickyraj.demo.common.charger;

public class Iphone6s implements Iphone {
    Charger iphone4sTo6sAdapter;

    public Iphone6s(Charger iphone4sTo6sAdapter) {
        this.iphone4sTo6sAdapter = iphone4sTo6sAdapter;
    }

    @Override
    public void onCharge() {
        iphone4sTo6sAdapter.charge();
    }
}
