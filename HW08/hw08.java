public class hw08 {
    public static void main(String[] args) {
        // correct array
        String[][] s1 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        // wrong array size
        String[][] s2 = {{"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}, {"1", "2", "3"}};

        // array with wrong string
        String[][] s3 = {{"one", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        // array with wrong string
        String[][] s4 = {{"1", "two", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};


//        System.out.println("Sum = " + ArrayValueCalculator.doCalc(s1));
        System.out.println("Sum = " + ArrayValueCalculator.doCalc(s2));
//        System.out.println("Sum = " + ArrayValueCalculator.doCalc(s3));
//        System.out.println("Sum = " + ArrayValueCalculator.doCalc(s4));

    }
}