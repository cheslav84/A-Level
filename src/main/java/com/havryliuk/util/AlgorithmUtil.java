package com.havryliuk.util;

import com.havryliuk.model.Car;

public class AlgorithmUtil {


    public static void sortCars(Car[] cars) {

        for (int i = 0; i < cars.length - 1; i++) {
            for (int j = 1; j < cars.length - i; j++) {
                if (cars[j - 1].compareTo(cars[j]) > 0) {
                    swap(cars, j);
                }
            }
        }
    }

    private static void swap(Car[] cars, int j) {
        Car temp = cars[j];
        cars[j] = cars[j - 1];
        cars[j - 1] = temp;
    }


    public static int searchCar(Car [] cars, Car car){
        int start = 0;
        int end = cars.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (car.getId().compareTo(cars[mid].getId()) == 0) {
                return mid;
            }
            if (car.getId().compareTo(cars[mid].getId()) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }



//    public static int searchCar(Car [] cars, Car car){
//        int start = 0;
//        int end = cars.length - 1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (car == cars[mid]) {
//                return mid;
//            }
//            if (car < cars[mid]) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }

    public static int binarySearch(int [] arr, int elem){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (elem == arr[mid]) {
                return mid;
            }
            if (elem < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


}
