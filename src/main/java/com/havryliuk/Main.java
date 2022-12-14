package com.havryliuk;

import com.havryliuk.model.Car;
import com.havryliuk.model.CarType;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;
import com.havryliuk.util.AlgorithmUtil;

public class Main {
    public static void main(String[] args) {
        CarArrayRepository repository = new CarArrayRepository();
        CarService service = new CarService(repository);

        Car car1 = service.create(CarType.CAR);
        Car truck1 = service.create(CarType.TRUCK);
        Car car2 = service.create(CarType.CAR);
        Car truck2 = service.create(CarType.TRUCK);
        Car car3 = service.create(CarType.CAR);
        Car truck3 = service.create(CarType.TRUCK);
        Car car4 = service.create(CarType.CAR);
        Car truck4 = service.create(CarType.TRUCK);

        Car [] cars = {car1, truck1, car2, truck2, car3, truck3, car4, truck4};

        System.out.println("Before sorting~~");
        printCarsId(cars);
        AlgorithmUtil.sortCars(cars);
        System.out.println("\nAfter sorting~~");
        printCarsId(cars);

        System.out.println("\nCAR SEARCHING");
        int carPosition = AlgorithmUtil.searchCar(cars, car3);
        Car searchedCar = cars[carPosition];
        System.out.println("The car need to be found in array: " + car3);
        System.out.println("The car that has been found      : " + searchedCar);
    }



    private static void printCarsId(Car [] cars) {
        System.out.println();
        for (Car car : cars) {
            System.out.println("Car id: " + car.getId());
        }
    }
}
