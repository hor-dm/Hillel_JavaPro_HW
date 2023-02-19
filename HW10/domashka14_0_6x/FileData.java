package domashka14_0_6x;

public class FileData implements Comparable<FileData>{
    private final String fileName;
    private final int fileSize;
    private final String filePath;

    public FileData(String fileName, int fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }


    @Override
    public int compareTo(FileData fd) {
        return this.getFileSize() - fd.getFileSize();
    }
}
