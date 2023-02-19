package domashka14_0_6x;

import java.util.*;

public class FileNavigator {

    private final Map<String, List<FileData>> map;

    public FileNavigator() {
        this.map = new HashMap<>();
    }

    public void add(FileData fileData) {
        List<FileData> list;
        if (!map.containsKey(fileData.getFilePath())) {
            list = new ArrayList<>();
            list.add(fileData);
            map.put(fileData.getFilePath(), list);
        } else {
            list = map.get(fileData.getFilePath());
            list.add(fileData);
            map.put(map.get(fileData.getFilePath()).toString(), list);
        }
    }

    public List<String> find(String path) {
        List<String> fileList = new ArrayList<>();
        if (this.map.containsKey(path)) {
            for (Map.Entry<String, List<FileData>> entry : this.map.entrySet()) {
                if (entry.getKey().equals(path)) {
                    List<FileData> lfd = entry.getValue();
                    for (FileData fileData : lfd) {
                        fileList.add(fileData.getFileName());
                    }
                }
            }
        }
        return fileList;
    }

    public List<String> filterBySize(int size) {
        List<String> fileList = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry : this.map.entrySet()) {
            List<FileData> lfd = entry.getValue();
            for (FileData fileData : lfd) {
                if (fileData.getFileSize() <= size) {
                    if (!fileList.contains(fileData.getFileName()))
                        fileList.add(fileData.getFileName());
                }
            }
        }
        return fileList;
    }

    public void remove(String path) {
        for (Map.Entry<String, List<FileData>> entry : this.map.entrySet()) {
            if (entry.getKey().equals(path)) {
                map.remove(entry.getKey(), entry.getValue());
            }
        }
    }

    public List<FileData> sortBySize() {
        List<FileData> fileList = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry : this.map.entrySet()) {
            List<FileData> lfd = entry.getValue();
            for (FileData fileData : lfd) {
                if (!fileList.contains(fileData)) {
                    fileList.add(fileData);
                }
            }
        }
        return fileList;
    }
}
