package geometry;

public class Square implements Figure{

    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double countArea() {
        return side * side;
    }
}