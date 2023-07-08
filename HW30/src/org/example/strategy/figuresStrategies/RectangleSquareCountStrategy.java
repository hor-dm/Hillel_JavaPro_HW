package org.example.strategy.figuresStrategies;

import org.example.strategy.SquareCountStrategy;

public class RectangleSquareCountStrategy implements SquareCountStrategy {

    @Override
    public double count(double sideA, double sideB) {
        return sideA * sideB;
    }
}
