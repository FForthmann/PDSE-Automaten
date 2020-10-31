package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.CopyGrid;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;

/**
 * Contains the game logic for the game mode of the Game of Life, has like Parity the step method and additionally because of further game rules an extended logic in the method getPointStatus
 *
 * @author Rane Petersen
 */
public class GameOfLife implements IGameType {
    ConfigReader configReader;

    public GameOfLife(ConfigReader configReader) {
        this.configReader = configReader;
    }

    @Override
    public IGrid step(IGrid oldGrid) {
        CopyGrid copyGrid = new CopyGrid(oldGrid);
        IGrid newGrid = oldGrid;
        Point point;
        if ("Moore".equalsIgnoreCase(configReader.getModel())) {
            for (int width = 0; width < configReader.getGridLength(); width++) {
                for (int length = 0; length < configReader.getGridWidth(); length++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, getPointStatus(copyGrid.getGrid().getValue(point), copyGrid.getGrid().countMooreActiveNeighbors(point)));
                }
            }
        } else if ("vonNeumann".equalsIgnoreCase(configReader.getModel())) {
            for (int width = 0; width < configReader.getGridLength(); width++) {
                for (int length = 0; length < configReader.getGridWidth(); length++) {
                    point = new Point(length, width);
                    newGrid.setValue(point, getPointStatus(copyGrid.getGrid().getValue(point), copyGrid.getGrid().countVonNeumannActiveNeighbors(point)));
                }
            }
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
