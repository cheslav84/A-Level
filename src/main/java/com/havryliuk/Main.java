package com.havryliuk;

import com.havryliuk.container.CarList;
import com.havryliuk.container.CarTree;
import com.havryliuk.model.Car;
import com.havryliuk.model.CarType;
import com.havryliuk.model.Engine;
import com.havryliuk.model.Manufacturer;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // PART 1

        CarTree<Car> cars = new CarTree<>();
        CarService service = new CarService(new CarArrayRepository());

        Car car1 = service.create(CarType.CAR);
        Car car2 = service.create(CarType.TRUCK);
        Car car3 = service.create(CarType.TRUCK);
        Car car4 = service.create(CarType.CAR);
        Car car5 = service.create(CarType.CAR);
        Car car6 = service.create(CarType.TRUCK);
        car1.restoreCount(6);
        car2.restoreCount(2);
        car3.restoreCount(5);
        car4.restoreCount(7);
        car5.restoreCount(4);
        car6.restoreCount(1);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        System.out.println(cars);

        //          6         //           car1
        //         / \        //           /  \
        //        2   7       //         car2  car4
        //       / \          //         /  \
        //      1   5         //      car6   car3
        //         /          //       /
        //        4           //     car5

        System.out.println("Count sum of car 1 (root element): 6 + 2 + 1 + 5 + 4 + 7 = " + cars.calculateCount(car1));
        System.out.println("Count sum of car 2: 2 + 1 + 5 + 4 = " + cars.calculateCount(car2));
        System.out.println("Count sum of car 5: " + cars.calculateCount(car5));


        // PART 2

        CarList<Car> carList = new CarList<>();
        car1.setManufacturer(Manufacturer.AUDI);  //count: 6
        car2.setManufacturer(Manufacturer.HONDA); //count: 2
        car3.setManufacturer(Manufacturer.BMW);   //count: 5
        car4.setManufacturer(Manufacturer.AUDI);  //count: 7
        car5.setManufacturer(Manufacturer.FORD);  //count: 4
        car6.setManufacturer(Manufacturer.HONDA); //count: 1

        car1.getEngine().setPower(100); //AUDI
        car2.getEngine().setPower(300); //HONDA
        car3.getEngine().setPower(200); //BMW
        car4.getEngine().setPower(100); //AUDI
        car5.getEngine().setPower(300); //FORD
        car6.getEngine().setPower(100); //HONDA

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);

        Map<Manufacturer, Integer> carCountByManufacturer = service.getCarCountsByManufacturer(carList);
        System.out.println("AUDI: 6 + 7 = " + carCountByManufacturer.get(Manufacturer.AUDI));
        System.out.println("HONDA: 2 + 1 = " + carCountByManufacturer.get(Manufacturer.HONDA));
        System.out.println("BMW: 5 = " + carCountByManufacturer.get(Manufacturer.BMW));
        System.out.println("FORD: 4 = " + carCountByManufacturer.get(Manufacturer.FORD));

        Map<Integer, List<Car>> carCountsByEnginePower = service.getCarsByEnginePower(carList);

        System.out.println("Engine power 100:");
        carCountsByEnginePower.get(100)
                .forEach(System.out::println);

        System.out.println("Engine power 200:");
        carCountsByEnginePower.get(200)
                .forEach(System.out::println);

        System.out.println("Engine power 300:");
        carCountsByEnginePower.get(300)
                .forEach(System.out::println);

    }

}
