package com.bickyraj.demo.restaurant;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        AutoCounter autoCounter = new AutoCounter();
        autoCounter.increment();
        System.out.println(AutoCounter.counter);
        AutoCounter autoCounter2 = new AutoCounter();
        autoCounter2.increment();
        System.out.println(autoCounter2.getCounter());
    }
}
