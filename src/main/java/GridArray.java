import java.awt.*;
import java.util.Arrays;

public class GridArray extends Grid implements IGrid {
    private final int length;
    private final int depth;
    private int[][] grid;

    public GridArray(int length, int depth) {
        this.length = length;
        this.depth = depth;
        createGrid();
    }

    @Override
    public void changeValue(Point position) {
        int depth = position.x;
        int length = position.y;

        if (getGrid()[depth][length] == 0) {
            getGrid()[depth][length] = 1;
        } else {
            getGrid()[depth][length] = 0;
        }
    }

    @Override
    boolean checkFieldExists(int x, int y) {
        return x >= 0 && x <= depth - 1 && y >= 0 && y <= length - 1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private void createGrid() {
        grid = new int[depth][length];
        fillGrid();
    }

    @Override
    public boolean getValue(Point position) {
        int depth = position.x;
        int length = position.y;
        return getGrid()[depth][length] != 0;
    }

    private void fillGrid() {
        for (int[] length : grid) {
            Arrays.fill(length, 0);
        }
    }

    @Override
    public int[][] getGrid() {
        return grid;
    }

    //TODO Duplicate Code entfernen
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {

            for (int j = 0; j < length; j++) {

                if (getValue(new Point(i, j))) {
                    stringBuilder.append(1);
                } else {
                    stringBuilder.append(0);
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void setValue(Point position, boolean value) {
        int depth = position.x;
        int length = position.y;
        grid[depth][length] = value ? 1 : 0;
    }
}
