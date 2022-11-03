package com.havryliuk.lesson5;

import java.util.Random;

public class ArrayRandomFiller {

    public static int[] getRandomArray (int arrayLength, int minNumber, int maxNumber) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(minNumber, maxNumber);
        }
        return array;
    }
}
