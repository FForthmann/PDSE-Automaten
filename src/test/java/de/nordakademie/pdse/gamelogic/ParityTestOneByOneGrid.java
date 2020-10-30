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
 * @author Rane Petersen, Fabian Forthmann
 */

public class ParityTestOneByOneGrid {

    GridFactory gridFactory = new GridFactory(1, 1, "GridArray");
    IGrid grid = gridFactory.getGrid();
    Point point = new Point(0, 0);

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test(expected = IllegalArgumentException.class)
    public void emptyParityGridMooreInvalid() throws Exception {
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");
        Parity parity = new Parity(configReader);
        parity.step(grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void trueParityGridMooreInvalid() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");
        Parity parity = new Parity(configReader);
        parity.step(grid);
    }

    @Test
    public void emptyParityGridVonNeumann() throws Exception {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");
        Parity parity = new Parity(configReader);
        assertFalse(parity.step(grid).getValue(point));
    }

    @Test
    public void trueParityGridVonNeumann() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");
        Parity parity = new Parity(configReader);
        assertFalse(parity.step(grid).getValue(point));
    }
}
