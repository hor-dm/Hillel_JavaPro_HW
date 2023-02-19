package package4xx;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String>list = package1.Main.fillList();
        calcOccurrence(list);

    }

    static void calcOccurrence(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }


    }
}
