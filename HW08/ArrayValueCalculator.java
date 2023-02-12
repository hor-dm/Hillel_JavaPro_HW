public class ArrayValueCalculator {
    static int doCalc(String[][] arr) {
        try {
            if (arr.length != 4 || !checkArray(arr)) {
                throw new ArraySizeException();
            } else {
                System.out.println("Array size is ok.");
            }
        } catch (ArraySizeException ignored){}

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!arr[i][j].matches("^[0-9]+$")) {
                    throw new ArrayDataException(i, j);
                } else {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        }
        return sum;
    }

    private static boolean checkArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != arr.length) return false;
        }
        return true;
    }
}
