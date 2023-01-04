package com.havryliuk.container;

import com.havryliuk.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getCount(), car2.getCount());
    }
}
