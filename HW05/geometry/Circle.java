package geometry;

public class Circle implements Figure {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double countArea() {
        return  3.14 * radius * Math.pow(radius, 2);
    }
}