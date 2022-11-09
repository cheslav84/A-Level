package com.havryliuk.service;

import com.havryliuk.model.Car;

import java.util.Random;

public class CarService {
    public static Car create(){
        String manufacturer = CarManufacturer.getRandomManufacturer().toString();
        String engine = CarEngine.getRandomEngine().toString();
        String color = CarColor.getRandomColor().toString();
        return new Car(manufacturer, engine, color);
    }

    public static void print(Car car) {
        System.out.println("Manufacturer: " + car.getManufacturer()
                + "; Engine: " + car.getEngine()
                + "; Color: " + car.getColor());
    }




    enum CarManufacturer{
        AUDI(1),
        BMW(2),
        CHEVROLET(3),
        FORD(4),
        HONDA(5),
        JAGUAR(6);

        int productionCode;

        CarManufacturer (final int productionCode) {
            this.productionCode = productionCode;
        }

        public static CarManufacturer getRandomManufacturer () {
            return CarManufacturer.values()[new Random().nextInt(0, 6)];
        }
    }

    enum CarEngine{
        DIESEL(1),
        GAS(2),
        PETROL(3);

        int engineCode;

        CarEngine (final int engineCode) {
            this.engineCode = engineCode;
        }

        public static CarEngine getRandomEngine () {
            return CarEngine.values()[new Random().nextInt(0, 3)];
        }
    }

    enum CarColor{
        RED(1),
        GREEN(2),
        BLUE(3);

        int colorCode;

        CarColor (final int colorCode) {
            this.colorCode = colorCode;
        }

        public static CarColor getRandomColor () {
            return CarColor.values()[new Random().nextInt(0, 3)];
        }
    }

}