package package1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = fillList();
        countOccurrence(list, "Tom");
        countOccurrence(list, "Bob");
        countOccurrence(list, "John");
    }

    public static List<String> fillList() {
        List<String> listRand = new ArrayList<>();
        String[] words = new String[]{"Tom", "Bob", "Oliver",
                "James", "Jack", "Connor", "John", "Harry",
                "Robert", "Jacob", "Michael", "Mary", "Samantha",
                "Patricia", "Jennifer", "Isabella", "Linda", "Victoria", "Lily"};

        for (String word : words) {
            for (int j = 0; j < ((int) (Math.random() * 3) + 1); j++) {
                listRand.add(word);
            }
        }

        Collections.shuffle(listRand);

        return listRand;
    }

    static void countOccurrence(List<String> list, String string) {
        int wordCounter = 0;
        for (String s : list) {
            if (s.equals(string)) wordCounter++;
        }
        System.out.printf("The word %s occurs %d times\n", string, wordCounter);
    }

}

