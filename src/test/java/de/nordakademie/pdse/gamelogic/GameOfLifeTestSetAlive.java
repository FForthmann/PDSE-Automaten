package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.GridFactory;
import de.nordakademie.pdse.grid.IGrid;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Rane Petersen
 */

public class GameOfLifeTestSetAlive {

    GridFactory gridFactory = new GridFactory(3, 3, "GridArray");
    IGrid grid = gridFactory.getGrid();

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test
    public void trueValueToFalseThroughStep(){
        grid.setValue(new Point(1, 1), true);
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        IGrid stepGrid = gameOfLife.step(grid);
        assertFalse(stepGrid.getValue(new Point(1,1)));
    }

    @Test
    public void falseValueToTrueThroughStep() {
        grid.setValue(new Point(0, 0), true);
        grid.setValue(new Point(0, 1), true);
        grid.setValue(new Point(0, 2), true);
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        IGrid stepGrid = gameOfLife.step(grid);
        assertTrue(stepGrid.getValue(new Point(0,1)));
        assertTrue(stepGrid.getValue(new Point(1,1)));
        assertFalse(stepGrid.getValue(new Point(0,0)));
        assertFalse(stepGrid.getValue(new Point(0,2)));
        assertFalse(stepGrid.getValue(new Point(1,0)));
        assertFalse(stepGrid.getValue(new Point(1,2)));
    }
}
