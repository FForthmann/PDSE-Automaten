import java.util.Arrays;

public class GridArray {
    private final int length;
    private final int depth;
    private int[][] grid;

    public GridArray(int length, int depth) {
        this.length = length;
        this.depth = depth;
        createGrid();
    }

    private void createGrid() {
        grid = new int[depth][length];
        fillGrid();
    }

    public int[][] getGrid() {
        return grid;
    }

    private void fillGrid() {
        for (int[] length: grid){
            Arrays.fill(length, 0);
        }
    }

}
