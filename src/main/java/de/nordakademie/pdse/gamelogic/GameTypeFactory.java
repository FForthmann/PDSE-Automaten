package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;

/**
 * A factory that contains a getGameType method that is used to create instances of Parity and GameOfLife.
 *
 * @author Rane Petersen
 */
public class GameTypeFactory {
    ConfigReader configReader;

    public GameTypeFactory(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public IGameType getGameType() {
        if (configReader.getGameType().equalsIgnoreCase("Parity")) {
            return new Parity(configReader);
        } else {
            return new GameOfLife(configReader);
        }
    }
}
