import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private final Properties prop = new Properties();

    public ConfigReader(String propertiesFileName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            prop.load(inputStream);
        } catch (Exception e) {
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

    public int getGridLength() {
        return Integer.parseInt(prop.getProperty("game.grid.length"));
    }

    public int getGridWidth() {
        return Integer.parseInt(prop.getProperty("game.grid.width"));
    }

    public String getTerminationType() {
        return prop.getProperty("game.terminationType");
    }

    public void setGameType(String gameType) {
        prop.setProperty("game.type", gameType);
    }

    public void setModel(String gameModel) {
        prop.setProperty("game.model", gameModel);
    }

    public void setDatastructure(String datastructure) {
        prop.setProperty("game.datastructure", datastructure);
    }

    public void setLoggingType(String loggingType) {
        prop.setProperty("game.loggingType", loggingType);
    }

    public void setTimeToLive(String timeToLive) {
        prop.setProperty("game.timeToLive", timeToLive);
    }

    public void setGridLength(String gridLength) {
        prop.setProperty("game.grid.length", gridLength);
    }

    public void setGridWidth(String gridWidth) {
        prop.setProperty("game.grid.width", gridWidth);
    }

    public void setTerminationType(String terminationType) {
        prop.setProperty("game.terminationType", terminationType);
    }
}

