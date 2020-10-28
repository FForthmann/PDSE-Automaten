package de.nordakademie.pdse.grid;
/**
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
        if ("GridArray".equals(dataStructure)) {
            return new GridArray(length, width);
        } else if ("GridPoints".equals(dataStructure)) {
            return new GridPoints(length, width);
        } else {
            throw new IllegalArgumentException("Invalid DataStrucutre");
        }
    }
}
