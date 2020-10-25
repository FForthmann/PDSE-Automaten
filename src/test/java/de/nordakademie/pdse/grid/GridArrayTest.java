package de.nordakademie.pdse.grid;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GridArrayTest {

    @Test
    public void testCreateGrid() {
        int[][] testGrid = {{0}};
        assertEquals(Arrays.deepToString(testGrid), Arrays.deepToString(new GridArray(1, 1).getGrid()));
    }

    @Test
    public void testChangeValue() {
        int[][] testGrid = {{1}};
        GridArray currentGrid = new GridArray(1, 1);
        currentGrid.changeValue(new Point(0, 0));
        assertEquals(testGrid, currentGrid.getGrid());

    }


    @Test
    public void testGetVonNeumannNeighbors() {
        ArrayList<Point> expectedValues = new ArrayList<>();
        expectedValues.add(new Point(0, 0));
        expectedValues.add(new Point(1, 1));
        expectedValues.add(new Point(2, 0));
        GridArray currentGrid = new GridArray(4, 4);

        assertTrue(expectedValues.containsAll(currentGrid.getVonNeumannNeighbors(new Point(1, 0)))
                && currentGrid.getVonNeumannNeighbors(new Point(1, 0)).size() == expectedValues.size());

    }

    @Test
    public void testGetMooreNeighbors() {
        ArrayList<Point> expectedValues = new ArrayList<>();
        expectedValues.add(new Point(0, 0));
        expectedValues.add(new Point(0, 1));
        expectedValues.add(new Point(1, 1));
        expectedValues.add(new Point(2, 1));
        expectedValues.add(new Point(2, 0));
        GridArray currentGrid = new GridArray(4, 4);

        assertTrue(expectedValues.containsAll(currentGrid.getMooreNeighbors(new Point(1, 0)))
                && currentGrid.getMooreNeighbors(new Point(1, 0)).size() == expectedValues.size());
    }

    @Test
    public void testToString() {
        GridArray currentGrid = new GridArray(4, 4);
        String testString;
        testString = "0000" + "\n" + "0000" + "\n" + "0000" + "\n" + "0000" + "\n";
        assertEquals(testString, currentGrid.toString());
    }

    @Test
    public void testSetValue(){
        ArrayList<Point> expectedValues = new ArrayList<>();
        GridArray currentGrid = new GridArray(4, 4);
        assertFalse(currentGrid.getValue(new Point(0,0)));
        currentGrid.setValue(new Point(0,0), true);
        assertTrue(currentGrid.getValue(new Point(0,0)));
    }


}
