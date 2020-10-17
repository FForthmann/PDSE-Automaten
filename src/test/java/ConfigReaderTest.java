import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Properties;

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

        Assert.assertEquals(gameType, configReader.getGameType());
        Assert.assertEquals(model, configReader.getModel());
        Assert.assertEquals(datastructure, configReader.getDatastructure());
        Assert.assertEquals(loggingType, configReader.getLoggingType());
        Assert.assertEquals(timeToLive, configReader.getTimeToLive());
    }
}
