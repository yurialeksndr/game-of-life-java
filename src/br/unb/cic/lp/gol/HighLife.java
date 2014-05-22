package br.unb.cic.lp.gol;

public class HighLife extends Conway {

	public HighLife(GameEngine engine) {
		super(engine);
	}
	
	@Override
	public boolean shouldRevive(int i, int j) {
		return (!engine.isCellAlive(i, j))
				&& (engine.numberOfNeighborhoodAliveCells(i, j) == 3)
				|| (engine.numberOfNeighborhoodAliveCells(i, j) == 6);
	}

	
}
