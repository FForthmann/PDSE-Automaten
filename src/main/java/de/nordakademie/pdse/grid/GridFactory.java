package de.nordakademie.pdse.grid;

public class GridFactory {
    private final int depth;
    private final int length;
    private final String dataStructure;

    public GridFactory(int length, int depth, String dataStructure) {
        this.depth = depth;
        this.length = length;
        this.dataStructure = dataStructure;
    }

    public IGrid getGrid() {
        if ("GridArray".equals(dataStructure)) {
            return new GridArray(length, depth);
        } else if ("GridPoint".equals(dataStructure)) {
            return new GridPoints(length, depth);
        } else {
            throw new IllegalArgumentException("Invalid DataStrucutre");
        }
    }
}
