package de.nordakademie.pdse.config;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;

/**
 * Unit test vor getters and setters in the config class.
 *
 * @author Fabian Forthmann
 */
public class ConfigReaderTest {

    private final static String GAME_TYPE = "Parity";
    private final static String MODEL = "Moore";
    private final static String DATA_STRUCTURE = "GridPoints";
    private final static String LOGGING_TYPE = "console";
    private final static String TIME_TO_LIVE = "500";
    private final static String GRID_LENGTH = "40";
    private final static String GRID_WIDTH = "67";
    private final static String TERMINATION_TYPE = "ttl";

    private final static String ALTERNATIVE_GAME_TYPE = "GameOfLife";
    private final static String ALTERNATIVE_MODEL = "vonNeumann";
    private final static String ALTERNATIVE_DATA_STRUCTURE = "GridArray";
    private final static String ALTERNATIVE_LOGGING_TYPE = "file";
    private final static String ALTERNATIVE_TIME_TO_LIVE = "30";
    private final static String ALTERNATIVE_GRID_LENGTH = "3";
    private final static String ALTERNATIVE_GRID_WIDTH = "98";
    private final static String ALTERNATIVE_TERMINATION_TYPE = "noChange";

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void readExistingPropertiesFromFile() throws IOException {
        Properties properties = initializeValidPropertiesFile();

        final File tempFile = tempFolder.newFile("tempFile.properties");
        // Writing String into the temporary file and formatting it
        FileUtils.writeStringToFile(tempFile, properties.toString().replaceAll(",", "\n").replaceFirst("\\{", "").replaceAll("}", "").replaceAll(" ", ""));
        ConfigReader configReader = new ConfigReader(tempFile);

        assertEquals(GAME_TYPE, configReader.getGameType());
        assertEquals(MODEL, configReader.getModel());
        assertEquals(DATA_STRUCTURE, configReader.getDatastructure());
        assertEquals(LOGGING_TYPE, configReader.getLoggingType());
        assertEquals(Integer.parseInt(TIME_TO_LIVE), configReader.getTimeToLive());
        assertEquals(Integer.parseInt(GRID_LENGTH), configReader.getGridLength());
        assertEquals(Integer.parseInt(GRID_WIDTH), configReader.getGridWidth());
        assertEquals(TERMINATION_TYPE, configReader.getTerminationType());
    }

    @Test
    public void setPropertyValues() throws IOException {
        Properties properties = initializeValidPropertiesFile();

        final File tempFile = tempFolder.newFile("tempFile.properties");
        // Writing String into the temporary file and formatting it
        FileUtils.writeStringToFile(tempFile, properties.toString().replaceAll(",", "\n").replaceFirst("\\{", "").replaceAll("}", "").replaceAll(" ", ""));
        ConfigReader configReader = new ConfigReader(tempFile);

        configReader.setGameType(ALTERNATIVE_GAME_TYPE);
        configReader.setModel(ALTERNATIVE_MODEL);
        configReader.setDatastructure(ALTERNATIVE_DATA_STRUCTURE);
        configReader.setLoggingType(ALTERNATIVE_LOGGING_TYPE);
        configReader.setTimeToLive(ALTERNATIVE_TIME_TO_LIVE);
        configReader.setGridLength(ALTERNATIVE_GRID_LENGTH);
        configReader.setGridWidth(ALTERNATIVE_GRID_WIDTH);
        configReader.setTerminationType(ALTERNATIVE_TERMINATION_TYPE);

        assertEquals(ALTERNATIVE_GAME_TYPE, configReader.getGameType());
        assertEquals(ALTERNATIVE_MODEL, configReader.getModel());
        assertEquals(ALTERNATIVE_DATA_STRUCTURE, configReader.getDatastructure());
        assertEquals(ALTERNATIVE_LOGGING_TYPE, configReader.getLoggingType());
        assertEquals(Integer.parseInt(ALTERNATIVE_TIME_TO_LIVE), configReader.getTimeToLive());
        assertEquals(Integer.parseInt(ALTERNATIVE_GRID_LENGTH), configReader.getGridLength());
        assertEquals(Integer.parseInt(ALTERNATIVE_GRID_WIDTH), configReader.getGridWidth());
        assertEquals(ALTERNATIVE_TERMINATION_TYPE, configReader.getTerminationType());
    }

    @Test
    public void changeExistingPropertyValues() throws IOException {
        Properties properties = initializeValidPropertiesFile();

        final File tempFile = tempFolder.newFile("tempFile.properties");
        // Writing String into the temporary file and formatting it
        FileUtils.writeStringToFile(tempFile, properties.toString().replaceAll(",", "\n").replaceFirst("\\{", "").replaceAll("}", "").replaceAll(" ", ""));
        ConfigReader configReader = new ConfigReader(tempFile);

        configReader.setGameType(ALTERNATIVE_GAME_TYPE);
        configReader.setModel(ALTERNATIVE_MODEL);
        configReader.setDatastructure(ALTERNATIVE_DATA_STRUCTURE);
        configReader.setLoggingType(ALTERNATIVE_LOGGING_TYPE);
        configReader.setTimeToLive(ALTERNATIVE_TIME_TO_LIVE);
        configReader.setGridLength(ALTERNATIVE_GRID_LENGTH);
        configReader.setGridWidth(ALTERNATIVE_GRID_WIDTH);
        configReader.setTerminationType(ALTERNATIVE_TERMINATION_TYPE);

        assertEquals(ALTERNATIVE_GAME_TYPE, configReader.getGameType());
        assertEquals(ALTERNATIVE_MODEL, configReader.getModel());
        assertEquals(ALTERNATIVE_DATA_STRUCTURE, configReader.getDatastructure());
        assertEquals(ALTERNATIVE_LOGGING_TYPE, configReader.getLoggingType());
        assertEquals(Integer.parseInt(ALTERNATIVE_TIME_TO_LIVE), configReader.getTimeToLive());
        assertEquals(Integer.parseInt(ALTERNATIVE_GRID_LENGTH), configReader.getGridLength());
        assertEquals(Integer.parseInt(ALTERNATIVE_GRID_WIDTH), configReader.getGridWidth());
        assertEquals(ALTERNATIVE_TERMINATION_TYPE, configReader.getTerminationType());
    }

    @Test(expected = RuntimeException.class)
    public void readNotExistingConfigFile() {
        File configPropertyFile = new File("fileThatDoesNotExist.properties");
        ConfigReader configReader = new ConfigReader(configPropertyFile);
        configReader.getGameType();
    }

    private Properties initializeValidPropertiesFile() {
        Properties properties = new Properties();

        properties.setProperty("game.type", GAME_TYPE);
        properties.setProperty("game.model", MODEL);
        properties.setProperty("game.dataStructure", DATA_STRUCTURE);
        properties.setProperty("game.loggingType", LOGGING_TYPE);
        properties.setProperty("game.timeToLive", TIME_TO_LIVE);
        properties.setProperty("game.grid.length", GRID_LENGTH);
        properties.setProperty("game.grid.width", GRID_WIDTH);
        properties.setProperty("game.terminationType", TERMINATION_TYPE);

        return properties;
    }
}
