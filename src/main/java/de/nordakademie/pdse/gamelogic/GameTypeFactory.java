package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;

/**
 * A factory that contains a getGameType method that is used to create instances of Parity and GameOfLife.
 */
public class GameTypeFactory {
    ConfigReader configReader;

    public GameTypeFactory(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public IGameType getGameType() {
        if (configReader.getGameType().equals("Parity")) {
            return new Parity(configReader);
        } else if (configReader.getGameType().equals("GameOfLife")) {
            return new GameOfLife(configReader);
        } else {
            throw new IllegalArgumentException("Invalid GameType");
        }
    }
}
