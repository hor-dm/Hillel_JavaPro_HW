package org.example.strategy.figuresStrategies;

import org.example.strategy.SquareCountStrategy;

public class TriangleSquareCountStrategy implements SquareCountStrategy {

    @Override
    public double count(double triangleHeight, double triangleWidth) {
        return triangleHeight * triangleWidth / 2;
    }
}
