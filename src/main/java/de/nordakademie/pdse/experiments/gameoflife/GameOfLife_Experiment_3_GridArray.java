package de.nordakademie.pdse.experiments.gameoflife;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;

import java.io.File;

public class GameOfLife_Experiment_3_GridArray {

    public static void main(String[] args) throws Exception {
        ConfigReader configReader = new ConfigReader(new File("src/main/resources/config.properties"));
        configReader.setGridLength("300");
        configReader.setGridWidth("300");
        configReader.setModel("Moore");
        configReader.setGameType("GameOfLife");
        configReader.setTerminationType("ttl");
        configReader.setTimeToLive("100");
        configReader.setDatastructure("GridArray");
        Game game = new Game(configReader);
        game.run();
    }

}