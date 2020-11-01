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
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTestLoggerAndRun {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    IGrid grid;

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @After
    public void after() {
        outputStreamCaptor.reset();
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void noChange() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        when(configReader.getTerminationType()).thenReturn("noChange");
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getModel()).thenReturn("vonNeumann");
        when(configReader.getTimeToLive()).thenReturn(10);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid.setValue(new Point(1, 1), true);
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.run();
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
    public void ttlZero() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        when(configReader.getTerminationType()).thenReturn("ttl");
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getModel()).thenReturn("vonNeumann");
        when(configReader.getTimeToLive()).thenReturn(0);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid.setValue(new Point(1, 1), true);
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.run();
        assertTrue(game.getGird().getValue(new Point(1, 1)));
        String expectedOutput = "###0\n" +
                "000\n" +
                "010\n" +
                "000\n" +
                "\r\n";
        assertArrayEquals(expectedOutput.toCharArray(), outputStreamCaptor.toString().toCharArray());
    }

    @Test
    public void ttlOrNoChangeBreakttl() throws Exception {
        when(configReader.getTerminationType()).thenReturn("ttlOrNoChange");
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getModel()).thenReturn("vonNeumann");
        when(configReader.getTimeToLive()).thenReturn(1);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid.setValue(new Point(1, 1), true);
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.run();
    }

    @Test
    public void ttlOrNoChangeBreakNoChange() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        when(configReader.getTerminationType()).thenReturn("ttlOrNoChange");
        when(configReader.getGridLength()).thenReturn(3);
        when(configReader.getGridWidth()).thenReturn(3);
        when(configReader.getLoggingType()).thenReturn("console");
        when(configReader.getDatastructure()).thenReturn("GridArray");
        when(configReader.getGameType()).thenReturn("Parity");
        when(configReader.getModel()).thenReturn("vonNeumann");
        when(configReader.getTimeToLive()).thenReturn(10);
        GridFactory gridFactory = new GridFactory(configReader.getGridLength(), configReader.getGridWidth(), configReader.getDatastructure());
        grid = gridFactory.getGrid();
        grid.setValue(new Point(1, 1), true);
        Game game = new Game(configReader);
        game.setGrid(grid);
        game.run();
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
}
