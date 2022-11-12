package com.havryliuk.service;

import com.havryliuk.model.Car;
import com.havryliuk.model.Color;
import com.havryliuk.model.Engine;
import com.havryliuk.model.Manufacturer;

import java.util.Random;


public class CarService {
    public Car create(){
        Manufacturer manufacturer = getRandomManufacturer();
        Engine engine = Engine.getRandomEngine();
        Color color = getRandomColor();
        return new Car(manufacturer, engine, color);
    }

    public Color getRandomColor() {
        final Color[] values = Color.values();
        return values[new Random().nextInt(values.length)];
    }

    public Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        return values[new Random().nextInt(values.length)];
    }

    public void print(Car car) {
        System.out.println("Manufacturer: " + car.getManufacturer()
                + "; Engine: " + car.getEngine()
                + "; Color: " + car.getColor());
    }


}