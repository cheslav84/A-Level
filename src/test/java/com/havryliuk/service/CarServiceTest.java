package com.havryliuk.service;

import com.havryliuk.model.Car;
import com.havryliuk.model.Color;
import com.havryliuk.model.Engine;
import com.havryliuk.model.Manufacturer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.util.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private static RandomGenerator randomGenerator;
    private static CarService carService;
    private static CarArrayRepository carRepository;

    static {
        randomGenerator = Mockito.mock(RandomGenerator.class);
    }

    public static Stream<Arguments> testCasesPositive () {
        return Stream.of(
                Arguments.of (0, -1),
                Arguments.of (1, 1),
                Arguments.of (5, 5),
                Arguments.of (10, 10)
        );
    }

    public static Stream<Arguments> testCasesNegative () {
        return Stream.of(
                Arguments.of (0, 0),
                Arguments.of (1, 0),
                Arguments.of (5, 6),
                Arguments.of (10, 9)
        );
    }


    @BeforeEach
    void setUp(){
        carRepository = Mockito.mock(CarArrayRepository.class);
        carService = new CarService(carRepository);
    }


    @ParameterizedTest
    @MethodSource("testCasesPositive")
    void createRandomNumberOfCarsPositive(int random, int expected){
        Mockito.when(randomGenerator.generateNumber()).thenReturn(random);
        assertEquals(expected, carService.create(randomGenerator));
    }


    @ParameterizedTest
    @MethodSource("testCasesNegative")
    void createRandomNumberOfCarNegative(int random, int expected){
        Mockito.when(randomGenerator.generateNumber()).thenReturn(random);
        assertNotEquals(expected, carService.create(randomGenerator));
    }


    @Test
    void createCarNotNullParameters(){
        Car car = carService.create();
        assertNotNull(car.getColor());
        assertNotNull(car.getManufacturer());
        assertNotNull(car.getEngine());
    }


    @Test
    void findCarByIdPositive() {
        Car car = carService.create();
        car.setManufacturer(Manufacturer.HONDA);
        car.setEngine(new Engine(140,"Diesel" ));
        car.setColor(Color.RED);
        Mockito.when(carRepository.getById("15")).thenReturn(car);
        assertEquals(car, carRepository.getById("15"));
    }


    @Test
    void findCarByIdNegative() {
        assertNull(carRepository.getById(null));
        assertNull(carRepository.getById(""));
        assertNull(carRepository.getById("   "));
    }





}