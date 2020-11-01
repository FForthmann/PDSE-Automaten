package de.nordakademie.pdse.experiments.gameoflife;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;

import java.io.File;

/**
 * @author Georg Mezlaw, Rane Petersen
 */
public class GameOfLife_Experiment_3_GridPoint {

    public static void main(String[] args) throws Exception {
        ConfigReader configReader = new ConfigReader(new File("src/main/resources/config.properties"));
        configReader.setGridLength("300");
        configReader.setGridWidth("300");
        configReader.setModel("Moore");
        configReader.setGameType("GameOfLife");
        configReader.setTerminationType("ttl");
        configReader.setTimeToLive("100");
        configReader.setLoggingType("file");
        configReader.setDatastructure("GridPoints");
        Game game = new Game(configReader);
        game.run();
    }

}
