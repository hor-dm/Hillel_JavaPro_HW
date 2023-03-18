import java.io.File;

public class FileLoggerConfiguration {
    File file;
    LoggingLevel loggingLevel;
    int logFileSize;
    String format;
    

    public FileLoggerConfiguration() {
        file = new File("log");
        logFileSize =   1000;
    }
}