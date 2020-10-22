import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GridPointsTest {
    @Test
    public void testCreateGrid() {
        HashMap<Point, Boolean> testGrid = new HashMap<>();
        testGrid.put(new Point(0, 0), false);
        assertEquals(testGrid, new GridPoints(1, 1).getGrid());
    }

    @Test
    public void testChangeValue() {
        HashMap<Point, Boolean> testGrid = new HashMap<>();
        testGrid.put(new Point(0, 0), true);
        GridPoints currentGrid = new GridPoints(1, 1);
        currentGrid.changeValue(new Point(0, 0));
        assertEquals(testGrid, currentGrid.getGrid());
    }

    @Test
    public void testGetVonNeumannNeighbors() {
        ArrayList<Point> expectedValues = new ArrayList<>();
        expectedValues.add(new Point(0, 0));
        expectedValues.add(new Point(1, 1));
        expectedValues.add(new Point(2, 0));
        GridPoints currentGrid = new GridPoints(4, 4);

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
        GridPoints currentGrid = new GridPoints(4, 4);

        assertTrue(expectedValues.containsAll(currentGrid.getMooreNeighbors(new Point(1, 0)))
                && currentGrid.getMooreNeighbors(new Point(1, 0)).size() == expectedValues.size());
    }

    @Test
    public void testSetValue(){
        ArrayList<Point> expectedValues = new ArrayList<>();
        GridPoints currentGrid = new GridPoints(4, 4);
        assertFalse(currentGrid.getValue(new Point(0,0)));
        currentGrid.setValue(new Point(0,0), true);
        assertTrue(currentGrid.getValue(new Point(0,0)));
    }

    @Test
    public void testToString() {
        GridPoints currentGrid = new GridPoints(4, 4);
        String testString;
        testString = "0000" + "\n" + "0000" + "\n" + "0000" + "\n" + "0000" + "\n";
        assertEquals(testString, currentGrid.toString());
    }

}