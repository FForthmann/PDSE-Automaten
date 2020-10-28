package de.nordakademie.pdse.grid;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * contains important information for the playing field. Can determine if a cell is alive or dead, return the playing field, return neighbors and count the neighbors
 *
 * @author Georg Mezlaw
 * @since 26.10.2020
 */
public interface IGrid extends Serializable {
    void changeValue(Point position);

    Object getGrid();

    ArrayList<Point> getMooreNeighbors(Point point);

    ArrayList<Point> getVonNeumannNeighbors(Point point);

    boolean getValue(Point position);

    String toString();

    void setValue(Point position, boolean value);

    public int countMooreActiveNeighbors(Point position);

    public int countVonNeumannActiveNeighbors(Point position);

}
