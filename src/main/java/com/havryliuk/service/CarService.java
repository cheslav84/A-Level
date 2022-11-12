package com.havryliuk.service;

import com.havryliuk.model.Car;

public class CarService {
    public Car create(){
        String manufacturer = CarManufacturer.getRandomManufacturer().toString();
        String engine = CarEngine.getRandomEngine().toString();
        String color = CarColor.getRandomColor().toString();
        return new Car(manufacturer, engine, color);
    }

    public void print(Car car) {
        System.out.println("Manufacturer: " + car.getManufacturer()
                + "; Engine: " + car.getEngine()
                + "; Color: " + car.getColor());
    }


}