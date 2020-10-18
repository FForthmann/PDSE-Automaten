import java.awt.*;
import java.util.ArrayList;

public interface IGrid {
    void changeValue(Point position);

    Object getGrid();

    ArrayList<Point> getMooreNeighbors(Point point);

    ArrayList<Point> getVonNeumannNeighbors(Point point);

    boolean getValue(Point position);

}
