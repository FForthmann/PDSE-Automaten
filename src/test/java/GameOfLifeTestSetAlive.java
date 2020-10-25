import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameOfLifeTestSetAlive {

    GridFactory gridFactory = new GridFactory(3, 3, "GridArray");
    IGrid grid = gridFactory.getGrid();

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    @Test
    // TODO Rename class and check if development is right if some values are alive
    public void invertGrid() throws Exception {
        grid.setValue(createPoint(1, 1), true);
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        IGrid stepGrid = gameOfLife.step(grid);
    }

    // TODO add other tests
}
