package de.nordakademie.pdse.config;

import java.util.Properties;

/**
 * This class gets a property object from the ConfigReader and checks if all fields are there and if yes, if they are set with valid data.
 *
 * @author Fabian Forthmann
 */
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
            if ("ttlOrNoChange".equalsIgnoreCase(prop.getProperty(TERMINATION_TYPE_KEY)) || "ttl".equalsIgnoreCase(prop.getProperty(TERMINATION_TYPE_KEY))) {
                if (Integer.parseInt(prop.getProperty(TIME_TO_LIVE_KEY)) < 0) {
                    validDataInFile = false;
                }
            } else if (!"noChange".equalsIgnoreCase(prop.getProperty(TERMINATION_TYPE_KEY))) {
                validDataInFile = false;
            } else {
                validDataInFile = false;
            }
            if (!"Parity".equalsIgnoreCase(prop.getProperty(GAME_TYPE_KEY)) && !"GameOfLife".equalsIgnoreCase(prop.getProperty(GAME_TYPE_KEY))) {
                validDataInFile = false;
            }
            if (!"Moore".equalsIgnoreCase(prop.getProperty(GAME_MODEL_KEY)) && !"vonNeumann".equalsIgnoreCase(prop.getProperty(GAME_MODEL_KEY))) {
                validDataInFile = false;
            }
            if (!"GridPoints".equalsIgnoreCase(prop.getProperty(DATA_STRUCTURE_KEY)) && !"GridArray".equalsIgnoreCase(prop.getProperty(DATA_STRUCTURE_KEY))) {
                validDataInFile = false;
            }
            if (!"console".equalsIgnoreCase(prop.getProperty(LOGGING_TYPE_KEY)) && !"file".equalsIgnoreCase(prop.getProperty(LOGGING_TYPE_KEY)) && !"consoleAndFile".equalsIgnoreCase(prop.getProperty(LOGGING_TYPE_KEY)) && !"disable".equalsIgnoreCase(prop.getProperty(LOGGING_TYPE_KEY))) {
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
