package de.nordakademie.pdse.grid;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertNotEquals;

public class CopyGridTest {
    @Test
    public void testGetGrid() {
        IGrid originalGrid = new GridPoints(5, 5);
        CopyGrid copyGrid = new CopyGrid(originalGrid);
        originalGrid.setValue(new Point(0, 0), true);
        assertNotEquals(originalGrid.getValue(new Point(0, 0)), copyGrid.getGrid().getValue(new Point(0, 0)));
    }
}
