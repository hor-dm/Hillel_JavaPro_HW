package domashka14_7xx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {

    private List<FileData> list;

    private Map<String, List<FileData>> map;

    public FileNavigator() {
        this.map = new HashMap<>();
    }

    public void add(FileData fileData) {
        if ((fileData.getFilePath()) == fileData.KEY_PATH) {
            if (!map.containsKey(fileData.getFilePath())) {
                list = new ArrayList<>();
                list.add(fileData);
                map.put(fileData.getFilePath(), list);
            } else {
                list = new ArrayList<>();
                list = map.get(fileData.getFilePath());
                list.add(fileData);
                map.put(map.get(fileData.getFilePath()).toString(), list);
            }
        } else {
            System.out.println(fileData.getFilePath() +" Is wrong file path.");
        }
    }

    public void printFileList() {
        List<FileData> fileList = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry : this.map.entrySet()) {
            List<FileData> lfd = entry.getValue();
            for (FileData fileData : lfd) {
                if (!fileList.contains(fileData)) {
                    fileList.add(fileData);
                }
            }
        }
        for (FileData fd : fileList) {
            System.out.println(fd.getFilePath() + "  " + fd.getFileName() + " " + fd.getFileSize());
        }

    }
}
