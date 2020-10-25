import java.awt.*;

public class Parity implements IGameType {
    ConfigReader configReader;

    public Parity() {
        this.configReader = new ConfigReader("config.properties");
    }

    public Parity(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public IGrid step(IGrid oldGrid) throws Exception {
        CopyGrid copyGrid = new CopyGrid(oldGrid);
        IGrid newGrid = oldGrid;
        if ("vonNeumann".equals(configReader.getModel())) {
            Point point;
            for (int length = 0; length < configReader.getGridLength(); length++) {
                for (int width = 0; width < configReader.getGridWidth(); width++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, copyGrid.getGrid().countvonNeumannActiveNeighbors(point) % 2 == 1);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid NeighborModel");
        }
        return newGrid;
    }
}
