package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.grid.IGrid;

public interface IGameType {

    public IGrid step(IGrid oldGrid) throws Exception;
}
