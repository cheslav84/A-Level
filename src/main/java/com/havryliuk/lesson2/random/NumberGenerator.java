package com.havryliuk.lesson2.random;

public class NumberGenerator {

    private NumberGenerator() {
    }

    public static int getNumber () {
        return (int) (Math.random() * 200) - 100;
    }
}
