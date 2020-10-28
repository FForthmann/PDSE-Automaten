package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.CopyGrid;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;

/**
 * This class uses the step method to check whether a point is "dead" or "alive".
 */
public class Parity implements IGameType {
    ConfigReader configReader;

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
                    newGrid.setValue(point, copyGrid.getGrid().countVonNeumannActiveNeighbors(point) % 2 == 1);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid NeighborModel");
        }
        return newGrid;
    }
}
