package com.bickyraj.demo.wardrobe;

public interface Wardrobe<T> {
    void add(T item);
    void remove(T item);
    void getAll();
}
