import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileLogger {

    FileLoggerConfiguration flc = new FileLoggerConfiguration();

    File oldFile;

    private final List<String> listFilesInDirectory = new ArrayList<>();

    void debug(String test_string_for_debug_logging) {
        info("test string for debug logging");

        flc.loggingLevel = LoggingLevel.DEBUG;
        if (getListOfFiles(flc.file).isEmpty()) {

            createNewFileWithDate();

            writeToFile("test string for debug logging", flc);

        } else {

            getListOfFiles(flc.file);

            getLastModifiedFile();

            flc.file = getLastModifiedFile();

            long currentFileSize = flc.file.length();

            try {
                if (currentFileSize <= flc.logFileSize) {
                    writeToFile("test string for debug logging", flc);
                } else {
                    createNewFileWithDate();

                    writeToFile("test string for debug logging", flc);
                    throw new FileMaxSizeReachedException(flc.logFileSize,
                            oldFile.length(),
                            oldFile.getAbsolutePath());
                }
            } catch (FileMaxSizeReachedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void info(String message) {

        flc.loggingLevel = LoggingLevel.INFO;
        if (getListOfFiles(flc.file).isEmpty()) {
            createNewFileWithDate();
            writeToFile(message, flc);
        } else {
            getListOfFiles(flc.file);
            getLastModifiedFile();
            flc.file = getLastModifiedFile();
            long currentFileSize = flc.file.length();

            try {
                if (currentFileSize <= flc.logFileSize) {
                    writeToFile(message, flc);
                } else {
                    createNewFileWithDate();
                    writeToFile(message, flc);
                    throw new FileMaxSizeReachedException(flc.logFileSize,
                            oldFile.length(),
                            oldFile.getAbsolutePath());
                }
            } catch (FileMaxSizeReachedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void debugInfoMix(FileLoggerConfiguration flc, String message) {

        if (getListOfFiles(flc.file).isEmpty()) {
            createNewFileWithDate();

            writeToFile(message, flc);

        } else {
            getListOfFiles(flc.file);
            getLastModifiedFile();

            flc.file = getLastModifiedFile();
            long currentFileSize = flc.file.length();

            try {
                if (currentFileSize <= flc.logFileSize) {
                    writeToFile(message, flc);
                } else {
                    createNewFileWithDate();
                    writeToFile(message, flc);
                    throw new FileMaxSizeReachedException(flc.logFileSize,
                            oldFile.length(),
                            oldFile.getAbsolutePath());
                }
            } catch (FileMaxSizeReachedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createNewFileWithDate() {
        oldFile = flc.file;
        flc.file = new File(flc.file.getName().substring(0, 3) + " " + getCurrentDateTime());
        try {
            flc.file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(String message, FileLoggerConfiguration flc) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(flc.file, true));
            bufferedWriter.append("\n[").append(getCurrentDateTime()).append("]").append("[").append(String.valueOf(flc.loggingLevel)).append("]").append(" Message: ").append("[").append(message).append("]");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCurrentDateTime() {
        String currentDateTime;
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
        Date date = new Date();
        currentDateTime = dateFormat.format(date);
        return currentDateTime;
    }

    private List getListOfFiles(File file) {
        String dir = file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - file.getName().length());
        File f = new File(dir);
        Collections.addAll(listFilesInDirectory, Objects.requireNonNull(f.list()));
        listFilesInDirectory.removeIf(s2 -> !s2.contains(flc.file.getName().substring(0, 3)));
        return listFilesInDirectory;
    }

    private File getLastModifiedFile() {

        File lastModifiedFile = new File(listFilesInDirectory.get(0));
        for (String s : listFilesInDirectory) {
            File tempFile = new File(s);
            if (lastModifiedFile.lastModified() < tempFile.lastModified()) {
                lastModifiedFile = tempFile;
            }
        }
        return lastModifiedFile;
    }

}


