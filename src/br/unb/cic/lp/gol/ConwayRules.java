package br.unb.cic.lp.gol;

public class ConwayRules extends Rules {
	
	/* verifica se uma celula deve ser mantida viva */
	public boolean shouldKeepAlive(int i, int j, Model engine) {

		return (engine.getCurrentGameState()[i][j].isAlive())
				&& (engine.numberOfNeighborhoodAliveCells(i, j) == 2 || engine.numberOfNeighborhoodAliveCells(i, j) == 3);
		
	}
	

	/* verifica se uma celula deve (re)nascer */
	public boolean shouldRevive(int i, int j, Model engine) {

		return (!engine.getCurrentGameState()[i][j].isAlive())
				&& (engine.numberOfNeighborhoodAliveCells(i, j) == 3);
		
	}

}
