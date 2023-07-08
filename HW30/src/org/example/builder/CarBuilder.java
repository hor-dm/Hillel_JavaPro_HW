package org.example.builder;

import org.example.builder.carComponents.Body;
import org.example.builder.carComponents.Engine;
import org.example.builder.carComponents.Transmission;

public class CarBuilder implements builder {
    private Body body;
    private Engine engine;
    private Transmission transmission;

    @Override
    public void setCarBody(Body body) {
        this.body = body;
    }

    @Override
    public void setCarEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setCarTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Car buildCar(){
        return new Car (body, engine, transmission);
    }
}
