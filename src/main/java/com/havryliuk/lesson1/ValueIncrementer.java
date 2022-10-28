package com.havryliuk.lesson1;

public class ValueIncrementer {
    public static void main(String[] args) {
        int steps = 10;
        int value = 5;
        int interval = 2;

        incrementValue(steps, value, interval);//todo - ask the question
    }

    private static void incrementValue(int steps, int value, int interval) {
        for (int i = 0; i <= steps; i++) {
            printValue(i, value);
            value += interval;
        }
    }

    private static void printValue (int step, int value) {
        System.out.printf("Step %d, value %d\n", step, value);
    }
}
