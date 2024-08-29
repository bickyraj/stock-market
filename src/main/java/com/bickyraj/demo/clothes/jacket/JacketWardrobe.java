package com.bickyraj.demo.clothes.jacket;

import com.bickyraj.demo.wardrobe.Wardrobe;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class JacketWardrobe implements Wardrobe<Jacket> {
    List<Jacket> wardrobe = new ArrayList<>();
    @Override
    public void add(Jacket item) {
        wardrobe.add(item);
    }

    @Override
    public void remove(Jacket item) {
        wardrobe.remove(item);
    }

    @Override
    public void getAll() {
        for (Jacket item : wardrobe) {
            System.out.println(item.getType());
            System.out.println(item.getPrice());
        }
    }
}
