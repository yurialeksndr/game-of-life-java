package br.unb.cic.lp.gol.model;

import java.security.InvalidParameterException;

import br.unb.cic.lp.gol.Statistics;
import br.unb.cic.lp.gol.rules.Rules;

public abstract class Model {
	
	public abstract void nextGeneration() throws Exception;
	public abstract void undo() throws Exception;
	public abstract void makeCellAlive(int row, int column) throws InvalidParameterException;
	public abstract boolean isCellAlive(int i, int j) throws InvalidParameterException;
	public abstract int numberOfAliveCells();
	public abstract int numberOfNeighborhoodAliveCells(int i, int j);
	public abstract int getHeight();
	public abstract int getWidth();
	public abstract Rules getRule();
	public abstract void setRule(Rules rule);
	public abstract Cell[][] getCurrentGameState ();
	public abstract Statistics getStatistics();
	
}