package com.havryliuk;

import com.havryliuk.container.CarList;
import com.havryliuk.container.CarTree;
import com.havryliuk.model.*;
import com.havryliuk.model.Color;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println(" FIND_MANUFACTURER_BY_PRICE");
        CarList<Car> cars = new CarList<>();
        CarService service = new CarService(new CarArrayRepository());

        Car car1 = service.create(CarType.CAR);
        Car car2 = service.create(CarType.TRUCK);
        Car car3 = service.create(CarType.TRUCK);
        Car car4 = service.create(CarType.CAR);
        Car car5 = service.create(CarType.CAR);
        Car car6 = service.create(CarType.TRUCK);
        Car car7 = service.getCopy(car6);

        car1.setId("1");
        car2.setId("2");
        car3.setId("3");
        car4.setId("4");
        car5.setId("5");
        car6.setId("6");
        car7.setId("7");

        car1.setPrice(1000);
        car2.setPrice(5000);
        car3.setPrice(3000);
        car4.setPrice(2999);
        car5.setPrice(3001);
        car6.setPrice(6000);
        car7.setPrice(6000);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);

        cars.print();

        int price = 3000;
        System.out.printf("\n All manufacturers whose price greater then: %d \n", price);
        service.findManufacturerByPrice(cars, price);

        int priceSum = service.countPriceSum(cars);
        System.out.println("Sum of car prices: "
                + "1000 + 5000 + 3000 + 2999 + 3001 + 6000 + 6000 = "
                + priceSum);

        System.out.println("\n MAP_TO_MAP");
        Map<String, CarType> carTypeMap = service.getCarTypesById(cars);
        for (Map.Entry<String, CarType> entry : carTypeMap.entrySet()) {
            System.out.println("id: " + entry.getKey() + ", car type: " + entry.getValue());
        }

        System.out.println("\n STATISTICS");
        service.statistic(cars);

        System.out.println("\n PRICE_CHECK");
        System.out.println("Check price: is all cars have price greater than 900: "
                + service.priceCheck(cars, 900));

        System.out.println("Check price: is all cars have price greater than 2000: "
                + service.priceCheck(cars, 2000));

        System.out.println("\n MAP_TO_OBJECT");
        Map<String, Object> carParameters = new HashMap<>();
        carParameters.put("CarType", CarType.CAR);
        carParameters.put("Manufacturer", Manufacturer.FORD);
        carParameters.put("Engine", new Engine(250, "Diesel"));
        carParameters.put("Color", Color.BLUE);
        carParameters.put("Price", 2500);
        carParameters.put("Count", 1);
        carParameters.put("Passengers/Load", 4);

        Car car = service.mapToObject.apply(carParameters);
        System.out.println("Car created by parameters: \n" + car);


        System.out.println("\n INNER_LIST");
        List<CarList<Car>> carLists = getRandomCarList(service);
        System.out.println(" Printing inside innerList method (sorting by color):");
        int minPrice = 50_000;
        Map<Color, Integer> carsByColor = service.innerList(carLists, minPrice);

        System.out.println("\n Printing after innerList (filtering by price):");
        for (Map.Entry<Color, Integer> entry : carsByColor.entrySet()) {
            System.out.println("Color: " + entry.getKey() + ", amount: " + entry.getValue());
        }

    }

    private static List<CarList<Car>> getRandomCarList(CarService service) {
        List<CarList<Car>> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CarList<Car> carList = new CarList<>();
            for (int j = 0; j < 3; j++) {
                carList.add(service.create(CarType.CAR));
            }
            cars.add(carList);
        }
        return cars;
    }


}
