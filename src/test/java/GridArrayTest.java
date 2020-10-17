import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

}