package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.grid.IGrid;

/**
 * It goes over the playing field and starts the next iteration of the game. It checks for each cell how it changes and writes the result into a new game iteration
 *
 * @author Rane Petersen
 */
public interface IGameType {

    public IGrid step(IGrid oldGrid) throws Exception;
}
