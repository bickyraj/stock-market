package com.bickyraj.demo.appartment.reporitory;

import com.bickyraj.demo.appartment.Apartment;
import com.bickyraj.demo.appartment.IApartment;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class ApartmentRepository {
    private static final Map<Long, Apartment> apartments = new HashMap<>();

    public void addApartment(Apartment apartment) {
        apartments.put(apartment.getId(), apartment);
    }

    public void updateApartment(Apartment apartment) {
        apartments.put(apartment.getId(), apartment);
    }

    public List<Apartment> getApartments() {
        return new ArrayList<>(apartments.values());
    }

    public void removeApartment(Apartment apartment) {
        apartments.remove(apartment.getId());
    }

    public List<Apartment> getOnlyFurnishedApartments() {
        return this.getApartments().stream().filter(Apartment::isFurnished)
                .toList();
    }

    public List<Apartment> getOnlyUnFurnishedApartments() {
        return this.getApartments().stream().filter(apartment -> !apartment.isFurnished())
                .toList();
    }
}
