package org.example.builder;

import org.example.builder.carComponents.Body;
import org.example.builder.carComponents.Engine;
import org.example.builder.carComponents.Transmission;
import org.example.builder.enums.BodyType;
import org.example.builder.enums.EngineType;
import org.example.builder.enums.TransmissionType;

public class Director {

    public Car makeElectricCar(CarBuilder builder){
        builder.setCarBody(new Body(BodyType.SEDAN, 4));
        builder.setCarEngine(new Engine(EngineType.ELECTRIC));
        builder.setCarTransmission(new Transmission(TransmissionType.NO_TRANSMISSION));
        return builder.buildCar();
//        System.out.println(car1);
    }

    public Car makeSportCar(CarBuilder builder){
        builder.setCarBody(new Body(BodyType.HATCH, 3));
        builder.setCarEngine(new Engine(3, EngineType.PETROL));
        builder.setCarTransmission(new Transmission(TransmissionType.MANUAL, 5));
        return builder.buildCar();
    }

    public Car makeFamilyCar(CarBuilder builder){
        builder.setCarBody(new Body(BodyType.VAN, 5));
        builder.setCarEngine(new Engine(2, EngineType.DIESEL));
        builder.setCarTransmission(new Transmission(TransmissionType.AUTOMATIC, 6));
        return builder.buildCar();
    }
}
