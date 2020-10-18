import java.awt.*;

public interface IGrid {
    void changeValue(Point position);

    Object getGrid();

    boolean getValue(Point position);

    String toString();

    void setValue(Point position, int value);

}
