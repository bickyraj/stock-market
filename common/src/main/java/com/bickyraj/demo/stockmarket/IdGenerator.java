package com.bickyraj.demo.stockmarket;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger sequence = new AtomicInteger(0);
    public static int nextId() {
        return sequence.incrementAndGet();
    }
}
