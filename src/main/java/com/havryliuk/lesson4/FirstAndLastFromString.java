package com.havryliuk.lesson4;

public class FirstAndLastFromString {
    public static void main(String[] args) {
        String someString = "Hello World!";

        printFirstAndLastSymbol(someString);
    }

    private static void printFirstAndLastSymbol(String someString) {
        System.out.printf("First letter of string \"%s\" is \"%s\", " +
                "and last letter is \"%s\".", someString, getFirstLetter(someString), getLastLetter(someString));
    }

    private static String getFirstLetter(String someString) {
        StringBuilder sb = new StringBuilder(someString);
        String reversed = sb.reverse().toString();
        return getLastLetter(reversed);
    }

    private static String getLastLetter(String someString) {
        return someString.substring(someString.length()-1);
    }

}
