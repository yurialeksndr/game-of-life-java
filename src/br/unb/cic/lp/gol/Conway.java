package br.unb.cic.lp.gol;

public class Conway implements Strategy {

	protected GameEngine engine;
	
	public Conway(GameEngine engine) {
		this.engine = engine;
	}
	
	@Override
	public boolean shouldKeepAlive(int i, int j) {
		return engine.isCellAlive(i, j)
				&& (engine.numberOfNeighborhoodAliveCells(i, j) == 2) 
				|| (engine.numberOfNeighborhoodAliveCells(i, j) == 3);
	
	}

	@Override
	public boolean shouldRevive(int i, int j) {
		return (!engine.isCellAlive(i, j))
				&& (engine.numberOfNeighborhoodAliveCells(i, j) == 3);
	
	}
	
	

}
