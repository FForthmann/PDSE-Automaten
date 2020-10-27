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
    public void getGird() {
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure());
        grid = gridFactory.getGrid();
        Game game = new Game(configReader);
        game.setGrid(grid);
        assertEquals(grid, game.getGird());
    }

    @Test
    public void setGrid() {
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getTimeToLive()).thenReturn(2);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure());
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
