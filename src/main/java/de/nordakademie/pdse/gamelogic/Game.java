package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.GridFactory;
import de.nordakademie.pdse.grid.IGrid;
import de.nordakademie.pdse.logging.Logger;

/**
 * It summarizes the game logic and creates the game.
 *
 * @author Rane Petersen, Fabian Forthmann
 * @since 24.10.2020
 */
public class Game {

    IGrid grid;
    IGameType gameType;
    ConfigReader configReader;
    Boolean continueGame;
    Logger logger;
    int timeToLive;
    int iteration;


    public Game(ConfigReader configReader) {
        this.configReader = configReader;
        this.timeToLive = configReader.getTimeToLive();
        this.grid = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure()).getGrid();
        this.gameType = new GameTypeFactory(configReader).getGameType();
        this.logger = new Logger(configReader.getLoggingType());
        this.iteration = 0;
        if (configReader.getTerminationType().equalsIgnoreCase("ttl")) {
            this.continueGame = timeToLive > 0;
        } else {
            this.continueGame = true;
        }

    }

    private Boolean getContinueGame() {
        return continueGame;
    }

    private void setContinueGame(Boolean continueGame) {
        this.continueGame = continueGame;
    }

    private void reduceTimeToLive() {
        timeToLive--;
    }

    private int getTimeToLive() {
        return timeToLive;
    }

    private boolean isTimeToLiveZero() {
        if (getTimeToLive() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean processTimeToLive() {
        reduceTimeToLive();
        return isTimeToLiveZero();
    }

    private boolean gridChanged(IGrid grid) {
        if (this.grid.equals(grid)) {
            return false;
        } else {
            return true;
        }
    }

    private void checkForTermination(IGrid newGrid) {
        switch (configReader.getTerminationType().toLowerCase()) {
            case "ttl":
                this.setContinueGame(!processTimeToLive());
                break;
            case "nochange":
                this.setContinueGame(gridChanged(newGrid));
                break;
            case "ttlornochange":
                this.setContinueGame(!processTimeToLive() && this.gridChanged(newGrid));
                break;
        }
    }

    public IGrid getGird() {
        return grid;
    }

    public void setGrid(IGrid grid) {
        this.grid = grid;
    }

    private int getIteration() {
        return iteration;
    }

    private void setIteration(int iteration) {
        this.iteration = iteration;
    }

    private int getCurrentIterationAndIterate() {
        int i = this.getIteration();
        i++;
        this.setIteration(i);
        i--;
        return i;
    }

    public void run() throws Exception {
        logger.addGridToLog(getGird().toString(), getCurrentIterationAndIterate());
        while (this.getContinueGame()) {
            IGrid newGrid = gameType.step(getGird());
            checkForTermination(newGrid);
            this.setGrid(newGrid);
            logger.addGridToLog(getGird().toString(), getCurrentIterationAndIterate());
        }
    }
}
