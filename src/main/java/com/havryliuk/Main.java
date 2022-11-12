package com.havryliuk;

import com.havryliuk.model.Car;
import com.havryliuk.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService service = new CarService();

        Car firstCar = service.create();
        Car secondCar = service.create();
        Car thirdCar = service.create();
        thirdCar.setCount(0);

        service.print(firstCar);
        CarService.check(firstCar);
        System.out.println();
        service.print(secondCar);
        CarService.check(secondCar);
        System.out.println();
        service.print(thirdCar);
        CarService.check(thirdCar);

    }
}
