package com.havryliuk.util;

import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CarJsonBuilder {

    private  final CarService carService;
    private static final String CAR = "car";

    public CarJsonBuilder() {
        carService = new CarService(new CarArrayRepository());
    }

    public Optional<Car> buildCar(String fileName) {
        List<Car> carList = null;
        try{
            String data = Files.readString(Paths.get(fileName));
            JSONObject jsonObj = new JSONObject(data);
            carList = new ArrayList<>();
            JSONArray jsonArr = new JSONArray(jsonObj.get(CAR).toString());
            if (jsonArr.length() > 0) {
                for (int i=0; i < jsonArr.length(); i++) {
                    JSONObject obj = jsonArr.getJSONObject(i);
                    carList.add(mapToObject.apply(obj));
                }
            }
        } catch(IOException e){
            System.err.println("File error or I/O error: " + e);
        }
        assert carList != null;
        return Optional.ofNullable(carList.get(0));
    }

    private final Function<JSONObject, Car> mapToObject = obj -> {
        CarType carType = CarType.valueOf(obj.getString("carType"));
        Car car;
        if (carType.equals(CarType.CAR)) {
            car = getPassengerCar(obj);
        } else {
            car = getTruck(obj);
        }
        car.setId(obj.getString( "id"));
        car.setPrice(obj.getInt("price"));
        car.setCount(obj.getInt("count"));
        car.setManufacturer(Manufacturer.valueOf(obj.getString( "manufacturer")));
        car.setColor(Color.valueOf(obj.getString( "color")));
        car.setEngine(getEngine(obj));
        return car;
    };

    private PassengerCar getPassengerCar(JSONObject obj) {
        PassengerCar car = (PassengerCar) carService.create(CarType.CAR);
        car.setPassengerCount(obj.getInt("passengerCount"));
        return car;
    }

    private Truck getTruck(JSONObject obj) {
        Truck car = (Truck) carService.create(CarType.CAR);
        car.setLoadCapacity(obj.getInt( "loadCapacity"));
        return car;
    }

    private Engine getEngine(JSONObject obj) {
        Engine engine = new Engine();
        JSONObject engineElem = obj.getJSONObject( "engine");
        engine.setPower(engineElem.getInt( "power"));
        engine.setType(engineElem.getString( "type"));
        return engine;
    }

}
