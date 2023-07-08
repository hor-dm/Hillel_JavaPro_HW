package org.example.strategy;

public class Context {

    private SquareCountStrategy strategy;

    public Context() {
    }

    public void setStrategy(SquareCountStrategy strategy) {
        this.strategy = strategy;
    }

    public double countByStrategy(double a, double b) {
        return strategy.count(a, b);
    }
}
