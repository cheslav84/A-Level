package com.havryliuk.lesson4;

public class Main {
    public static void main(String[] args) {

        /**Task 1*/
        StringService.printFirstAndLastSymbol("Hello World!");


        /**Task 2*/
        System.out.println(StringService.matchEndOfString("Java Exercises", "se"));
        System.out.println(StringService.matchEndOfString("Java Exercise", "se"));
        System.out.println(StringService.matchEndOfString("Java Exercise", "ses"));




    }

}