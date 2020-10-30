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

public class ParityTestSetAlive {

    GridFactory gridFactory = new GridFactory(3, 3, "GridArray");
    IGrid grid = gridFactory.getGrid();

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    @Test
    public void trueValueToFalseThroughStepsInGrid() throws Exception {
        grid.setValue(createPoint(1, 1), true);
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getModel()).thenReturn("vonNeumann");
        Parity parity = new Parity(configReader);
        IGrid stepGrid = parity.step(grid);
        stepGrid.getValue(createPoint(0, 2));
        assertTrue(stepGrid.getValue(createPoint(0, 1)));
        assertFalse(stepGrid.getValue(createPoint(0, 2)));
        assertTrue(stepGrid.getValue(createPoint(1, 0)));
        assertFalse(stepGrid.getValue(createPoint(1, 1)));
        assertTrue(stepGrid.getValue(createPoint(1, 2)));
        assertFalse(stepGrid.getValue(createPoint(2, 0)));
        assertTrue(stepGrid.getValue(createPoint(2, 1)));
        assertFalse(stepGrid.getValue(createPoint(2, 2)));
    }
}
