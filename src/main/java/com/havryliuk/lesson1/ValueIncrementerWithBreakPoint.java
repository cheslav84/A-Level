package com.havryliuk.lesson1;

public class ValueIncrementerWithBreakPoint {
    public static void main(String[] args) {
        int steps = 10;
        int ignoreNumber = 3;
        int breakPoint = 6;

        incrementSteps(steps, ignoreNumber, breakPoint);

    }

    private static void incrementSteps(int steps, int ignoreNumber, int breakPoint) {
        for (int i = 0; i <= steps; i++) {
            if (i == ignoreNumber)
                continue;

            if (i == breakPoint)
                break;

            printValue(i);
        }
    }

    private static void printValue (int value) {
        System.out.printf("Step %d\n", value);
    }
}