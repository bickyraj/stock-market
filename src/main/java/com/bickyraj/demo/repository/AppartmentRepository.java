package com.bickyraj.demo.repository;

import com.bickyraj.demo.entity.Appartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppartmentRepository extends JpaRepository<Appartment, Long> {
}
