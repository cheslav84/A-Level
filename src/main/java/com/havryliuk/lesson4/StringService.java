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


    /**Task 3*/
    public static boolean containsSubString(String string, String subString) {
        checkForNull(string);
        checkForNull(subString);
        return string.contains(subString);
    }


    /**Task 4*/
    public static boolean containsSubStringIgnoreCase(String string, String subString) {
        checkForNull(string);
        checkForNull(subString);
        return string
                .toLowerCase()
                .contains(subString.toLowerCase());
    }


    /**Task 5*/
    public static boolean matchStartsOfString(String string, String startOfString) {
        checkForNull(string);
        checkForNull(startOfString);
        return string.startsWith(startOfString);
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
