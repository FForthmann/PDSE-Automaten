import java.awt.*;

public class GameOfLife implements IGameType{

    ConfigReader configReader = new ConfigReader("config.properties");

    public GameOfLife() {
        this.configReader = new ConfigReader("config.properties");
    }

    public GameOfLife(ConfigReader configReader){
        this.configReader = configReader;
    }

    @Override
    public IGrid step(IGrid oldGrid) throws Exception {
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
            if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                point = true;
            } else {
                point = false;
            }
        } else {
            if (aliveNeighbors == 3) {
                point = true;
            }
        }

        return point;
    }

}
