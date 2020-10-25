package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.GridFactory;
import de.nordakademie.pdse.grid.IGrid;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Mock
    IGrid grid = mock(IGrid.class);

    @Mock
    IGrid grid2 = mock(IGrid.class);

    @Test
    public void getContinueGame() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        Game game = new Game(configReader);
        assertTrue(game.getContinueGame());
    }

    @Test
    public void setContinueGame() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        Game game = new Game(configReader);
        game.setContinueGame(false);
        assertFalse(game.getContinueGame());
    }

    @Test
    public void reduceTimeToLive() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(42);
        Game game = new Game(configReader);
        game.reduceTimeToLive();
        assertEquals(game.getTimeToLive(), 41);
    }

    @Test
    public void getTimeToLive() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(42);
        Game game = new Game(configReader);
        assertEquals(game.getTimeToLive(), 42);
    }

    @Test
    public void isTimeToLiveZero() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(1);
        Game game = new Game(configReader);
        assertFalse(game.isTimeToLiveZero());
        game.reduceTimeToLive();
        assertTrue(game.isTimeToLiveZero());
    }

    @Test
    public void processTimeToLive() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(42);
        Game game = new Game(configReader);
        assertFalse(game.processTimeToLive());
        assertEquals(game.getTimeToLive(), 41);
    }

    @Test
    public void checkForTerminationTTLBreak() {
        when(configReader.getTerminationType()).thenReturn("ttl");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(0);
        Game game = new Game(configReader);
        game.checkForTermination(grid);
        assertFalse(game.getContinueGame());
    }

    @Test
    public void checkForTerminationTTLContinue() {
        when(configReader.getTerminationType()).thenReturn("ttl");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        Game game = new Game(configReader);
        game.checkForTermination(grid);
        assertTrue(game.getContinueGame());
    }

    @Test
    public void gridChanged() {
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(42);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid2 = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        assertFalse(game.gridChanged(grid));
        assertTrue(game.gridChanged(grid2));
    }

    @Test
    public void checkForTerminationNoChangeContinue() {
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(1);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid2 = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.checkForTermination(grid2);
        assertTrue(game.getContinueGame());
    }

    @Test
    public void checkForTerminationNoChangeBreak() {
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.checkForTermination(grid);
        assertFalse(game.getContinueGame());
    }

    @Test
    public void checkForTerminationTTLOrNoChangeNoGridChange() {
        when(configReader.getTerminationType()).thenReturn("ttlOrNoChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.checkForTermination(grid);
        assertFalse(game.getContinueGame());
    }

    @Test
    public void checkForTerminationTTLOrNoChangeTTLZero() {
        when(configReader.getTerminationType()).thenReturn("ttlOrNoChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(1);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.checkForTermination(grid);
        assertFalse(game.getContinueGame());
    }

    @Test
    public void checkForTerminationTTLOrNoChangeContinue() {
        when(configReader.getTerminationType()).thenReturn("ttlOrNoChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid2 = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.checkForTermination(grid2);
        assertTrue(game.getContinueGame());
    }

    @Test
    public void checkForTerminationTTLOrNoChangeBoth() {
        when(configReader.getTerminationType()).thenReturn("ttlOrNoChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(1);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid2 = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.checkForTermination(grid2);
        assertEquals(game.getTimeToLive(),0);
        assertEquals(grid,game.getGird());
        assertFalse(game.getContinueGame());
    }

    @Test
    public void getGird() {
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        assertEquals(grid, game.getGird());
    }

    @Test
    public void setGrid() {
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(),configReader.getGridWidth(),configReader.getDatastructure());
        grid = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        assertEquals(grid, game.getGird());
        game.setGrid(grid2);
        assertEquals(grid2, game.getGird());
        assertNotEquals(grid, game.getGird());
    }

    @Test
    public void run() {
        // TODO Write the test
    }
}
