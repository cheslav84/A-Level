package com.havryliuk.service;

import java.util.Random;

enum CarColor {
    RED(1),
    GREEN(2),
    BLUE(3);

    int colorCode;

    CarColor(final int colorCode) {
        this.colorCode = colorCode;
    }

    public static CarColor getRandomColor() {
        return CarColor.values()[new Random().nextInt(0, 3)];
    }
}
