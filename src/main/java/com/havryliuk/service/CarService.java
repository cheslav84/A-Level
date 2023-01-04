package com.havryliuk.service;

import com.havryliuk.container.CarList;
import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.util.RandomGenerator;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class CarService {

    private final CarArrayRepository carArrayRepository;

    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }



    public Map<Color, Integer> innerList (List<CarList<Car>> cars, int price) {
       return cars.stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Car::getColor))
                .peek(System.out::println)
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.groupingBy(Car::getColor,
                        Collectors.summingInt(Car::getCount))
                );
    }

    public Function<Map<String, Object>, Car> mapToObject = map -> {
        CarType carType = (CarType) map.get("CarType");
        Car car;
        if (carType.equals(CarType.CAR)) {
            car = getPassengerCar(map);
        } else {
            car = getTruck(map);
        }
        car.setManufacturer((Manufacturer) map.get("Manufacturer"));
        car.setEngine((Engine) map.get("Engine"));
        car.setColor((Color) map.get("Color"));
        car.setPrice((int) map.get("Price"));
        car.setCount((int) map.get("Count"));
        return car;
    };

    private PassengerCar getPassengerCar(Map<String, Object> map) {
        PassengerCar car = (PassengerCar) this.create(CarType.CAR);
        car.setPassengerCount((int) map.get("Passengers/Load"));
        return car;
    }


    private Truck getTruck(Map<String, Object> map) {
        Truck car = (Truck) this.create(CarType.CAR);
        car.setLoadCapacity((int) map.get("Passengers/Load"));
        return car;
    }



    public boolean priceCheck (CarList<Car> cars, int price) {
      Predicate<Car> priceCheck = c -> c.getPrice() > price;
      return cars.stream()
              .allMatch(priceCheck);
    }



    public void statistic (CarList<Car> cars) {
        DoubleSummaryStatistics stat = cars.stream()
                .map(Car::getPrice)
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
        System.out.println(stat);
    }

    public Map<String, CarType> getCarTypesById (CarList<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getManufacturer)
                ).distinct()
                .collect(Collectors.toMap(
                        Car::getId,
                        Car::getCarType,
                        (c1, c2) -> c1,
                        LinkedHashMap::new));
}


    public void findManufacturerByPrice (CarList<Car> cars, int price) {
        cars.stream()
                .filter(car -> car.getPrice() > price)
                .map(Car::getManufacturer)
                .forEach(System.out::println);
    }

    public int countPriceSum(CarList<Car> cars) {
        return cars.stream()
                .map(Car::getPrice)
                .reduce(0, Integer::sum);
    }


    public Map<Manufacturer, Integer> getCarCountsByManufacturer (CarList<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer,
                Collectors.summingInt(Car::getCount)));
    }



    public Map<Integer, List<Car>> getCarsByEnginePower (CarList<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(car -> car.getEngine().getPower()));
    }


    public Car create(CarType carType) {
        Manufacturer manufacturer = getRandomManufacturer();
        Engine engine = getRandomEngine();
        Color color = getRandomColor();
        if (carType.equals(CarType.CAR)){
            return new  PassengerCar(manufacturer, engine, color, carType);
        } else if (carType.equals(CarType.TRUCK)) {
            return new Truck(manufacturer, engine, color, carType);
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



    public void print(Car car) {
        System.out.println(car);
    }


    public Car getCopy(Car car) {
        Car copy = this.create(car.getCarType());
        copy.setEngine(car.getEngine());
        copy.setManufacturer(car.getManufacturer());
        copy.setCount(car.getCount());
        copy.setPrice(car.getPrice());
        copy.setColor(car.getColor());
        copy.setId(car.getId());
        return copy;
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

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public static void check(Car car) {
        boolean rightCount = checkCount(car);
        boolean rightPower = checkPower(car);
        if (rightCount && rightPower) {
            System.out.println("The car is ready to be sold.");
        } else {
            if (rightCount && !rightPower) {
                System.out.println("The car has not enough power.");
            } else if (!rightCount && rightPower) {
                System.out.println("The car is absent at the moment.");
            } else {
                System.out.println("The car has not enough power and the car is absent at the moment.");
            }
        }
    }

    private static boolean checkCount(Car car) {
        return car.getCount() > 0;
    }

    private static boolean checkPower(Car car) {
        return car.getEngine().getPower() > 200;
    }
}