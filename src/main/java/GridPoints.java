import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GridPoints implements IGrid {
    private final int length;
    private final int depth;
    private HashMap<Point, Boolean> grid;

    public GridPoints(int length, int depth) {
        this.length = length;
        this.depth = depth;
        createGrid();
    }

    private void createGrid() {
        grid = new HashMap<>();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < length; j++) {
                grid.put(new Point(j, i), false);
            }
        }
    }

    private boolean checkFieldExists(int x, int y) {
        return x >= 0 && x <= depth - 1 && y >= 0 && y <= length - 1;
    }

    public void changeValue(Point position) {
        if (getGrid().get(position).equals(false)) {
            getGrid().replace(position, true);
        } else {
            getGrid().replace(position, false);
        }


    }

    public HashMap<Point, Boolean> getGrid() {
        return grid;
    }

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
