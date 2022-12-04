package com.havryliuk.model;

public class PassengerCar extends Car {
    private int loadCapacity;

    public PassengerCar(Manufacturer manufacturer, Engine engine, Color color, CarType carType) {
        super(manufacturer, engine, color, carType);
        setCarType(CarType.CAR);
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void restoreCount(int count) {
        setCount(count);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCar that = (PassengerCar) o;

        return loadCapacity == that.loadCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + loadCapacity;
        return result;
    }

    @Override
    public String toString() {
        return getCarType() + ": " +  super.toString();
    }

}
