package com.havryliuk.service;

import java.util.Random;

enum CarEngine {
    DIESEL(1),
    GAS(2),
    PETROL(3);

    int engineCode;

    CarEngine(final int engineCode) {
        this.engineCode = engineCode;
    }

    public static CarEngine getRandomEngine() {
        return CarEngine.values()[new Random().nextInt(0, 3)];
    }
}
