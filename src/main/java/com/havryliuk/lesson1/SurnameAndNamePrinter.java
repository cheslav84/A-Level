package com.havryliuk.lesson1;

public class SurnameAndNamePrinter {
    public static void main(String[] args) {
        String surname = "Havryliuk";
        String name = "Viacheslav";

        printSurnameAndName(surname, name);
    }

    private static void printSurnameAndName(String surname, String name){
        System.out.printf("My name is %s %s", surname, name);
    }
}
