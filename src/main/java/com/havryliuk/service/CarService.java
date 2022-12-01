package com.havryliuk.service;

import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.util.RandomGenerator;

import java.util.Arrays;
import java.util.Random;


public class CarService {

    private final CarArrayRepository carArrayRepository;


    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public Car create(CarType carType) {
        Manufacturer manufacturer = getRandomManufacturer();
        Engine engine = getRandomEngine();
        Color color = getRandomColor();
        if (carType.equals(CarType.CAR)){
            return new  PassengerCar(manufacturer, engine, color, carType);
        } else if (carType.equals(CarType.TRUCK)) {
            return new Truck(manufacturer, engine, color, carType);
        }
        return null;
    }

    public int create(RandomGenerator randomGenerator){
        int numberOfCars = randomGenerator.generateNumber();
        if (numberOfCars == 0){
            return -1;
        }
        for (int i = 0; i <= numberOfCars; i++) {
            Car currentCar = create(getRandomCarType());
            currentCar.setCount(numberOfCars);
            print(currentCar);
        }
        return numberOfCars;
    }



    public void print(Car car) {
        System.out.println(car);
    }


    private Engine getRandomEngine() {
        String [] engineTypes = {"Diesel", "Gas", "Petrol"};
        Engine engine = new Engine();
        engine.setType(engineTypes[new Random().nextInt(engineTypes.length)]);
        engine.setPower(new Random().nextInt(1000));
        return engine;
    }

    private Color getRandomColor() {
        final Color[] values = Color.values();
        return values[new Random().nextInt(values.length)];
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        return values[new Random().nextInt(values.length)];
    }

    private CarType getRandomCarType() {
        final CarType[] values = CarType.values();
        return values[new Random().nextInt(values.length)];
    }



    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }

    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public static void check(Car car) {
        boolean rightCount = checkCount(car);
        boolean rightPower = checkPower(car);
        if (rightCount && rightPower) {
            System.out.println("The car is ready to be sold.");
        } else {
            if (rightCount && !rightPower) {
                System.out.println("The car has not enough power.");
            } else if (!rightCount && rightPower) {
                System.out.println("The car is absent at the moment.");
            } else {
                System.out.println("The car has not enough power and the car is absent at the moment.");
            }
        }
    }

    private static boolean checkCount(Car car) {
        return car.getCount() > 0;
    }

    private static boolean checkPower(Car car) {
        return car.getEngine().getPower() > 200;
    }
}