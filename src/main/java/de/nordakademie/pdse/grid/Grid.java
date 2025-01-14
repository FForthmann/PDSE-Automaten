package de.nordakademie.pdse.grid;

import java.awt.*;
import java.util.ArrayList;

/**
 * abstract superclass, contains the logic for the playing field, can count neighbors and find out if a field exists
 *
 * @author Georg Mezlaw
 * @since 26.10.2020
 */
public abstract class Grid {

    abstract boolean checkFieldExists(int x, int y);

    public ArrayList<Point> getMooreNeighbors(Point position) {
        ArrayList<Point> neighbors = getVonNeumannNeighbors(position);
        if (checkFieldExists(position.x - 1, position.y - 1)) {
            neighbors.add(new Point(position.x - 1, position.y - 1));
        }
        if (checkFieldExists(position.x - 1, position.y + 1)) {
            neighbors.add(new Point(position.x - 1, position.y + 1));
        }
        if (checkFieldExists(position.x + 1, position.y - 1)) {
            neighbors.add(new Point(position.x + 1, position.y - 1));
        }
        if (checkFieldExists(position.x + 1, position.y + 1)) {
            neighbors.add(new Point(position.x + 1, position.y + 1));
        }
        return neighbors;
    }

    public ArrayList<Point> getVonNeumannNeighbors(Point position) {
        ArrayList<Point> neighbors = new ArrayList<>();
        if (checkFieldExists(position.x + 1, position.y)) {
            neighbors.add(new Point(position.x + 1, position.y));
        }
        if (checkFieldExists(position.x - 1, position.y)) {
            neighbors.add(new Point(position.x - 1, position.y));
        }
        if (checkFieldExists(position.x, position.y + 1)) {
            neighbors.add(new Point(position.x, position.y + 1));
        }
        if (checkFieldExists(position.x, position.y - 1)) {
            neighbors.add(new Point(position.x, position.y - 1));
        }
        return neighbors;
    }

    public int countMooreActiveNeighbors(Point position) {
        return (int) getMooreNeighbors(position).stream().filter(this::getValue).count();
    }

    public int countVonNeumannActiveNeighbors(Point position) {
        return (int) getVonNeumannNeighbors(position).stream().filter(this::getValue).count();
    }

    abstract boolean getValue(Point position);
}
