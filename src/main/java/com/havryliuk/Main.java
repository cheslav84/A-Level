package com.havryliuk;

import com.havryliuk.container.CarList;
import com.havryliuk.container.GenericContainer;
import com.havryliuk.model.Car;
import com.havryliuk.model.CarType;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;
import com.havryliuk.util.AlgorithmUtil;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        CarList<Car> cars = new CarList<>();
        CarService service = new CarService(new CarArrayRepository());
        Car firstCar = service.create(CarType.TRUCK);
        Car secondCar = service.create(CarType.CAR);

        System.out.println("size = " + cars.size());
        cars.add(service.create(CarType.CAR));
        cars.add(service.create(CarType.TRUCK));
        cars.add(service.create(CarType.TRUCK));

        System.out.println("~~~~~~List of cars:");
        cars.addFirst(firstCar);
        cars.forEach(System.out::println);

        System.out.println("\n" + "~~~~~~The first car in the list (after adding a car to the first position):");
        System.out.println(cars.get(0));
        System.out.println("~~~~~~Receive a car from the center of the list:");
        System.out.println(cars.get(1));
        System.out.println("~~~~~~Receive the last car from the list:");
        System.out.println(cars.get(cars.size()-1) + "\n");

        System.out.println("~~~~~~Setting a car to the second position (received car):");
        System.out.println(cars.set(1, secondCar));
        System.out.println("~~~~~~Getting a car from the second position:");
        System.out.println(cars.get(1) + "\n");

        System.out.println("~~~~~~List of cars:");
        cars.forEach(System.out::println);
        System.out.println("~~~~~~Getting the number position:");
        System.out.println(cars.find(firstCar));
        System.out.println("~~~~~~Getting the number position:");
        System.out.println(cars.find(secondCar));

        System.out.println("\n" + "~~~~~~List before removing:");
        cars.forEach(System.out::println);
        System.out.println("~~~~~~Remove from center");
        cars.remove(1);
        System.out.println("~~~~~~Remove fist");
        cars.remove(0);
        System.out.println("~~~~~~Remove last");
        cars.remove(1);
        System.out.println("List of cars:");
        cars.forEach(System.out::println);

        System.out.println("~~~~~~Create new car list");
        cars.clear();
        cars.add(service.create(CarType.CAR));
        cars.add(service.create(CarType.TRUCK));
        cars.add(service.create(CarType.TRUCK));

        cars.get(0).setCount(10);
        cars.get(1).setCount(20);
        cars.get(2).setCount(30);

        System.out.println("Count fo all cars = " + cars.getCountAllCars());
    }

}
