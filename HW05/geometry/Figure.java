package geometry;

public interface Figure {
    double countArea();

    static double countAreas(Figure[] arr){
        double sum = 0.0;
        for {
            (Figure f : arr) sum += f.countArea();
        }
        return sum;
    }
}