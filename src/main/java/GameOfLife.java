import java.awt.*;
import java.io.File;

public class GameOfLife implements IGameType {
    ConfigReader configReader;

    public GameOfLife() {
        final File propertyFile = new File("config.properties");
        this.configReader = new ConfigReader(propertyFile);
    }

    public GameOfLife(ConfigReader configReader) {
        this.configReader = configReader;
    }

    @Override
    public IGrid step(IGrid oldGrid) {
        IGrid newGrid = oldGrid; //TODO grid kopieren anstatt zu pointen
        Point point;
        if ("Moore".equals(configReader.getModel())) {
            for (int length = 0; length < configReader.getGridLength(); length++) {
                for (int width = 0; width < configReader.getGridWidth(); width++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, getPointStatus(oldGrid.getValue(point), oldGrid.countMooreActiveNeighbors(point)));
                }
            }
        } else if ("vonNeumann".equals(configReader.getModel())) {
            for (int length = 0; length < configReader.getGridLength(); length++) {
                for (int width = 0; width < configReader.getGridWidth(); width++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, getPointStatus(oldGrid.getValue(point), oldGrid.countvonNeumannActiveNeighbors(point)));
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid NeighborModel");
        }
        return newGrid;
    }

    private static boolean getPointStatus(Boolean point, int aliveNeighbors) {

        if (point.equals(true)) {
            point = aliveNeighbors == 2 || aliveNeighbors == 3;
        } else {
            if (aliveNeighbors == 3) {
                point = true;
            }
        }

        return point;
    }

}
