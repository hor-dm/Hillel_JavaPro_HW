

public class Thread01 implements Runnable {

    private final double[][] arr;
    int nOfTThread;

    public Thread01(double[][] arr, int nOfThread) {
        this.arr = arr;
        this.nOfTThread = nOfThread;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (float) (arr[i][j] * Math.sin(0.2f + i/5) *
                        Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
        }
        long finishTime = System.currentTimeMillis() - startTime;
        System.out.println("Thread #" + nOfTThread + " time: " + (double) finishTime / 1000);
    }
}
