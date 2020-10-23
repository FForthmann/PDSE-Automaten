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
    private final static String DATASTRUCTURE = "3";
    private final static String LOGGING_TYPE = "4";
    private final static String TIME_TO_LIVE = "5";
    private final static String GRID_LENGTH = "6";
    private final static String GRID_WIDTH = "7";
    private final static String TERMINATION_TYPE = "8";

    @BeforeClass
    public static void generateTestConfig() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("game.type", GAME_TYPE);
        properties.setProperty("game.model", MODEL);
        properties.setProperty("game.datastructure", DATASTRUCTURE);
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
        assertEquals(DATASTRUCTURE, configReader.getDatastructure());
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
}