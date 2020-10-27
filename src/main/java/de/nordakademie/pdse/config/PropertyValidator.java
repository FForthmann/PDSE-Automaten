package de.nordakademie.pdse.config;

import java.util.Properties;

public class PropertyValidator {

    private static final String GAME_TYPE = "game.type";
    private static final String GAME_MODEL = "game.model";
    private static final String DATA_STRUCTURE = "game.dataStructure";
    private static final String LOGGING_TYPE = "game.loggingType";
    private static final String TIME_TO_LIVE = "game.timeToLive";
    private static final String LENGTH = "game.grid.length";
    private static final String WIDTH = "game.grid.width";
    private static final String TERMINATION_TYPE = "game.terminationType";

    public void validateConfig(Properties prop) {
        boolean validDataInFile = true;
        try {
            if (("noChange".equals(prop.getProperty(TERMINATION_TYPE))) || ("ttlOrNoChange".equals(prop.getProperty(TERMINATION_TYPE))) || ("ttl".equals(prop.getProperty(TERMINATION_TYPE)))) {
                if ("ttl".equals(prop.getProperty(TERMINATION_TYPE))) { // Hinzufügen ttlOrNoChange
                    if (Integer.parseInt(prop.getProperty(TIME_TO_LIVE)) < 0) {
                        validDataInFile = false;
                    }
                }
            } else {
                validDataInFile = false;
            }
            if (!"Parity".equals(prop.getProperty(GAME_TYPE)) && !"GameOfLife".equals(prop.getProperty(GAME_TYPE))) {
                validDataInFile = false;
            }
            if (!"Moore".equals(prop.getProperty(GAME_MODEL)) && !"vonNeumann".equals(prop.getProperty(GAME_MODEL))) {
                validDataInFile = false;
            }
            if (!"GridPoints".equals(prop.getProperty(DATA_STRUCTURE)) && !"GridArray".equals(prop.getProperty(DATA_STRUCTURE))) {
                validDataInFile = false;
            }
            if (!"console".equals(prop.getProperty(LOGGING_TYPE)) && !"file".equals(prop.getProperty(LOGGING_TYPE)) && !"consoleAndFile".equals(prop.getProperty(LOGGING_TYPE)) && !"disable".equals(prop.getProperty(LOGGING_TYPE))) {
                validDataInFile = false;
            }
            if (Integer.parseInt(prop.getProperty(LENGTH)) < 1) {
                validDataInFile = false;
            }
            if (Integer.parseInt(prop.getProperty(WIDTH)) < 1) {
                validDataInFile = false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("The given property file is incomplete.", e);
        }
        if (!validDataInFile) {
            throw new RuntimeException("The given property file includes invalid data.");
        }
    }
}
