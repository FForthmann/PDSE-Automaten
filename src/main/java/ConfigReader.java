import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties prop = new Properties();
    private static final String PROPERTIES_FILE_NAME = "config.properties";

    public ConfigReader() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
            prop.load(inputStream);
        } catch (Exception e) {
            // LOGGER.error("The properties file with the name '{}' could not be found. Closing the program without sending a file", PROPERTIES_FILE_NAME);
            throw new RuntimeException("The properties file could not be found or loaded.");
        }
    }

    public String getGameType() {
        return prop.getProperty("game.type");
    }

    public String getModel() {
        return prop.getProperty("game.model");
    }

    public String getDatastructure() {
        return prop.getProperty("game.datastructure");
    }

    public String getLoggingType() {
        return prop.getProperty("game.loggingType");
    }

    public int getTimeToLive() {
        return Integer.parseInt(prop.getProperty("game.timeToLive"));
    }

    public int getLength() {
        return Integer.parseInt(prop.getProperty("game.grid.length"));
    }

    public int getWidth() {
        return Integer.parseInt(prop.getProperty("game.grid.width"));
    }

}
