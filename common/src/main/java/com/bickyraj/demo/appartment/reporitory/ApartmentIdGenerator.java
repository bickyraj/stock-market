package com.bickyraj.demo.appartment.reporitory;

import java.util.concurrent.atomic.AtomicLong;

public class ApartmentIdGenerator {
    private static final AtomicLong idGenerator = new AtomicLong(0);

    public static long nextId() {
        return idGenerator.incrementAndGet();
    }
}
