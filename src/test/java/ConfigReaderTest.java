import org.junit.Test;
import org.mockito.Mock;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ConfigReaderTest {
    @Mock
    Properties properties = new Properties();

    @Test
    public void readPropertiesWithValues() {
        ConfigReader configReader = new ConfigReader();

        String gameType = "1";
        String model = "2";
        String datastructure = "3";
        String loggingType = "4";
        String timeToLive = "5";

        properties.setProperty("game.type", gameType);
        properties.setProperty("game.model", model);
        properties.setProperty("game.datastructure", datastructure);
        properties.setProperty("game.loggingType", loggingType);
        properties.setProperty("game.timeToLive", timeToLive);

        assertEquals(gameType, configReader.getGameType());
        assertEquals(model, configReader.getModel());
        assertEquals(datastructure, configReader.getDatastructure());
        assertEquals(loggingType, configReader.getLoggingType());
        assertEquals(Integer.parseInt(timeToLive), configReader.getTimeToLive());
    }
}
