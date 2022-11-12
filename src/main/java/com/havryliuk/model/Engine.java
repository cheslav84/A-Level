package com.havryliuk.model;

import java.util.Random;

public enum Engine {
    DIESEL(1),
    GAS(2),
    PETROL(3);

    int engineCode;

    Engine(final int engineCode) {
        this.engineCode = engineCode;
    }

    public static Engine getRandomEngine() {
        return Engine.values()[new Random().nextInt(0, 3)];
    }
}
