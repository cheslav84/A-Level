package com.havryliuk.model;

import com.havryliuk.service.CountRestore;

import java.util.Random;
import java.util.UUID;
public abstract class Car implements CountRestore, Comparable<Car> {
    private String id;
    private Manufacturer manufacturer;
    private Engine engine;
    private Color color;

    private CarType carType;
    private int count;
    private int price;

    protected Car(Manufacturer manufacturer, Engine engine, Color color, CarType carType) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = new Random().nextInt(20_000, 100_000);
        this.id = UUID.randomUUID().toString();
        this.carType = carType;
    }


    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (manufacturer != car.manufacturer) return false;
        if (engine != null ? !engine.equals(car.engine) : car.engine != null) return false;
        if (color != car.color) return false;
        return carType == car.carType;
    }

    @Override
    public int hashCode() {
        int result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return getManufacturer()
                + "; " + getEngine()
                + "; " + getColor()
                + "; Price: " + price
                + "; Count: " + count;


//        return "id: " + id
//                + "; " + getManufacturer()
//                + "; " + getEngine()
//                + "; " + getColor()
//                + "; Price: " + price
//                + "; Count: " + count;
    }


}
