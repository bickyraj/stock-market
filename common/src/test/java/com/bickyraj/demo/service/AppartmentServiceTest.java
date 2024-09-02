package com.bickyraj.demo.service;

import com.bickyraj.demo.entity.Appartment;
import com.bickyraj.demo.repository.AppartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppartmentServiceTest {
    @Mock
    private AppartmentRepository appartmentRepository;
    @InjectMocks
    private AppartmentServiceImpl appartmentService;

    @Test
    public void testGetAllAppartmentsForEmptyList() {
        List<Appartment> appartments = new ArrayList<>();
        when(appartmentRepository.findAll()).thenReturn(appartments);
        List<Appartment> result = appartmentService.getAllAppartments();
        verify(appartmentRepository, times(1)).findAll();
        // Assert the result
        assertEquals(appartments, result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllAppartmentsForOneAppartment() {
        Appartment appartment = mock(Appartment.class);
        when(appartmentRepository.findById(0L)).thenReturn(Optional.of(appartment));
        Appartment result = appartmentService.getAppartmentById(0L);
        assertEquals(appartment, result);
        verify(appartmentRepository, times(1)).findById(0L);
    }
}
