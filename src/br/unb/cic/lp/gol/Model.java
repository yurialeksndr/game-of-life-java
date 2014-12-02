package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;

public abstract class Model {
	
	public abstract void nextGeneration() throws Exception;
	public abstract void undo() throws Exception;
	public abstract void makeCellAlive(int row, int column) throws InvalidParameterException;
	public abstract boolean isCellAlive(int i, int j) throws InvalidParameterException;
	public abstract int numberOfAliveCells();
	public abstract int getHeight();
	public abstract int getWidth();
	public abstract Statistics getStatistics();
	
}
