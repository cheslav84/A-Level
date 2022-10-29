package com.havryliuk.lesson4;

public class Main {
    public static void main(String[] args) {

        /**Task 1*/
        StringService.printFirstAndLastSymbol("Hello World!");


        /**Task 2*/
        System.out.println(StringService.matchEndOfString("Java Exercises", "se"));
        System.out.println(StringService.matchEndOfString("Java Exercise", "se"));
        System.out.println(StringService.matchEndOfString("Java Exercise", "ses"));


        /**Task 3*/
        System.out.println(StringService.containsSubString("Stephen Edwin King", "Walter Winchell"));
        System.out.println(StringService.containsSubString("Stephen Edwin King", "Edwin Ki"));
        System.out.println(StringService.containsSubString("Stephen Edwin King", "EdwinKing"));
        System.out.println(StringService.containsSubString("Stephen Edwin King", "Edwin"));
        System.out.println(StringService.containsSubString("Stephen Edwin King", " "));

        /**Task 4*/
        System.out.println(StringService.containsSubStringIgnoreCase("Stephen Edwin King", "Walter Winchell"));
        System.out.println(StringService.containsSubStringIgnoreCase("Stephen Edwin King", "stephen edwin king"));

        /**Task 5*/
        System.out.println(StringService.matchStartsOfString("Red is favorite color", "Red"));
        System.out.println(StringService.matchStartsOfString("Orange is also my favorite color.", "Red"));
        System.out.println(StringService.matchStartsOfString("Red is favorite color", "Redis"));

    }

}