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

        service.printManufacturerAndCount(null);
        System.out.println("______\n");


        System.out.println("TASK 2");
        //printing defined car color
        truck = service.create(CarType.TRUCK);
        setDefinedTruckParameters((Truck) truck);
        service.printColor(truck);
        System.out.println("______");

        //printing random car color
        service.printColor(null);
        System.out.println("______\n");


        System.out.println("TASK 3");
        //printing Manufacturer and Count of Car
        truck = service.create(CarType.TRUCK);
        setDefinedTruckParameters((Truck) truck);
        truck.setCount(11);
        service.checkCount(truck);
        System.out.println("______");

        //setting count less than 10
        truck.setCount(10);
        //service.checkCount(truck);//todo uncomment (Exception expected)
        System.out.println("______\n");

        System.out.println("TASK 5");
        //printing Engine
        service.printEngineInfo(truck);
        //new Engine will be created
        service.printEngineInfo(null);
        System.out.println("______\n");

        System.out.println("TASK 4");
        //printing Car
        service.printInfo(truck);
        //new Car will be created
        service.printInfo(null);
    }


    private static void setDefinedTruckParameters(Truck truck){
        truck.setPrice(200);
        truck.setManufacturer(Manufacturer.AUDI);
        truck.setEngine(new Engine(100, "Diesel"));
        truck.setColor(Color.RED);
        truck.setLoadCapacity(500);
    }






}
