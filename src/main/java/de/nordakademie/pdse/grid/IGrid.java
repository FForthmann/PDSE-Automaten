package de.nordakademie.pdse.grid;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
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
