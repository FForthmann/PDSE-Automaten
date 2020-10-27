package de.nordakademie.pdse.config;

import java.util.Properties;

public class PropertyValidator {

    private static final String GAME_TYPE_KEY = "game.type";
    private static final String GAME_MODEL_KEY = "game.model";
    private static final String DATA_STRUCTURE_KEY = "game.dataStructure";
    private static final String LOGGING_TYPE_KEY = "game.loggingType";
    private static final String TIME_TO_LIVE_KEY = "game.timeToLive";
    private static final String LENGTH_KEY = "game.grid.length";
    private static final String WIDTH_KEY = "game.grid.width";
    private static final String TERMINATION_TYPE_KEY = "game.terminationType";

    public void validateConfig(Properties prop) {
        boolean validDataInFile = true;
        try {
            if ("ttlOrNoChange".equals(prop.getProperty(TERMINATION_TYPE_KEY)) || "ttl".equals(prop.getProperty(TERMINATION_TYPE_KEY))) {
                if (Integer.parseInt(prop.getProperty(TIME_TO_LIVE_KEY)) < 0) {
                    validDataInFile = false;
                }
            } else if (!"noChange".equals(prop.getProperty(TERMINATION_TYPE_KEY))) {
                validDataInFile = false;
            } else {
                validDataInFile = false;
            }
            if (!"Parity".equals(prop.getProperty(GAME_TYPE_KEY)) && !"GameOfLife".equals(prop.getProperty(GAME_TYPE_KEY))) {
                validDataInFile = false;
            }
            if (!"Moore".equals(prop.getProperty(GAME_MODEL_KEY)) && !"vonNeumann".equals(prop.getProperty(GAME_MODEL_KEY))) {
                validDataInFile = false;
            }
            if (!"GridPoints".equals(prop.getProperty(DATA_STRUCTURE_KEY)) && !"GridArray".equals(prop.getProperty(DATA_STRUCTURE_KEY))) {
                validDataInFile = false;
            }
            if (!"console".equals(prop.getProperty(LOGGING_TYPE_KEY)) && !"file".equals(prop.getProperty(LOGGING_TYPE_KEY)) && !"consoleAndFile".equals(prop.getProperty(LOGGING_TYPE_KEY)) && !"disable".equals(prop.getProperty(LOGGING_TYPE_KEY))) {
                validDataInFile = false;
            }
            if (Integer.parseInt(prop.getProperty(LENGTH_KEY)) < 1) {
                validDataInFile = false;
            }
            if (Integer.parseInt(prop.getProperty(WIDTH_KEY)) < 1) {
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
