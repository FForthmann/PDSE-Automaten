package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Rane Petersen
 */

public class GameTypeFactoryTest {

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test
    public void returnGameOfLife() {
        when(configReader.getGameType()).thenReturn("GameOfLife");
        IGameType gameType = new GameTypeFactory(configReader).getGameType();
        assertEquals(gameType.getClass(), GameOfLife.class);
    }

    @Test
    public void returnParity() {
        when(configReader.getGameType()).thenReturn("Parity");
        IGameType gameType = new GameTypeFactory(configReader).getGameType();
        assertEquals(gameType.getClass(), Parity.class);

    }
} 
