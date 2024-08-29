package com.bickyraj.demo.appartment;

import com.bickyraj.demo.appartment.reporitory.ApartmentIdGenerator;
import lombok.*;
import lombok.experimental.Accessors;

@ToString
@Setter
@Accessors(chain = true)
public class Apartment extends BaseApartment {

    private Long apartmentId;
    private String name;
    private Integer numberOfRooms;
    private String address;
    private Integer capacity;
    private Integer floorNumber;
    private Boolean isFurnished;
    private Double price;

    public Apartment() {
        this.apartmentId = ApartmentIdGenerator.nextId();
    }
    @Override
    public Long getId() {
        return this.apartmentId;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getNumberOfRooms() {
        return this.numberOfRooms;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public Integer getFloorNumber() {
        return this.floorNumber;
    }

    @Override
    public Boolean isFurnished() {
        return this.isFurnished;
    }

    @Override
    public Integer getCapacity() {
        return this.capacity;
    }
}
