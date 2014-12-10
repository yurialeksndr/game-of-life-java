package br.unb.cic.lp.gol.rules;

import br.unb.cic.lp.gol.model.Model;


/**
 * Essa implementacao utiliza o algoritmo LandRush, ou seja:
 * 
 * revive com 3 ou 6 e mantem viva com 2,3,4,5,6,7 ou 8
 * 
 * Esse formato tambem e conhecido como B36/S234578
 * 
 * @author Diego Azevedo
 *
 */
public class LandRushRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j) > 1 );

	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
		
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 3 || engine.numberOfNeighborhoodAliveCells(i, j) == 6);
		
	}

}
