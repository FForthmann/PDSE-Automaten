public class GridFactory {
    private final int depth;
    private final int length;
    private final int datastructure;

    public GridFactory(int length, int depth, String datastructure) {
        this.depth = depth;
        this.length = length;
        this.datastructure = Integer.parseInt(datastructure);
    }

    public IGrid getGrid() {
        if (datastructure == 1) {
            return new GridArray(length, depth);
        } else
            return new GridPoints(length, depth);
    }


}
