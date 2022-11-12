package com.havryliuk.model;

public enum Manufacturer {
    AUDI,
    BMW,
    CHEVROLET,
    FORD,
    HONDA,
    JAGUAR;
    @Override
    public String toString() {
        return "Manufacturer: " + this.name();
    }
}
