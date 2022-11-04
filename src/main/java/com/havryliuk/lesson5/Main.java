package com.havryliuk.lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1: Maximum last index");
        int[] array = ArrayUtils.getRandomArray(12, -15, 15);
        System.out.println(Arrays.toString(array));
        System.out.println(ArrayUtils.getLastMaxIndex(array));
        System.out.println();

        System.out.println("Task 2: Replace odd elements");
        array = ArrayUtils.getRandomArray(8, 1, 10);
        System.out.println(Arrays.toString(array));
        ArrayUtils.replaceOdd(array);
        System.out.println(Arrays.toString(array));
        System.out.println();

        System.out.println("Task 3: Rising array");
        array = ArrayUtils.getRandomArray(4, 10, 99);
        System.out.println(Arrays.toString(array));
        System.out.println(ArrayUtils.isRisingArray(array));
        System.out.println();

        System.out.println("Task 4: Average value");
        int[] array1 = ArrayUtils.getRandomArray(5, 0, 5);
        int[] array2 = ArrayUtils.getRandomArray(5, 0, 5);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        double average1 = Arrays.stream(array1).average().getAsDouble();
        double average2 = Arrays.stream(array2).average().getAsDouble();
        printComparisonResults(average1, average2);

    }

    private static void printComparisonResults(double value1, double value2){
        if (value1 < value2) {
            System.out.printf("%.2f < %.2f: average value of the first array is less then average value of the second one.", value1, value2);
        } else if (value1 > value2) {
            System.out.printf("%.2f > %.2f: average value of the first array is more then average value of the second one.", value1, value2);
        } else {
            System.out.printf("%.2f = %.2f: average values are equals in both arrays.", value1, value2);
        }

    }
}
