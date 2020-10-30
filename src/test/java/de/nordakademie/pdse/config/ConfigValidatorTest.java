package de.nordakademie.pdse.config;

import org.junit.Test;

import java.util.Properties;

/**
 * Unit tests for the validation of the given property parameters.
 *
 * @author Fabian Forthmann
 */
public class ConfigValidatorTest {

    private final static String GAME_TYPE = "game.type";
    private final static String GAME_MODEL = "game.model";
    private final static String DATA_STRUCTURE = "game.dataStructure";
    private final static String LOGGING_TYPE = "game.loggingType";
    private final static String TIME_TO_LIVE = "game.timeToLive";
    private final static String LENGTH = "game.grid.length";
    private final static String WIDTH = "game.grid.width";
    private final static String TERMINATION_TYPE = "game.terminationType";

    @Test
    public void validateValidPropertyConfig() {
        Properties prop = new Properties();
        prop.setProperty(GAME_TYPE, "GameOfLife");
        prop.setProperty(GAME_MODEL, "vonNeumann");
        prop.setProperty(DATA_STRUCTURE, "GridArray");
        prop.setProperty(LOGGING_TYPE, "disable");
        prop.setProperty(LENGTH, "10");
        prop.setProperty(WIDTH, "10");
        prop.setProperty(TIME_TO_LIVE, "589");
        prop.setProperty(TERMINATION_TYPE, "ttlOrNoChange");

        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.validateConfig(prop);
    }

    @Test
    public void validateValidPropertyConfigWithTtl() {
        Properties prop = new Properties();
        prop.setProperty(GAME_TYPE, "GameOfLife");
        prop.setProperty(GAME_MODEL, "vonNeumann");
        prop.setProperty(DATA_STRUCTURE, "GridArray");
        prop.setProperty(LOGGING_TYPE, "disable");
        prop.setProperty(LENGTH, "10");
        prop.setProperty(WIDTH, "10");
        prop.setProperty(TERMINATION_TYPE, "ttl");
        prop.setProperty(TIME_TO_LIVE, "99");

        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.validateConfig(prop);
    }

    @Test(expected = RuntimeException.class)
    public void validateInvalidPropertyConfigWithFalseStrings() {
        Properties prop = new Properties();
        prop.setProperty(GAME_TYPE, "GameOfLifeA");
        prop.setProperty(GAME_MODEL, "vonNeumannB");
        prop.setProperty(DATA_STRUCTURE, "GridArrayC");
        prop.setProperty(LOGGING_TYPE, "disableD");
        prop.setProperty(LENGTH, "10");
        prop.setProperty(WIDTH, "10");
        prop.setProperty(TIME_TO_LIVE, "92");
        prop.setProperty(TERMINATION_TYPE, "ttlOrNoChangeE");

        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.validateConfig(prop);
    }

    @Test(expected = RuntimeException.class)
    public void validateInvalidPropertyConfigWithFalseIntegers() {
        Properties prop = new Properties();
        prop.setProperty(GAME_TYPE, "GameOfLife");
        prop.setProperty(GAME_MODEL, "vonNeumann");
        prop.setProperty(DATA_STRUCTURE, "GridArray");
        prop.setProperty(LOGGING_TYPE, "disable");
        prop.setProperty(LENGTH, "0");
        prop.setProperty(WIDTH, "-10");
        prop.setProperty(TIME_TO_LIVE, "-987");
        prop.setProperty(TERMINATION_TYPE, "ttlOrNoChange");

        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.validateConfig(prop);
    }

    @Test(expected = RuntimeException.class)
    public void validateInvalidPropertyConfigWithInvalidTtl() {
        Properties prop = new Properties();
        prop.setProperty(GAME_TYPE, "GameOfLife");
        prop.setProperty(GAME_MODEL, "vonNeumann");
        prop.setProperty(DATA_STRUCTURE, "GridArray");
        prop.setProperty(LOGGING_TYPE, "disable");
        prop.setProperty(LENGTH, "10");
        prop.setProperty(WIDTH, "10");
        prop.setProperty(TERMINATION_TYPE, "ttl");
        prop.setProperty(TIME_TO_LIVE, "-54");

        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.validateConfig(prop);
    }

    @Test(expected = RuntimeException.class)
    public void validateInvalidPropertyConfigWithMissingFields() {
        Properties prop = new Properties();
        prop.setProperty(GAME_TYPE, "GameOfLife");
        prop.setProperty(DATA_STRUCTURE, "GridArray");
        prop.setProperty(LOGGING_TYPE, "disable");
        prop.setProperty(WIDTH, "10");
        prop.setProperty(TERMINATION_TYPE, "noChange");

        PropertyValidator propertyValidator = new PropertyValidator();
        propertyValidator.validateConfig(prop);
    }
}
