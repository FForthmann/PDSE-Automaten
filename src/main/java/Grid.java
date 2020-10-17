import java.awt.*;
import java.util.ArrayList;

public class Grid {
     private int depth;
     private int length;

    public ArrayList<Point> getMooreNeighbors(Point position) {
        ArrayList<Point> neighbors = new ArrayList<>();
        if (checkFieldExists(position.x - 1, position.y - 1)) {
            neighbors.add(new Point(position.x - 1, position.y - 1));
        }
        if (checkFieldExists(position.x - 1, position.y)) {
            neighbors.add(new Point(position.x - 1, position.y));
        }
        if (checkFieldExists(position.x - 1, position.y + 1)) {
            neighbors.add(new Point(position.x - 1, position.y + 1));
        }
        if (checkFieldExists(position.x, position.y - 1)) {
            neighbors.add(new Point(position.x, position.y - 1));
        }
        if (checkFieldExists(position.x, position.y + 1)) {
            neighbors.add(new Point(position.x, position.y + 1));
        }
        if (checkFieldExists(position.x + 1, position.y - 1)) {
            neighbors.add(new Point(position.x + 1, position.y - 1));
        }
        if (checkFieldExists(position.x + 1, position.y)) {
            neighbors.add(new Point(position.x + 1, position.y));
        }
        if (checkFieldExists(position.x + 1, position.y + 1)) {
            neighbors.add(new Point(position.x + 1, position.y + 1));
        }
        return neighbors;

    }

    private boolean checkFieldExists(int x, int y) {
        return x >= 0 && x <= depth - 1 && y >= 0 && y <= length - 1;
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
}
//todo methoden shrinken
