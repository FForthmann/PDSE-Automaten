package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.GridFactory;
import de.nordakademie.pdse.grid.IGrid;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Rane Petersen, Fabian Forthmann
 */

public class GameOfLifeTestOneByOneGrid {

    GridFactory gridFactory = new GridFactory(1, 1, "GridArray");
    IGrid grid = gridFactory.getGrid();
    Point point = new Point(0, 0);

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test
    public void oneByOneGridWithFalseValueMoore(){
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test
    public void oneByOneGridWithTrueValueMoore(){
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test
    public void oneByOneGridWithFalseValueVonNeumann() {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test
    public void oneByOneGridWithTrueValueVonNeumann() {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }
}
