package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.GridFactory;
import de.nordakademie.pdse.grid.IGrid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Rane Petersen
 */

public class GameTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @After
    public void after() {
        outputStreamCaptor.reset();
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

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
    public void run() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        GridFactory gridFactory = new GridFactory(3, 3, "GridArray");
        IGrid grid = gridFactory.getGrid();
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getModel()).thenReturn("vonNeumann");
        when(configReader.getTerminationType()).thenReturn("ttl");
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getTimeToLive()).thenReturn(2);
        grid.setValue(new Point(1, 1), true);
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.run();
        IGrid checkGrid = game.getGird();
        for (int width = 0; width < 3; width++) {
            for (int length = 0; length < 3; length++) {
                assertFalse(checkGrid.getValue(new Point(length, width)));
            }
        }
        String expectedOutput = "###0\n" +
                "000\n" +
                "010\n" +
                "000\n" +
                "\r\n" +
                "###1\n" +
                "010\n" +
                "101\n" +
                "010\n" +
                "\r\n" +
                "###2\n" +
                "000\n" +
                "000\n" +
                "000\n" +
                "\r\n";
        assertArrayEquals(expectedOutput.toCharArray(), outputStreamCaptor.toString().toCharArray());
    }

    @Test
    public void secondaryConstructor() throws Exception {
        GridFactory gridFactory = new GridFactory(3, 3, "GridArray");
        IGrid grid = gridFactory.getGrid();
        String fileName = "testSecondaryConstructor";
        assertFalse(new File(fileName + ".log").exists());
        when(configReader.getLoggingType()).thenReturn("file");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getModel()).thenReturn("vonNeumann");
        when(configReader.getTerminationType()).thenReturn("ttl");
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getTimeToLive()).thenReturn(0);
        grid.setValue(new Point(1, 1), true);
        Game game = new Game(configReader, fileName);
        assertTrue(new File(fileName + ".log").exists());
        game.setGrid(grid);
        game.run();
        assertTrue(new File(fileName + ".log").exists());
        new File(fileName + ".log").delete();
        assertFalse(new File(fileName + ".log").exists());
    }
}
