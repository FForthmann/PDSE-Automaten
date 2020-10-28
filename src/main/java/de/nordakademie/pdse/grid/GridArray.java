package de.nordakademie.pdse.grid;

import java.awt.*;
import java.util.Arrays;

/**
 *
 * @author Christian Apsel
 * @since 26.10.2020
 */
public class GridArray extends Grid implements IGrid {
    private final int length;
    private final int width;
    private int[][] grid;

    public GridArray(int length, int width) {
        this.length = length;
        this.width = width;
        createGrid();
    }

    @Override
    public void changeValue(Point position) {
        int width = position.x;
        int length = position.y;

        if (getGrid()[width][length] == 0) {
            getGrid()[width][length] = 1;
        } else {
            getGrid()[width][length] = 0;
        }
    }

    @Override
    public void setValue(Point position, boolean value) {
        int width = position.x;
        int length = position.y;
        grid[width][length] = value ? 1 : 0;
    }


    @Override
    boolean checkFieldExists(int x, int y) {
        return x >= 0 && x <= width - 1 && y >= 0 && y <= length - 1;
    }

    @Override
    public boolean getValue(Point position) {
        int width = position.x;
        int length = position.y;
        return getGrid()[width][length] != 0;
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

    private void createGrid() {
        grid = new int[width][length];
        fillGrid();
    }

    //TODO Duplicate Code entfernen
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {

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
}
