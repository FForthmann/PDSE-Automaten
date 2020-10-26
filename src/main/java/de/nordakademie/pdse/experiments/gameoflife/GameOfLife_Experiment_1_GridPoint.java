package de.nordakademie.pdse.experiments.gameoflife;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;
import java.io.File;

public class GameOfLife_Experiment_1_GridPoint {

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public static void main(String[] args) throws Exception {
        ConfigReader configReader = new ConfigReader(new File("src/main/resources/config.properties"));
        configReader.setGridLength("41");
        configReader.setGridWidth("40");
        configReader.setModel("Moore");
        configReader.setGameType("GameOfLife");
        configReader.setTerminationType("ttl");
        configReader.setTimeToLive("100");
        configReader.setDatastructure("GridPoints");
        Game game = new Game(configReader);
        IGrid grid = game.getGird();
        grid.setValue(createPoint(19, 18), true);
        grid.setValue(createPoint(20, 18), true);
        grid.setValue(createPoint(22, 18), true);
        grid.setValue(createPoint(23, 18), true);

        grid.setValue(createPoint(19, 19), true);
        grid.setValue(createPoint(20, 19), true);
        grid.setValue(createPoint(22, 19), true);
        grid.setValue(createPoint(23, 19), true);

        grid.setValue(createPoint(19, 20), true);
        grid.setValue(createPoint(19, 20), true);

        grid.setValue(createPoint(18, 21), true);
        grid.setValue(createPoint(20, 21), true);
        grid.setValue(createPoint(22, 21), true);
        grid.setValue(createPoint(24, 21), true);

        grid.setValue(createPoint(18, 22), true);
        grid.setValue(createPoint(20, 22), true);
        grid.setValue(createPoint(22, 22), true);
        grid.setValue(createPoint(24, 22), true);

        grid.setValue(createPoint(18, 23), true);
        grid.setValue(createPoint(19, 23), true);
        grid.setValue(createPoint(23, 23), true);
        grid.setValue(createPoint(24, 23), true);

        game.setGrid(grid);
        game.run();
    }
}
