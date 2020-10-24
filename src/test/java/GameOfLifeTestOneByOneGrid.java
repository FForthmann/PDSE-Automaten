import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameOfLifeTestOneByOneGrid {

    GridFactory gridFactory = new GridFactory(1, 1, "1");
    IGrid grid = gridFactory.getGrid();
    Point point = new Point(0, 0);

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test
    public void falseGridMoore() throws Exception {
        grid.setValue(point, false);
        when(configReader.getLength()).thenReturn(1);
        when(configReader.getWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");
        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertTrue(gameOfLife.step(grid).getValue(point) == false);
    }

    @Test
    public void trueGridMoore() throws Exception {
        grid.setValue(point, true);
        when(configReader.getLength()).thenReturn(1);
        when(configReader.getWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");
        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertTrue(gameOfLife.step(grid).getValue(point) == false);
    }

    @Test
    public void falseGridNeumann() throws Exception {
        grid.setValue(point, false);
        when(configReader.getLength()).thenReturn(1);
        when(configReader.getWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");
        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertTrue(gameOfLife.step(grid).getValue(point) == false);
    }

    @Test
    public void trueGridNeumann() throws Exception {
        grid.setValue(point, true);
        when(configReader.getLength()).thenReturn(1);
        when(configReader.getWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");
        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertTrue(gameOfLife.step(grid).getValue(point) == false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void falseGridInvalidModel() throws Exception {
        grid.setValue(point, false);
        when(configReader.getLength()).thenReturn(1);
        when(configReader.getWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("");
        GameOfLife gameOfLife = new GameOfLife(configReader);
        gameOfLife.step(grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void trueGridInvalidModel() throws Exception {
        grid.setValue(point, true);
        when(configReader.getLength()).thenReturn(1);
        when(configReader.getWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("");
        GameOfLife gameOfLife = new GameOfLife(configReader);
        gameOfLife.step(grid);
    }
}