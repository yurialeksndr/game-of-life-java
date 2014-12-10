package br.unb.cic.lp.gol.rules;

import br.unb.cic.lp.gol.model.Model;


/**
 * Essa implementacao utiliza o algoritmo High Life, ou seja:
 * 
 * revive com 3 ou 6 e mantem viva com 2 ou 3
 * 
 * Esse formato tambem e conhecido como B36/S23
 * 
 * @author Diego Azevedo
 *
 */
public class HighLifeRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {
		
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 2 || engine.numberOfNeighborhoodAliveCells(i, j) == 3);
		
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
		
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 3 || engine.numberOfNeighborhoodAliveCells(i, j) == 6);
		
	}

}
