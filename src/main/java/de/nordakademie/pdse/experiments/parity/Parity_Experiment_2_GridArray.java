package de.nordakademie.pdse.experiments.parity;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;
import java.io.File;

/**
 * @author Georg Mezlaw, Rane Petersen
 */
public class Parity_Experiment_2_GridArray {
    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public static void main(String[] args) throws Exception {
        ConfigReader configReader = new ConfigReader(new File("src/main/resources/config.properties"));
        configReader.setGridLength("100");
        configReader.setGridWidth("100");
        configReader.setModel("vonNeumann");
        configReader.setGameType("Parity");
        configReader.setTerminationType("ttl");
        configReader.setTimeToLive("100");
        configReader.setLoggingType("file");
        configReader.setDatastructure("GridArray");
        Game game = new Game(configReader);
        IGrid grid = game.getGird();
        for (int length = 0; length < configReader.getGridLength(); length++) {
            for (int width = 0; width < configReader.getGridWidth(); width++) {
                if (width % 2 == 0) {
                    if ((length % 2 == 1)) {
                        grid.setValue(createPoint(length, width), false);
                    } else {
                        grid.setValue(createPoint(length, width), true);
                    }
                } else {
                    if ((length % 2 == 1)) {
                        grid.setValue(createPoint(length, width), true);
                    } else {
                        grid.setValue(createPoint(length, width), false);
                    }
                }
            }
        }
        game.setGrid(grid);
        game.run();
    }
}
