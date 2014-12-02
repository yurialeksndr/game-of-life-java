package br.unb.cic.lp.gol;

public abstract class Controller {
	
	private Model engine;
	private View board;
	
	public abstract void start();
	public abstract void makeCellAlive(int i, int j);
	public abstract void nextGeneration();
	public abstract void undo();
	public abstract void halt();

	public Model getEngine() {
		
		return engine;
		
	}
	
	public void setEngine(Model engine) {
		
		this.engine = engine;
		
	}
	
	public View getBoard() {
		
		return board;
		
	}
	
	public void setBoard(View board) {
		
		this.board = board;
		
	}
	
}
