package geometry;

public class Main {
    public static void main(String[] args) {

        Figure f1 = new Circle(2);
        Figure f2 = new Triangle(2,3,4);
        Figure f3 = new Square(2);
        System.out.println("Circle area: " + f1.countArea());
        System.out.println("Triangle area: " + f2.countArea());
        System.out.println("Square area: " + f3.countArea());
        
        Figure[] arrFigures1 = new Figure[]{new Circle(2), new Circle(2)};
        System.out.println("3 circles, sum of areas: " + Figure.countAreas(arrFigures1));

        Figure[] arrFigures2 = new Figure[]{new Triangle(2,3,4), new Triangle(2,3,4)};
        System.out.println("3 triangles, sum of areas: " + Figure.countAreas(arrFigures2));

        Figure[] arrFigures3 = new Figure[]{new Square(2), new Square(2)};
        System.out.println("3 squares, sum of areas: " + Figure.countAreas(arrFigures3));

        Figure[] arrFiguresMix = new Figure[]{new Circle(2), new Triangle(2,3,4), new Square(2)};
        System.out.println("arr of 3 mix figures, sum of areas: " + Figure.countAreas(arrFiguresMix));
    }
}