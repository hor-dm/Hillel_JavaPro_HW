package package4xxx;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String>list = package1.Main.fillList();
        List<Record> listRecord = findOccurrence(list);

        for (Record record : listRecord) {
            System.out.printf("{name: \"%s\", occurrence: %d}\n",
                    record.getName(), record.getOccurrence());
        }
    }

    private static List<Record> findOccurrence(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        List<Record> listRecords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            listRecords.add(new Record(entry.getKey(), entry.getValue()));
        }
        return listRecords;
    }
}
