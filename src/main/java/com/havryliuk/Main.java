package com.havryliuk;

import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarArrayRepository repository = new CarArrayRepository();
        CarService service = new CarService(repository);

        Car truck = service.create(CarType.TRUCK);
        setDefinedTruckParameters((Truck) truck);

        System.out.println("TASK 1");
        //printing Manufacturer and Count of Car
        service.printManufacturerAndCount(truck);
        System.out.println("______");

        //setting Manufacturer to null. (Count wil be printed as int)
        truck.setManufacturer(null);
        service.printManufacturerAndCount(truck);
        System.out.println("______");

        //setting Cat to null.
        truck = null;
        service.printManufacturerAndCount(truck);
        System.out.println("______\n");

        System.out.println("TASK 2");
        //printing defined car color
        truck = service.create(CarType.TRUCK);
        setDefinedTruckParameters((Truck) truck);
        service.printColor(truck);
        System.out.println("______");

        //printing random car color
        truck = null;
        service.printColor(truck);
        System.out.println("______\n");


    }


    private static void setDefinedTruckParameters(Truck truck){
        truck.setPrice(200);
        truck.setManufacturer(Manufacturer.AUDI);
        truck.setEngine(new Engine(100, "Diesel"));
        truck.setColor(Color.RED);
        truck.setLoadCapacity(500);
    }






}
