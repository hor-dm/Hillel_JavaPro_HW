package package2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = fillIntArray();
        List<Integer>listInt = toList(array);

        for (int i : listInt) System.out.print(i + " ");
        System.out.println();
    }

    static int[] fillIntArray() {
        int arrLength = (int) (Math.random() * 90) + 10;
        int[] array = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            array[i] = (int) (Math.random() * 90) + 10;
        }

        return array;
    }

    static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) list.add(i);
        return list;
    }
}
