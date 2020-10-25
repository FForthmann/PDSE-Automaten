import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public interface IGrid  extends Serializable {
    void changeValue(Point position);

    Object getGrid();

    ArrayList<Point> getMooreNeighbors(Point point);

    ArrayList<Point> getVonNeumannNeighbors(Point point);

    boolean getValue(Point position);

    String toString();

    void setValue(Point position, boolean value);

    public int countMooreActiveNeighbors(Point position);

    public int countvonNeumannActiveNeighbors(Point position);

    public Object clone() throws CloneNotSupportedException;
}
