package com.havryliuk.lesson2.random;

public class MinimumAbsNumber {
    public static void main(String[] args) {
        int numOne = NumberGenerator.getNumber();
        int numTwo = NumberGenerator.getNumber();
        int numThree = NumberGenerator.getNumber();

        int minAbsNumber = getMinAbsNumber(numOne, numTwo, numThree);

        System.out.println(minAbsNumber);
    }

    private static int getMinAbsNumber(int numOne, int numTwo, int numThree) {
        numOne = Math.abs(numOne);
        numTwo = Math.abs(numTwo);
        numThree = Math.abs(numThree);
        return (numOne <= numTwo && numOne <= numThree) ? numOne
                : (numTwo <= numThree) ? numTwo
                : numThree;
    }



}
