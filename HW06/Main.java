import java.time.Year;
import java.util.GregorianCalendar;

public class Main {

    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign() {
        int a = (int) (Math.random() * 15 - 5);
        int b = (int) (Math.random() * 15 - 6);
        if (a + b >= 0) System.out.printf("\n%d and %d, the sum is positive\n", a, b);
        else System.out.printf("\n%d and %d, the sum is negative\n", a, b);
    }

    static void printColor() {
        int value = (int) (Math.random() * 400 - 200);
        System.out.printf("\nvalue = %d\n", value);
        if (value <= 0) System.out.println("Red");
        else if (value <= 100) System.out.println("Yellow");
        else System.out.println("Green");
    }

    static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        System.out.printf("\na = %d b = %d\n", a, b);
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }

    static boolean checkNumbers(int a, int b) {
        System.out.printf("\na = %d b = %d\n", a, b);
        if ((a + b) >= 10 & (a + b) <= 20) return true;
        else return false;
    }

    static void checkNumberPrint(int a) {
        System.out.printf("\na = %d \n", a);
        if (a >= 0) System.out.println("The number is positive");
        else System.out.println("The number is negative");
    }

    static boolean checkNumberReturn(int a) {
        System.out.printf("\na = %d \n", a);
        if (a < 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkNumbers((int) (Math.random() * 15), (int) (Math.random() * 15)));
        checkNumberPrint((int) (Math.random() * 10 - 7));
        System.out.println(checkNumberReturn((int) (Math.random() * 10 - 7)) + "\n");
        printStrings(5, "Hello Ukraine!");
        System.out.println(leapYear(2024));
    }

    static void printStrings(int a, String s) {
        for (int i = 0; i < a; i++) System.out.println(s);
    }

    static boolean leapYear(int year) {

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println("\ncheck 1: " + gregorianCalendar.isLeapYear(year));

        System.out.println("check 2: " + Year.isLeap(year));

        if ((year % 400 == 0) || ((year % 4 == 0) & (year % 100 != 0))) return true;
        else return false;
    }
}