package domashka14_7xx;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        System.out.println("add()");
        navigator.add(new FileData("qqq.txt", 20, "folder1/"));
        navigator.add(new FileData("www.txt", 12, "folder2/"));
        navigator.add(new FileData("eee.txt", 11, "folder1/"));
        navigator.add(new FileData("rrr.txt", 17, "folder3/"));
        navigator.add(new FileData("ttt.txt", 19, "folder1/"));
        navigator.add(new FileData("yyy.txt", 10, "folder1/"));
        navigator.add(new FileData("uuu.txt", 16, "folder4/"));
        navigator.add(new FileData("iii.txt", 16, "folder4/subfolder01/"));
        System.out.println();

        navigator.printFileList();

    }
}
