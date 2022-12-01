package com.havryliuk.util;

import java.util.Random;

public class RandomGenerator {
    public int generateNumber (){
        return new Random().nextInt(0, 10);
    }
}
