import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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
        currentGrid.changeValue(0, 0);
        assertEquals(testGrid, currentGrid.getGrid());

    }
}