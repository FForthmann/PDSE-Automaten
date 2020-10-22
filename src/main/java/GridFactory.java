public class GridFactory {
    private final int depth;
    private final int length;
    private final int dataStructure;

    public GridFactory(int length, int depth, String dataStructure) {
        this.depth = depth;
        this.length = length;
        this.dataStructure = Integer.parseInt(dataStructure);
    }

    public IGrid getGrid() {
        if (dataStructure == 1) {
            return new GridArray(length, depth);
        } else
            return new GridPoints(length, depth);
    }


}
