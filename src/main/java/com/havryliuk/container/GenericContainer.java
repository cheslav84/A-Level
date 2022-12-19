package com.havryliuk.container;

import com.havryliuk.model.Car;

import java.util.Random;

public class GenericContainer <T extends Car> {

    public void print(T car) {
        System.out.println(car);
    }

    public void increaseCount(T car) {
        car.setCount(new Random().nextInt(100, 300));
    }

    public void increaseCount(T car, Number value) {

        car.setCount(value.intValue());
    }

}
