package com.bickyraj.demo.restaurant.threaddemo;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    public final Queue<String> orderList = new LinkedList<>();
    public final Integer MAX_ORDER = 5;

    public synchronized void takeOrder(String order) throws InterruptedException {

        while (orderList.size() == MAX_ORDER) {
            wait();
        }
        orderList.add(order);
        System.out.println(Thread.currentThread().getName() + " take order: " + order);
        notify();
    }

    public synchronized void prepareFood() throws InterruptedException {
        while(true) {
            while (orderList.isEmpty()) {
                wait();
            }
            String order = orderList.poll();
            System.out.println(Thread.currentThread().getName() + " preparing food: " + order);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " finish preparing food: " + order);
            notify();
        }
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Thread waiterThread = new Thread(() -> {
            try {
                String[] orders = {"Pizza", "Burger", "Pasta", "Salad", "Sushi", "Tacos"};
                for (String order : orders) {
                    restaurant.takeOrder(order);
                    Thread.sleep(500); // Simulate time taken by taking an order
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Waiter");

        Thread chefThread = new Thread(() -> {
            try {
                restaurant.prepareFood();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Chef");

        waiterThread.start();
        chefThread.start();
    }
}
