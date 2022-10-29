package com.havryliuk.lesson2;

public class TriangleArea {
    public static void main(String[] args) {
        int lengthAB = 15;
        int lengthBC = 10;
        int lengthCA = 25;

        checkData(lengthAB, lengthBC, lengthCA);

        double triangleArea = getTriangleArea(lengthAB, lengthBC, lengthCA);

        System.out.println(triangleArea);
    }

    private static double getTriangleArea(int lengthAB, int lengthBC, int lengthCA) {
        double semiperimeter = (double) (lengthAB + lengthBC + lengthCA) / 2;
        return Math.sqrt(semiperimeter
                * (semiperimeter - lengthAB)
                * (semiperimeter - lengthBC)
                * (semiperimeter - lengthCA)
        );
    }


    private static void checkData(int lengthAB, int lengthBC, int lengthCA) {
        checkPositiveness(lengthAB);
        checkPositiveness(lengthBC);
        checkPositiveness(lengthCA);

        checkTriangle(lengthAB, lengthBC, lengthCA);
    }

    private static void checkPositiveness(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number " + number + "can't be negative.");
        }
    }

    private static void checkTriangle(int lengthAB, int lengthBC, int lengthCA) {
        if (lengthAB + lengthBC < lengthCA ||
                lengthBC + lengthCA < lengthAB ||
                lengthCA + lengthAB < lengthBC) {
            throw new IllegalArgumentException("Such triangle doesn't exist! Check input data.");
        }
    }



}
