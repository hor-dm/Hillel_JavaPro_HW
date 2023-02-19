package domashka14_0_6x;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        System.out.println("add()");
        navigator.add(new FileData("qqq.txt", 20, "folder1/"));
        navigator.add(new FileData("www.txt", 12, "folder2/"));
        navigator.add(new FileData("eee.txt", 11, "folder1/"));
        navigator.add(new FileData("rrr.txt", 17, "folder3/"));
        navigator.add(new FileData("ttt.txt", 19, "folder2/"));
        navigator.add(new FileData("yyy.txt", 10, "folder4/"));
        navigator.add(new FileData("uuu.txt", 16, "folder4/"));
        System.out.println();

        System.out.println("find()");
        System.out.println(navigator.find("folder1/"));
        System.out.println(navigator.find("folder2/"));
        System.out.println(navigator.find("folder3/"));
        System.out.println(navigator.find("folder4/"));
        System.out.println(navigator.find("folder5/"));
        System.out.println();

        System.out.println("filterBySize()");
        System.out.println(navigator.filterBySize(15));
        System.out.println();

        System.out.println("find (\"folder3\") find (\"folder3\")");
        System.out.println(navigator.find("folder3/"));
        System.out.println(navigator.find("folder4/"));
        System.out.println("remove(\"folder4\")");
        navigator.remove("folder4/");
        System.out.println("find (\"folder3\") find (\"folder3\")");
        System.out.println(navigator.find("folder3/"));
        System.out.println(navigator.find("folder4/"));

        System.out.println("sortBySize()");
        List<FileData> fileList = navigator.sortBySize();
        for (FileData fd : fileList) {
            System.out.println (fd.getFileName() + " " + fd.getFileSize());
        }

    }
}
