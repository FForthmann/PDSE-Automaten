import java.awt.*;

public class Game {

    IGrid grid;
    IGameType gameType;
    ConfigReader configReader;
    Boolean continueGame;
    int timeToLive;

    public Game(ConfigReader configReader) {
        this.configReader = configReader;
        this.timeToLive = configReader.getTimeToLive();
        this.grid = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure()).getGrid();
        this.gameType = new GameTypeFactory(configReader).getGameType();
        this.continueGame = true;
    }

    public Boolean getContinueGame() {
        return continueGame;
    }

    public void setContinueGame(Boolean continueGame) {
        this.continueGame = continueGame;
    }

    public void reduceTimeToLive() {
        timeToLive--;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public boolean isTimeToLiveZero() {
        if (getTimeToLive() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean processTimeToLive() {
        reduceTimeToLive();
        return isTimeToLiveZero();
    }

    public boolean gridChanged(IGrid grid) {
        if (this.grid.equals(grid)) {
            return false;
        } else {
            return true;
        }
    }

    public void checkForTermination(IGrid newGrid) {
        switch (configReader.getTerminationType()) {
            case "ttl":
                this.setContinueGame(!processTimeToLive());
                break;
            case "noChange":
                this.setContinueGame(gridChanged(newGrid));
                break;
            case "ttlOrNoChange":
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

    public void run() throws Exception {
        while (this.getContinueGame()) {
            IGrid newGrid = gameType.step(getGird());
            checkForTermination(newGrid);
            if (getContinueGame()) {
                this.setGrid(newGrid);
            }
        }
    }
}