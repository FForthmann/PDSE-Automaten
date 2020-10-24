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
        IGrid newGrid = (IGrid) oldGrid.clone();
        if ("vonNeumann".equals(configReader.getModel())) {
            Point point;
            for (int length = 0; length < configReader.getLength(); length++) {
                for (int width = 0; width < configReader.getWidth(); width++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, oldGrid.countvonNeumannActiveNeighbors(point) % 2 == 1);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid NeighborModel");
        }
        return newGrid;
    }
}