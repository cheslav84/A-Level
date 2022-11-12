package com.havryliuk;

import com.havryliuk.model.Car;
import com.havryliuk.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarService service = new CarService();

        Car firstCar = service.create();
        Car secondCar = service.create();
        Car thirdCar = service.create();

        service.print(firstCar);
        service.print(secondCar);
        service.print(thirdCar);
    }
}
