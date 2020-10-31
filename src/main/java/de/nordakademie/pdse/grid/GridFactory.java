package de.nordakademie.pdse.grid;

/**
 * This factory is used to create multiple object instances, inherits from the interface IGrid and uses the method getGrid to get the current grid.
 *
 * @author Christian Apsel
 * @since 26.10.2020
 */
public class GridFactory {
    private final int width;
    private final int length;
    private final String dataStructure;

    public GridFactory(int length, int width, String dataStructure) {
        this.width = width;
        this.length = length;
        this.dataStructure = dataStructure;
    }

    public IGrid getGrid() {
        if ("GridArray".equalsIgnoreCase(dataStructure)) {
            return new GridArray(length, width);
        } else {
            return new GridPoints(length, width);
        }
    }
}
