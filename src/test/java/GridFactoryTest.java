import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GridFactoryTest {

    @Test
    public void getGrid() {
        ConfigReader configReader = mock(ConfigReader.class);
        when(configReader.getDatastructure()).thenReturn("0");
        GridFactory gridFactory = new GridFactory(4, 4);
        IGrid currentGrid = new GridPoints(4, 4);
        assertEquals(gridFactory.getGrid(), currentGrid);
    }
}