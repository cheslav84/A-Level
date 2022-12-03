package com.havryliuk;

import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarArrayRepository repository = new CarArrayRepository();
        CarService service = new CarService(repository);

        Car passengerCar = service.create(CarType.CAR);
        passengerCar.restoreCount(100);
        service.print(passengerCar);

        Car truck = service.create(CarType.TRUCK);
        truck.restoreCount(50);
        service.print(truck);

        Car identicalTruck = service.create(CarType.TRUCK);
        Car almostSameTruck = service.create(CarType.TRUCK);

        setDefinedTruckParameters((Truck) truck);
        setDefinedTruckParameters((Truck) identicalTruck);
        setAnotherTruckParameters((Truck) almostSameTruck);

        System.out.println("~~~");
        System.out.println("Are cars identical? " + service.areCarsEqual(truck, identicalTruck));
        System.out.println("Are cars identical? " + service.areCarsEqual(truck, almostSameTruck));


    }


    private static void setDefinedTruckParameters(Truck truck){
        truck.setPrice(200);
        truck.setManufacturer(Manufacturer.AUDI);
        truck.setEngine(new Engine(100, "Diesel"));
        truck.setColor(Color.RED);
        truck.setLoadCapacity(500);
    }

    private static void setAnotherTruckParameters(Truck truck){
        truck.setPrice(200);
        truck.setManufacturer(Manufacturer.AUDI);
        truck.setEngine(new Engine(200, "Diesel"));
        truck.setColor(Color.RED);
        truck.setLoadCapacity(500);
    }





}
