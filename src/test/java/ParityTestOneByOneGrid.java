import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParityTestOneByOneGrid {

    GridFactory gridFactory = new GridFactory(1, 1, "GridArray");
    IGrid grid = gridFactory.getGrid();
    Point point = new Point(0, 0);

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test(expected = IllegalArgumentException.class)
    public void emptyGridMoore() throws Exception {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");
        Parity parity = new Parity(configReader);
        parity.step(grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void trueGridMoore() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");
        Parity parity = new Parity(configReader);
        parity.step(grid);
    }

    @Test
    public void emptyGridNeumann() throws Exception {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");
        Parity parity = new Parity(configReader);
        assertTrue(parity.step(grid).getValue(point) == false);
    }

    @Test
    public void trueGridNeumann() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");
        Parity parity = new Parity(configReader);
        assertTrue(parity.step(grid).getValue(point) == false);
    }
}