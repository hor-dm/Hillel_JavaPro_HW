package org.example.builder;

import org.example.builder.carComponents.Body;
import org.example.builder.carComponents.Engine;
import org.example.builder.carComponents.Transmission;

public interface builder {

    void setCarBody(Body body);

    void setCarEngine(Engine engine);

    void setCarTransmission(Transmission transmission);
}
