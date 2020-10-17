import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GridPointsTest {
    @Test
    public void testCreateGrid() {
        HashMap<Point, Boolean> testGrid = new HashMap<>();
        testGrid.put(new Point(0, 0), false);
        assertEquals(testGrid, new GridPoints(1, 1).getGrid());
    }

    @Test
    public void testgetVonNeumannNeighbors() {
        HashMap<Point, Boolean> testGrid = new HashMap<>();
        testGrid.put(new Point(0, 0), true);
        GridPoints currentGrid = new GridPoints(1, 1);
        currentGrid.changeValue(new Point(0, 0));
        assertEquals(testGrid, currentGrid.getGrid());
    }

    public void testNeighbors() {
        ArrayList<Point> expectedValues = new ArrayList<>();
        expectedValues.add(new Point(0, 0));
        expectedValues.add(new Point(1, 1));
        expectedValues.add(new Point(2, 0));
        GridPoints currentGrid = new GridPoints(4, 4);

        assertTrue(expectedValues.containsAll(currentGrid.getVonNeumannNeighbors(new Point(1, 0)))
                && currentGrid.getVonNeumannNeighbors(new Point(1, 0)).size() == expectedValues.size());

    }


}