package com.havryliuk.model;

public class PassengerCar extends Car {
    private int passengerCount;

    public PassengerCar(Manufacturer manufacturer, Engine engine, Color color, CarType carType) {
        super(manufacturer, engine, color, carType);
        setCarType(CarType.CAR);
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
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

        return passengerCount == that.passengerCount;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerCount;
        return result;
    }

    @Override
    public String toString() {
        return getCarType() + ": " +  super.toString();
    }

    @Override
    public int compareTo(Car o) {
        return super.getId().compareTo(o.getId());
    }
}
