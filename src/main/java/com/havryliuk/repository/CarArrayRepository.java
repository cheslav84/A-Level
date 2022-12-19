package com.havryliuk.repository;

import com.havryliuk.model.Car;
import com.havryliuk.model.Color;

public class CarArrayRepository implements CarRepository<Car, Color> {
    private static Car[] cars = new Car[10];


    @Override
    public void save(final Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            final int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }

    @Override
    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    @Override
    public Car getById(final String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index,
                    cars.length - (index + 1));
        }
    }

    @Override
    public void insert(int index, final Car car) {

        // Example: insert(7, Car car);
        // If 7 is not empty -> need to transfer existed values and put new value to 7 index
        // If 7 is empty -> need to check bounds
        // if we have empty cell before index -> use first empty cell insted of
    }

    @Override
    public void updateColor(final String id, final Color color) {
        final Car car = getById(id);
        if (car != null) {
            car.setColor(color);
        }
    }

    private int foundLength() {
        int newLength = 0;
        for (Car car : cars) {
            if (car != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    private int putCar(final Car car) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = car;
                break;
            }
        }
        return index;
    }

    private void increaseArray() {
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }
}