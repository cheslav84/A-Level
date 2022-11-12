package com.havryliuk.service;

import com.havryliuk.model.Car;
import com.havryliuk.model.Color;
import com.havryliuk.model.Engine;
import com.havryliuk.model.Manufacturer;

import java.util.Random;


public class CarService {
    public Car create() {
        Manufacturer manufacturer = getRandomManufacturer();
        Engine engine = getRandomEngine();
        Color color = getRandomColor();
        return new Car(manufacturer, engine, color);
    }



    public void print(Car car) {
        System.out.println(car.getManufacturer()
                + "; " + car.getEngine()
                + "; " + car.getColor());
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