package com.havryliuk;

import com.havryliuk.model.Car;
import com.havryliuk.model.CarType;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;

public class Main {
    public static void main(String[] args) {
        CarArrayRepository repository = new CarArrayRepository();
        CarService service = new CarService(repository);

        Car passengerCar = service.create(CarType.CAR);
        passengerCar.restoreCount(100);
        service.print(passengerCar);

        Car truck = service.create(CarType.TRUCK);
        truck.restoreCount(50);
        service.print(truck);

    }
}
