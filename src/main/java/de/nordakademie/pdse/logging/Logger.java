package de.nordakademie.pdse.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Returns the output of the simulation to a log file or the console
 *
 * @author Georg Mezlaw
 * @since 26.10.2020
 */
public class Logger {
    private final String loggingType;
    private File file;
    private String fileName;

    public Logger(String loggingType, String fileName) {
        this.loggingType = loggingType;
        if (!"console".equalsIgnoreCase(this.loggingType)) {
            this.fileName = fileName + ".log";
            createFile();
        }

    }

    public Logger(String loggingType) {
        this.loggingType = loggingType;
        if (!"console".equalsIgnoreCase(this.loggingType)) {
            this.fileName = "GridLog" + getCurrentTime() + ".log";
            createFile();
        }
    }

    public void addGridToLog(String grid, int iteration) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("###" + iteration + "\n");
        stringBuilder.append(grid);
        switch (loggingType) {
            case "consoleAndFile":
                writeLogToFile(stringBuilder.toString());
                writeLogToConsole(stringBuilder.toString());
                break;
            case "file":
                writeLogToFile(stringBuilder.toString());
                break;
            case "console":
                writeLogToConsole(stringBuilder.toString());
                break;
            case "disable":

                break;
            default:
                throw new IllegalArgumentException("Invalide LoggingType");
        }
    }

    private void createFile() {
        Path path = Paths.get(fileName);
        try {
            Files.createFile(path);
            file = new File(String.valueOf(path));

        } catch (IOException ignored) {
            file = new File(String.valueOf(path));
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    public File getFile() {
        return file;
    }

    private void writeLogToConsole(String input) {
        System.out.println(input);
    }

    private void writeLogToFile(String input) {
        try {
            FileWriter fileWriter = new FileWriter(getFile(), true);
            fileWriter.append(input);
            fileWriter.append(System.lineSeparator());
            fileWriter.close();
        } catch (IOException ignored) {
        }
    }
}
