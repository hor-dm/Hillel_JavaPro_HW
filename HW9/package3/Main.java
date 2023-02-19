package package3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> listInt = fillIntList();

        System.out.println("list: ");
        for (int i : listInt) System.out.print(i + " ");
        System.out.println();

        findUnique(listInt);
        findUniqueFor(listInt);
    }

    static List<Integer> fillIntList() {
        int listLength = (int) (Math.random() * 90) + 10;
        List<Integer> list = new ArrayList<>(listLength);
        for (int i = 0; i < listLength; i++) {
            list.add((int) (Math.random() * 90) + 10);
        }
        return list;
    }

    static void findUnique(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        System.out.println();
        System.out.println("unique list (use HashSet):");
        for (int i : list) System.out.print(i + " ");
        System.out.println();

    }

    static void findUniqueFor(List<Integer> list) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isUnique = false;
            for (int j = 0; j < i; j++) {
                if (Objects.equals(list.get(i), list.get(j))) {
                    isUnique = true;
                    break;
                }
            }
            if (!isUnique) {
                resultList.add(list.get(i));
            }
        }

        System.out.println();
        System.out.println("unique resList (use for):");
        for (int i : resultList) System.out.print(i + " ");
        System.out.println();

    }
}
