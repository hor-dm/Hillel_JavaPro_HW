package org.example.builder.carComponents;

import org.example.builder.enums.TransmissionType;

public class Transmission {

    private TransmissionType type;
    private int numOfGears;

    public Transmission(TransmissionType type, int numOfGears) {
        this.type = type;
        this.numOfGears = numOfGears;
    }

    public Transmission(TransmissionType type) {
        this.type = type;
    }

    public TransmissionType getType() {
        return type;
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    @Override
    public String toString() {
        if (type.equals(TransmissionType.NO_TRANSMISSION)){
            return "";
        } else {
            return "\nTransmission type: " + type +
                    "\nNumber of gears: " + numOfGears;
        }
    }
}
