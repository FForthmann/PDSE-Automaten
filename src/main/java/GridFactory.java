public class GridFactory {
    private final int depth;
    private final int length;
    private final int datastructure;

    public GridFactory(int length, int depth) {
        this.depth = depth;
        this.length = length;
        ConfigReader configReader = new ConfigReader();
        this.datastructure = Integer.parseInt(configReader.getDatastructure());
    }

    public IGrid getGrid() {
        if (datastructure == 1) {
            return new GridArray(length, depth);
        } else
            return new GridPoints(length, depth);
    }

}
