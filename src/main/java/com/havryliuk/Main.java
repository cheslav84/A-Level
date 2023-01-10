package com.havryliuk;

import com.havryliuk.model.Car;
import com.havryliuk.util.CarJsonBuilder;
import com.havryliuk.util.CarXmlDomBuilder;


public class Main {
    public static void main(String[] args) {

        String xmlFileName = "src/main/resources/car.xml";
        CarXmlDomBuilder carXmlDomBuilder = new CarXmlDomBuilder();
        Car carFromXml = carXmlDomBuilder.buildCar(xmlFileName).orElseThrow();
        System.out.println(carFromXml);

        String jsonFileName = "src/main/resources/car.json";
        CarJsonBuilder carJsonDomBuilder = new CarJsonBuilder();
        Car carFromJson = carJsonDomBuilder.buildCar(jsonFileName).orElseThrow();
        System.out.println(carFromJson);

    }

}
