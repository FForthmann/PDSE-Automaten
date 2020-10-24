import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ConfigReaderTest {

    private final static String GAME_TYPE = "1";
    private final static String MODEL = "2";
    private final static String DATA_STRUCTURE = "3";
    private final static String LOGGING_TYPE = "4";
    private final static String TIME_TO_LIVE = "5";
    private final static String GRID_LENGTH = "6";
    private final static String GRID_WIDTH = "7";
    private final static String TERMINATION_TYPE = "8";

    private final static String ALTERNATIVE_GAME_TYPE = "A";
    private final static String ALTERNATIVE_MODEL = "B";
    private final static String ALTERNATIVE_DATA_STRUCTURE = "C";
    private final static String ALTERNATIVE_LOGGING_TYPE = "D";
    private final static String ALTERNATIVE_TIME_TO_LIVE = "10";
    private final static String ALTERNATIVE_GRID_LENGTH = "20";
    private final static String ALTERNATIVE_GRID_WIDTH = "30";
    private final static String ALTERNATIVE_TERMINATION_TYPE = "H";

    @BeforeClass
    public static void generateTestConfig() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("game.type", GAME_TYPE);
        properties.setProperty("game.model", MODEL);
        properties.setProperty("game.dataStructure", DATA_STRUCTURE);
        properties.setProperty("game.loggingType", LOGGING_TYPE);
        properties.setProperty("game.timeToLive", TIME_TO_LIVE);
        properties.setProperty("game.grid.length", GRID_LENGTH);
        properties.setProperty("game.grid.width", GRID_WIDTH);
        properties.setProperty("game.terminationType", TERMINATION_TYPE);

        // Changing String to ByteArray and getting it into the right format
        byte[] bytes = properties.toString().replaceAll(",", "\n").replaceFirst("\\{", "").replaceAll("}", "").replaceAll(" ", "").getBytes();
        try (OutputStream outputStream = new FileOutputStream("src\\test\\java\\resources\\configTest.properties")) {
            outputStream.write(bytes);
        }
    }

    @Test
    public void readPropertiesWithValues() {
        ConfigReader configReader = new ConfigReader("configTest.properties");

        assertEquals(GAME_TYPE, configReader.getGameType());
        assertEquals(MODEL, configReader.getModel());
        assertEquals(DATA_STRUCTURE, configReader.getDatastructure());
        assertEquals(LOGGING_TYPE, configReader.getLoggingType());
        assertEquals(Integer.parseInt(TIME_TO_LIVE), configReader.getTimeToLive());
        assertEquals(Integer.parseInt(GRID_LENGTH), configReader.getGridLength());
        assertEquals(Integer.parseInt(GRID_WIDTH), configReader.getGridWidth());
        assertEquals(TERMINATION_TYPE, configReader.getTerminationType());
    }

    @Test(expected = RuntimeException.class)
    public void readNotExistingConfigFile() {
        ConfigReader configReader = new ConfigReader("notExistent.properties");
        configReader.getGameType();
    }

    @Test
    public void changePropertyValues() {
        ConfigReader configReader = new ConfigReader("configTest.properties");

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
}
