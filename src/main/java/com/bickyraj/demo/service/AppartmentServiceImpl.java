package com.bickyraj.demo.service;

import com.bickyraj.demo.entity.Appartment;
import com.bickyraj.demo.repository.AppartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppartmentServiceImpl implements AppartmentService {

    private final AppartmentRepository appartmentRepository;

    public AppartmentServiceImpl(AppartmentRepository appartmentRepository) {
        this.appartmentRepository = appartmentRepository;
    }

    @Override
    public List<Appartment> getAllAppartments() {
        return appartmentRepository.findAll();
    }

    @Override
    public Appartment getAppartmentById(Long id) {
        return  appartmentRepository.findById(id).orElse(null);
    }

    @Override
    public Appartment saveAppartment(Appartment appartment) {
        return appartmentRepository.save(appartment);
    }
}
