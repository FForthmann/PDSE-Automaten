package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;

/**
 * Contains the game logic for the game mode of the Game of Life, has like Parity the step method and additionally because of further game rules an extended logic in the method getPointStatus
 */
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
