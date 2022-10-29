package com.havryliuk.lesson2;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        int decimalNumber = 19;

        int binaryNumber = decimalToBinary(decimalNumber);

        System.out.println(binaryNumber);
    }

    private static int decimalToBinary(int number) {
        int reminder;
        int binaryNumber = 0;
        int power = 1;

        while (number != 0) {
            reminder = number % 2;
            number /= 2;
            binaryNumber += reminder * power;
            power *= 10;
        }

        return binaryNumber;
    }

}
