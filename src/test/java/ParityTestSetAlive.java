import com.sun.org.apache.xerces.internal.parsers.XPointerParserConfiguration;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParityTestSetAlive {

    GridFactory gridFactory = new GridFactory(3, 3, "1");
    IGrid grid = gridFactory.getGrid();

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    @Test
    public void invertGrid() throws Exception{
        grid.setValue(createPoint(1, 1), true);
        when(configReader.getLength()).thenReturn(3);
        when(configReader.getWidth()).thenReturn(3);
        when(configReader.getModel()).thenReturn("vonNeumann");
        Parity parity = new Parity(configReader);
        IGrid stepGrid = parity.step(grid);
        assertTrue(stepGrid.getValue(createPoint(1, 1)) == false);
        assertTrue(stepGrid.getValue(createPoint(0, 0)) == true);
        assertTrue(stepGrid.getValue(createPoint(0, 1)) == true);
        assertTrue(stepGrid.getValue(createPoint(0, 2)) == true);
        assertTrue(stepGrid.getValue(createPoint(1, 0)) == true);
        assertTrue(stepGrid.getValue(createPoint(1, 2)) == true);
        assertTrue(stepGrid.getValue(createPoint(2, 0)) == true);
        assertTrue(stepGrid.getValue(createPoint(2, 1)) == true);
        assertTrue(stepGrid.getValue(createPoint(2, 2)) == true);
    }


}
