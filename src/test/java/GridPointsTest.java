import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GridPointsTest {
    @Test
    public void testCreateGrid(){
        HashMap<Point, Boolean> testGrid = new HashMap<>();
        testGrid.put(new Point(0, 0), false);
        assertEquals(testGrid, new GridPoints(1,1).getGrid());
    }
    @Test
    public void testChangeValue(){
        HashMap<Point, Boolean> testGrid = new HashMap<>();
        testGrid.put(new Point(0, 0), true);
        GridPoints currentGrid = new GridPoints(1,1);
        currentGrid.changeValue(new Point(0,0));
        assertEquals(testGrid, currentGrid.getGrid());


    }

}