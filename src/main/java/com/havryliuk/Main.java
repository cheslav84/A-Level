package com.havryliuk;

import com.havryliuk.model.Car;
import com.havryliuk.service.CarService;

public class Main {
    public static void main(String[] args) {
        Car firstCar = CarService.create();
        Car secondCar = CarService.create();
        Car thirdCar = CarService.create();

        CarService.print(firstCar);
        CarService.print(secondCar);
        CarService.print(thirdCar);
    }
}
