package com.havryliuk.service;

import java.util.Random;

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
