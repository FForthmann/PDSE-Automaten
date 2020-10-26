package de.nordakademie.pdse.grid;

import java.awt.*;
import java.util.HashMap;
/**
 *
 * @author Christian Apsel
 * @since 26.10.2020
 */
public class GridPoints extends Grid implements IGrid {
    private final int length;
    private final int depth;
    private HashMap<Point, Boolean> grid;

    public GridPoints(int length, int depth) {
        this.length = length;
        this.depth = depth;
        createGrid();
    }

    @Override
    public void changeValue(Point position) {
        if (getGrid().get(position).equals(false)) {
            getGrid().replace(position, true);
        } else {
            getGrid().replace(position, false);
        }
    }

    @Override
    public HashMap<Point, Boolean> getGrid() {
        return grid;
    }

    @Override
    public void setValue(Point position, boolean value) {
        getGrid().replace(position, value);
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
        grid = new HashMap<>();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < length; j++) {
                grid.put(new Point(i, j), false);
            }
        }
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
    public boolean getValue(Point position) {
        return getGrid().get(position);
    }
}
