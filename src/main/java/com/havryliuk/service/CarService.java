package com.havryliuk.service;

import com.havryliuk.exceptions.UserInputException;
import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.util.RandomGenerator;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;


public class CarService {

    private final CarArrayRepository carArrayRepository;


    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }


    public void printManufacturerAndCount(Car car) {
        Optional<Car> carOptional = Optional.ofNullable(car);
        carOptional.map(Car::getManufacturer)
                .ifPresent(System.out::println);
        carOptional.map(Car::getCount)
                .ifPresent(count -> System.out.println("Count: " + count));
    }

    public void printColor(Car car){
        Color color = Optional.ofNullable(car)
                .orElse(create(CarType.TRUCK))
                .getColor();
        System.out.println(color);
    }

    public void checkCount(Car car) {
        Car checkedCar = Optional.ofNullable(car)
                .filter(thisCar -> thisCar.getCount() > 10)
                .orElseThrow(UserInputException::new);
        printManufacturerAndCount(checkedCar);
    }

    public void printEngineInfo(Car car) {
        car = Optional.ofNullable(car)
                .orElseGet(this::createTruckAndInform);
        Optional.ofNullable(car)
                .map(Car::getEngine)
                .ifPresent(System.out::println);
    }

    public void printInfo(Car car) {
        Optional.ofNullable(car)
                .ifPresentOrElse(
                        car1 -> System.out.println(car1),
                        () -> System.out.println(create(CarType.TRUCK))
                );
    }





    private Car createTruckAndInform(){
        Car car = create(CarType.TRUCK);
        System.out.println("New truck have been created.");
        return car;
    }





    public Car create(CarType carType) {
        Manufacturer manufacturer = getRandomManufacturer();
        Engine engine = getRandomEngine();
        Color color = getRandomColor();
        if (carType.equals(CarType.TRUCK)){
            Car truck = new Truck(manufacturer, engine, color, carType);
            carArrayRepository.save(truck);
            return  truck;
        } else if (carType.equals(CarType.CAR)) {
            Car passengerCar = new PassengerCar(manufacturer, engine, color, carType);
            carArrayRepository.save(passengerCar);
            return passengerCar;
        }
        return null;
    }

    public int create(RandomGenerator randomGenerator){
        int numberOfCars = randomGenerator.generateNumber();
        if (numberOfCars == 0){
            return -1;
        }
        for (int i = 0; i <= numberOfCars; i++) {
            Car currentCar = create(getRandomCarType());
            currentCar.setCount(numberOfCars);
            print(currentCar);
        }
        return numberOfCars;
    }

    public boolean areCarsEqual(Car firstCar, Car secondCar){
        return firstCar.hashCode() == secondCar.hashCode() && firstCar.equals(secondCar);
    }

    public void print(Car car) {
        System.out.println(car);
    }

    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }

    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

//    public static void check(Car car) {
//        boolean rightCount = checkCount(car);
//        boolean rightPower = checkPower(car);
//        if (rightCount && rightPower) {
//            System.out.println("The car is ready to be sold.");
//        } else {
//            if (rightCount && !rightPower) {
//                System.out.println("The car has not enough power.");
//            } else if (!rightCount && rightPower) {
//                System.out.println("The car is absent at the moment.");
//            } else {
//                System.out.println("The car has not enough power and the car is absent at the moment.");
//            }
//        }
//    }

//    private static boolean checkCount(Car car) {
//        return car.getCount() > 0;
//    }

    private static boolean checkPower(Car car) {
        return car.getEngine().getPower() > 200;
    }

    private Engine getRandomEngine() {
        String [] engineTypes = {"Diesel", "Gas", "Petrol"};
        Engine engine = new Engine();
        engine.setType(engineTypes[new Random().nextInt(engineTypes.length)]);
        engine.setPower(new Random().nextInt(1000));
        return engine;
    }

    private Color getRandomColor() {
        final Color[] values = Color.values();
        return values[new Random().nextInt(values.length)];
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        return values[new Random().nextInt(values.length)];
    }

    private CarType getRandomCarType() {
        final CarType[] values = CarType.values();
        return values[new Random().nextInt(values.length)];
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

}