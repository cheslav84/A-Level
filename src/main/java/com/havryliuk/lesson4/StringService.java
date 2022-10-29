package com.havryliuk.lesson4;

public class StringService {

    /**Task 1*/
    public static void printFirstAndLastSymbol(String someString) {
        checkForNull(someString);
        checkForEmptyString(someString);

        System.out.printf("First letter of string \"%s\" is \"%s\", " +
                "and last letter is \"%s\".%n", someString, getFirstLetter(someString), getLastLetter(someString));
    }

    private static String getFirstLetter(String someString) {
        StringBuilder sb = new StringBuilder(someString);
        String reversed = sb.reverse().toString();
        return getLastLetter(reversed);
    }

    private static String getLastLetter(String someString) {
        return someString.substring(someString.length()-1);
    }


    /**Task 2*/
    public static boolean matchEndOfString(String string, String endOfString) {
        checkForNull(string);
        checkForNull(endOfString);
        return string.endsWith(endOfString);
    }







    private static void checkForNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input data can't be null!");
        }
    }

    private static void checkForEmptyString(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Input data can't be empty!");
        }
    }
}
