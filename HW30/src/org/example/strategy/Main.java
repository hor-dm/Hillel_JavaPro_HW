package org.example.strategy;

import org.example.strategy.figuresStrategies.RectangleSquareCountStrategy;
import org.example.strategy.figuresStrategies.TriangleSquareCountStrategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new RectangleSquareCountStrategy());
        double r1 = context.countByStrategy(4.1, 5.2);
        System.out.println(r1);

        context.setStrategy(new TriangleSquareCountStrategy());
        double tr1 = context.countByStrategy(2,3);
        System.out.println(tr1);
    }
}
