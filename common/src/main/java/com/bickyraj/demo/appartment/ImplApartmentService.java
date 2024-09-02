package com.bickyraj.demo.appartment;

import java.util.List;

public class ImplApartmentService implements ApartmentService {

    @Override
    public Double getTotalPriceOfApartments(List<Apartment> apartments) {
        return apartments.stream().reduce(0.0,
                (sum, apartment) -> sum + apartment.getPrice(), Double::sum);
    }
}
