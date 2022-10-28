package com.havryliuk.lesson2.random;

public class EvenNumber {
    public static void main(String[] args) {
        int number = NumberGenerator.getNumber();
        boolean isEven  = isNumberEven(number);
        System.out.println(isEven);
    }

    private static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }

}
