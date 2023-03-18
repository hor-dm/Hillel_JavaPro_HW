public class ValueCalculator {
    private static final int arraySize = 1000;
    private final double[][] array = new double[arraySize][arraySize];
    double[][] a1;
    double[][] a2;

    void calcTime() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                array[i][j] = 1;
            }
        }


        int half = (int) Math.floor(array.length) / 2;


        int maxRowLength = 0;
        for (double[] doubles : array) {
            if (maxRowLength <= doubles.length) {
                maxRowLength = doubles.length;
            }
        }

        a1 = new double[half][maxRowLength];
        System.arraycopy(array, 0, a1, 0, half);

        if (array.length % 2 != 0) {
            a2 = new double[half + 1][maxRowLength];
            System.arraycopy(array, half, a2, 0, half + 1);
        } else {
            a2 = new double[half][maxRowLength];
            System.arraycopy(array, half, a2, 0, half);
        }

        Thread thread01 = new Thread(new Thread01(a1, 1));
        thread01.start();

        Thread thread02 = new Thread(new Thread01(a2, 2));
        thread02.start();

        System.arraycopy(a1, 0, array, 0, half);
        if (array.length % 2 != 0) {
            System.arraycopy(a2, 0, array, half, half+1);
        } else {
            System.arraycopy(a2, 0, array, half, half);
        }

        long finishTime = System.currentTimeMillis() - startTime;
        System.out.println("total time: " + (double) finishTime / 1000);
    }
}
