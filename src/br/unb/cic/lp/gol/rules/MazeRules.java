package br.unb.cic.lp.gol.rules;

import br.unb.cic.lp.gol.model.Model;


public class MazeRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {
				
			return (engine.getCurrentGameState()[i][j].isAlive())
					&& (engine.numberOfNeighborhoodAliveCells(i, j) == 1 || engine.numberOfNeighborhoodAliveCells(i, j) == 2 || 
					engine.numberOfNeighborhoodAliveCells(i, j) == 3 || engine.numberOfNeighborhoodAliveCells(i, j) == 4 || 
					engine.numberOfNeighborhoodAliveCells(i, j) == 5);
		
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
		
		return (!engine.getCurrentGameState()[i][j].isAlive())
				&& (engine.numberOfNeighborhoodAliveCells(i, j) == 3);
		
	}

}
