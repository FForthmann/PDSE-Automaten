package de.nordakademie.pdse.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String loggingType;
    private File file;


    public Logger(String loggingType) {
        this.loggingType = loggingType;
        createFile();
    }

    public void addGridToLog(String grid, int iteration) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("###" + iteration + "\n");
        stringBuilder.append(grid);
        if (loggingType.equals("consoleAndFile")) {
            writeLogToFile(stringBuilder.toString());
            writeLogToConsole(stringBuilder.toString());
        } else if (loggingType.equals("file")) {
            writeLogToFile(stringBuilder.toString());
        } else if (loggingType.equals("console")){
            writeLogToConsole(stringBuilder.toString());
        } else if(loggingType.equals("disable")) {

        } else {
            throw new IllegalArgumentException("Invalide LoggingType");
        }
    }

    private void createFile() {
        if (loggingType.equals("")) {
            file = new File("gridLog" + getCurrentTime());
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH-mm-ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    private File getFile() {
        return file;
    }

    private void writeLogToConsole(String input) {
        System.out.println(input);
    }

    private void writeLogToFile(String input) {
        try {
            FileWriter fileWriter = new FileWriter(getFile());
            fileWriter.append(input);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
