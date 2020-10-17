import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GridArrayTest {

    @Test
    public void testCreateGrid() {
        int[][] testGrid = {{0}};
        Assert.assertEquals(Arrays.deepToString(testGrid), Arrays.deepToString(new GridArray(1, 1).getGrid()));
    }

}