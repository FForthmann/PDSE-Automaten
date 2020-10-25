package de.nordakademie.pdse.grid;

import de.nordakademie.pdse.config.ConfigReader;
import org.junit.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GridFactoryTest {

    @Test
    public void testGetGridAsGridArray() {
        ConfigReader configReader = mock(ConfigReader.class);
        when(configReader.getDatastructure()).thenReturn("GridArray");
        GridFactory gridFactory = new GridFactory(4, 4, (configReader.getDatastructure()));
        IGrid currentGrid = new GridArray(4, 4);
        assertTrue(new ReflectionEquals(currentGrid).matches(gridFactory.getGrid()));
    }

    @Test
    public void testGetGridAsGridPoints() {
        ConfigReader configReader = mock(ConfigReader.class);
        when(configReader.getDatastructure()).thenReturn("GridPoint");
        GridFactory gridFactory = new GridFactory(4, 4, configReader.getDatastructure());
        IGrid currentGrid = new GridPoints(4, 4);
        assertTrue(new ReflectionEquals(currentGrid).matches(gridFactory.getGrid()));
    }
}
