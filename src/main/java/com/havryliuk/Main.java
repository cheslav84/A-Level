package com.havryliuk;

import com.havryliuk.container.GenericContainer;
import com.havryliuk.model.Car;
import com.havryliuk.model.CarType;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;
import com.havryliuk.util.AlgorithmUtil;

public class Main {
    public static void main(String[] args) {

        CarArrayRepository repository = new CarArrayRepository();
        CarService service = new CarService(repository);

        GenericContainer<Car> container = new GenericContainer<>();

        Car passengerCar = service.create(CarType.CAR);
        Car truck = service.create(CarType.TRUCK);
        String wrongCar = "Wrong Car";


        container.increaseCount(passengerCar);
        container.increaseCount(truck);

        container.print(passengerCar);
        container.print(truck);
//        container.print(wrongCar);// compilation error

        container.increaseCount(passengerCar, 150);
        container.increaseCount(truck , 20.32);

        container.print(passengerCar);
        container.print(truck);

    }

}
