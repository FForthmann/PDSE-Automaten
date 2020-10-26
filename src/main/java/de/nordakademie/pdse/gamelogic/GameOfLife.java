package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;

public class GameOfLife implements IGameType {
    ConfigReader configReader;

    public GameOfLife(ConfigReader configReader) {
        this.configReader = configReader;
    }

    @Override
    public IGrid step(IGrid oldGrid) {
        IGrid newGrid = oldGrid;
        Point point;
        if ("Moore".equals(configReader.getModel())) {
            for (int width = 0; width < configReader.getGridLength() ; width++) {
                for (int length = 0; length < configReader.getGridWidth(); length++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, getPointStatus(oldGrid.getValue(point), oldGrid.countMooreActiveNeighbors(point)));
                }
            }
        } else if ("vonNeumann".equals(configReader.getModel())) {
            for (int width = 0; width < configReader.getGridLength(); width++) {
                for (int length = 0; length < configReader.getGridWidth(); length++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, getPointStatus(oldGrid.getValue(point), oldGrid.countVonNeumannActiveNeighbors(point)));
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
