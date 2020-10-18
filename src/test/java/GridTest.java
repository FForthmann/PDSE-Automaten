import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void countMooreActiveNeighbors() {
        GridPoints currentGrid = new GridPoints(4, 4);
        currentGrid.changeValue(new Point(0, 1));
        currentGrid.changeValue(new Point(1, 1));
        assertEquals(2, currentGrid.countMooreActiveNeighbors(new Point(0, 0)));
    }

    @Test
    public void countvonNeumannActiveNeighbors() {
        GridPoints currentGrid = new GridPoints(4, 4);
        currentGrid.changeValue(new Point(0, 1));
        currentGrid.changeValue(new Point(1, 1));
        assertEquals(1, currentGrid.countvonNeumannActiveNeighbors(new Point(0, 0)));
    }
}