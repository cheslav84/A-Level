package com.havryliuk.lesson5;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class ArrayRandomFillerTest {


    @Test
    void testGetRandomArrayIllegalArguments(){
        assertThrows(IllegalArgumentException.class, () ->
                ArrayUtils.getRandomArray(-1, 3, 6));

        assertThrows(IllegalArgumentException.class, () ->
                ArrayUtils.getRandomArray(0, 3, 6));

        assertThrows(IllegalArgumentException.class, () ->
            ArrayUtils.getRandomArray(2, 0, 0));

        assertThrows(IllegalArgumentException.class, () ->
            ArrayUtils.getRandomArray(5, 2, 1));
    }



    @Test
    void testGetRandomArrayLength(){
        assertEquals(1, ArrayUtils.getRandomArray(1, 1, 2).length);
        assertEquals(5, ArrayUtils.getRandomArray(5, 1, 2).length);
    }


    @Test
    void testGetLastMaxIndexIllegalArguments(){

        assertThrows(IllegalArgumentException.class, () ->
                ArrayUtils.getLastMaxIndex(null));

        assertThrows(IllegalArgumentException.class, () ->
                ArrayUtils.getLastMaxIndex(new int[]{}));
    }

    @Test
    void testGetLastMaxIndex(){
        assertEquals(1, ArrayUtils.getLastMaxIndex(new int[]{1}));
        assertEquals(-5, ArrayUtils.getLastMaxIndex(new int[]{-5}));

        assertEquals(3, ArrayUtils.getLastMaxIndex(new int[]{3, 2, -2, 1, 3}));
        assertEquals(3, ArrayUtils.getLastMaxIndex(new int[]{1, 2, -2, 1, 3}));
        assertEquals(3, ArrayUtils.getLastMaxIndex(new int[]{1, 2, -2, 3, 1}));
        assertEquals(3, ArrayUtils.getLastMaxIndex(new int[]{3, 2, -2, 1, 1}));
    }




}