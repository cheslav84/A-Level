package com.havryliuk.util;

import com.havryliuk.model.*;
import com.havryliuk.repository.CarArrayRepository;
import com.havryliuk.service.CarService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class CarXmlDomBuilder {

    private final CarService carService;

    private DocumentBuilder docBuilder;

    public CarXmlDomBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        carService = new CarService(new CarArrayRepository());
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Parser configuration fault: " + e);
        }
    }

    public Optional<Car> buildCar(String fileName) {
        Car car = null;

        try {
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            car = mapToObject.apply(root);
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
        return Optional.ofNullable(car);
    }

    private final Function<Element, Car> mapToObject = root -> {
        CarType carType = CarType.valueOf(getElementTextContent(root, "carType"));
        Car car;
        if (carType.equals(CarType.CAR)) {
            car = getPassengerCar(root);
        } else {
            car = getTruck(root);
        }
        car.setId(getElementTextContent(root, "id"));
        car.setPrice(getElementNumberContent(root, "price"));
        car.setCount(getElementNumberContent(root, "count"));
        car.setManufacturer(Manufacturer.valueOf(getElementTextContent(root, "manufacturer")));
        car.setColor(Color.valueOf(getElementTextContent(root, "color")));
        car.setEngine(getEngine(root));
        return car;
    };

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    private static int getElementNumberContent(Element element, String elementName) {
        return Integer.parseInt(getElementTextContent(element, elementName));
    }

    private PassengerCar getPassengerCar(Element element) {
        PassengerCar car = (PassengerCar) carService.create(CarType.CAR);
        car.setPassengerCount(getElementNumberContent(element, "passengerCount"));
        return car;
    }

    private Truck getTruck(Element element) {
        Truck car = (Truck) carService.create(CarType.CAR);
        car.setLoadCapacity(getElementNumberContent(element, "loadCapacity"));
        return car;
    }

    private Engine getEngine(Element element) {
        Engine engine = new Engine();
        Element engineElement = (Element) element.getElementsByTagName("engine").item(0);
        engine.setPower(getElementNumberContent(engineElement, "power"));
        engine.setType(getElementTextContent(engineElement, "type"));
        return engine;
    }

}
