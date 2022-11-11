package com.havryliuk.lesson5;

import java.util.Random;

public class ArrayUtils {

    public static int[] getRandomArray (int arrayLength, int minNumber, int maxNumber) {
        checkData(arrayLength, minNumber, maxNumber);
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(minNumber, maxNumber);
        }
        return array;
    }


    public static int getLastMaxIndex(int[] array){
        checkArray(array);
        int maxIndex = array[0];

        if (array.length > 1) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] > maxIndex) {
                    maxIndex = array[i];
                }
            }
        }
        return maxIndex;
    }

    public static void replaceOdd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
    }

    public static boolean isRisingArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i -1]) {
                return false;
            }
        }
        return true;
    }


    private static void checkData(int arrayLength, int minNumber, int maxNumber) {
        if (arrayLength < 1) {
            throw new IllegalArgumentException("Array length can't be " + arrayLength);
        }
        if (maxNumber - minNumber < 1) {
            throw new IllegalArgumentException("The range between minimum and maximum numbers should be at least 1." +
                    "Your range: " + (maxNumber - minNumber));
        }
    }

    private static void checkArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can't be null");
        } else if (array.length == 0){
            throw new IllegalArgumentException("The array is empty.");
        }
    }
}

