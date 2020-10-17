import java.awt.*;

public interface IGrid {
    Object getGrid();

    void changeValue(Point position);

    boolean getValue(Point position);

}
