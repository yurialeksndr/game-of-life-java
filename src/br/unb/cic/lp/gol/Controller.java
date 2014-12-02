package br.unb.cic.lp.gol;

public abstract class Controller {
	
	public abstract void start();
	public abstract void makeCellAlive(int i, int j);
	public abstract void nextGeneration();
	public abstract void undo();
	public abstract void halt();
	
	public abstract Model getEngine();
	public abstract void setEngine(Model engine);
	public abstract View getBoard();
	public abstract void setBoard(View board);
	
}
