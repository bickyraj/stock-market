package com.bickyraj.demo.controller;

import com.bickyraj.demo.entity.Appartment;
import com.bickyraj.demo.service.AppartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appartment")
public class AppartmentController {

    @Autowired private AppartmentService appartmentService;

    @GetMapping
    public ResponseEntity<List<Appartment>> getAll() {
        List<Appartment> appartments = appartmentService.getAllAppartments();
        return ResponseEntity.ok(appartments);
    }

    @PostMapping
    public Appartment createAppartment(@RequestBody Appartment appartment) {
        return appartmentService.saveAppartment(appartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appartment> getAppartment(@PathVariable Long id) {
        Appartment appartment = appartmentService.getAppartmentById(id);
        if (appartment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appartment);
    }
}
