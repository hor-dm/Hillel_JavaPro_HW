package org.example.builder.carComponents;

import org.example.builder.enums.BodyType;

public class Body {

    private BodyType bodyType;

    private int doorsNumber;

    public Body(BodyType bodyType, int doorsNumber) {
        this.bodyType = bodyType;
        this.doorsNumber = doorsNumber;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    @Override
    public String toString() {
        return "\nBody type: " + bodyType +
                "\nNumber of doors: " + doorsNumber;
    }
}
