package org.example.builder.carComponents;

import org.example.builder.enums.EngineType;

public class Engine {
    private double volume;
    private EngineType engineType;

    public Engine(double volume, EngineType engineType) {
        this.volume = volume;
        this.engineType = engineType;
    }

    public Engine(EngineType engineType) {
        this.engineType = engineType;
    }

    public double getVolume() {
        return volume;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {

        if (engineType.equals(EngineType.ELECTRIC)){
            return "\nEngine type: " + engineType;
        }
        else {
            return "\nEngine volume: " + volume +
                    "\nEngine type: " + engineType;
        }
    }
}
