package de.nordakademie.pdse.experiments.parity;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;
import java.io.File;

/**
 * @author Georg Mezlaw, Rane Petersen
 */
public class Parity_Experiment_1_GridPoint {

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public static void main(String[] args) throws Exception {
        ConfigReader configReader = new ConfigReader(new File("src/main/resources/config.properties"));
        configReader.setGridLength("400");
        configReader.setGridWidth("400");
        configReader.setModel("vonNeumann");
        configReader.setGameType("Parity");
        configReader.setTerminationType("ttl");
        configReader.setTimeToLive("100");
        configReader.setLoggingType("file");
        configReader.setDatastructure("GridPoint");
        Game game = new Game(configReader,"Parity_Experiment_1_GridPoint");
        IGrid grid = game.getGird();
        grid.setValue(createPoint(200, 200), true);
        grid.setValue(createPoint(200, 201), true);
        grid.setValue(createPoint(201, 200), true);
        grid.setValue(createPoint(201, 201), true);
        game.run();
    }
}
