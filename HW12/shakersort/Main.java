package shakersort;

public class Main {
    public static void main(String[] args) {

        int[] array = fillArray();

        for (int i : array) System.out.print(i + " ");
        System.out.println();

        shakerSort(array);

        for (int i : array) System.out.print(i + " ");
        System.out.println();
    }

    static int[] fillArray() {
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + (Math.random()) * 100);
        }
        return array;
    }

    static void shakerSort(int[] array) {
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i+1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i-1] = temp;
                }
            }
            left++;
        } while (left < right);
    }

}
