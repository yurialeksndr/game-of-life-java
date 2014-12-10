package br.unb.cic.lp.gol.rules;

import br.unb.cic.lp.gol.model.Model;


/**
 * Essa implementacao utiliza o algoritmo Assimilation, ou seja:
 * 
 * revive com 3,4 ou 5 E mantem viva com 4,5,6 ou 7
 * 
 * Esse formato tambem e conhecido como B345/S4567
 * 
 * @author Diego Azevedo
 *
 */
public class AssimilationRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) > 3 && engine.numberOfNeighborhoodAliveCells(i, j) < 8);
		
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) > 2 && engine.numberOfNeighborhoodAliveCells(i, j) < 6);
		
	}

}
