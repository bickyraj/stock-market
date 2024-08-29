package com.bickyraj.demo.appartment;

import com.bickyraj.demo.appartment.reporitory.ApartmentRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApartmentRepository apartmentRepository = new ApartmentRepository();
        ApartmentService apartmentService = new ImplApartmentService();

        Apartment bickyApartment = new Apartment();
                bickyApartment.setName("Bicky")
                        .setPrice(750D)
                .setAddress("Paris")
                .setCapacity(2)
                .setFloorNumber(10)
                .setNumberOfRooms(3)
                .setIsFurnished(true);

        Apartment ramboApartment = new Apartment();
        ramboApartment
                .setName("Rambo")
                .setAddress("imadol")
                .setIsFurnished(false)
                .setPrice(500D)
                .setNumberOfRooms(2)
                .setFloorNumber(2)
                .setCapacity(2);

        Apartment nicoleApartment = new Apartment();
        nicoleApartment
                .setName("Nicole")
                .setAddress("imadol")
                .setIsFurnished(true)
                .setPrice(500D)
                .setNumberOfRooms(2)
                .setFloorNumber(2)
                .setCapacity(2);

        apartmentRepository.addApartment(bickyApartment);
        apartmentRepository.addApartment(ramboApartment);
        apartmentRepository.addApartment(nicoleApartment);
        bickyApartment.setAddress("kupondole");
        apartmentRepository.updateApartment(bickyApartment);

        List<Apartment> furnishedApartments = apartmentRepository.getOnlyFurnishedApartments();
        List<Apartment> unFurnishedApartments = apartmentRepository.getOnlyUnFurnishedApartments();
        System.out.println("furnished apartments");
        System.out.println(apartmentService.getTotalPriceOfApartments(furnishedApartments));
        System.out.println("unfurnished apartments");
        System.out.println(apartmentService.getTotalPriceOfApartments(unFurnishedApartments));
    }
}
