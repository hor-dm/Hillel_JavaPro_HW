package dom1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayInteger = {1, 2, 3, 4, 5, 56, 7};
        String[] arrayString = {"qqq", "www", "eee", "rrr", "ttt"};
        Double[] arrayDouble = {12.3, 2.13, 1.8, 13.0, 11.2};
        System.out.println(toList(arrayInteger));
        System.out.println(toList(arrayString));
        System.out.println(toList(arrayDouble));
    }

    static <T> List toList(T[] array) {
        return List.of(array);
    }
}