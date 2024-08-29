package com.bickyraj.demo.service;

import com.bickyraj.demo.entity.Appartment;

import java.util.List;

public interface AppartmentService {
    List<Appartment> getAllAppartments();
    Appartment getAppartmentById(Long id);
    Appartment saveAppartment(Appartment appartment);
}
