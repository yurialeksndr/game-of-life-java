package br.unb.cic.lp.gol.rules;

import br.unb.cic.lp.gol.model.Model;


/**
 * Essa implementacao utiliza o algoritmo Keep Growing, ou seja:
 * 
 * revive com 1,2,3,4,5,6,7 ou 8 e mantem viva com 1,2,3,4,5,6,7 ou 8
 * 
 * Esse formato tambem e conhecido como B12345678/S12345678
 * 
 * @author Diego Azevedo
 *
 */
public class KeepGrowingRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j) > 0);

	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
		
		return (engine.numberOfNeighborhoodAliveCells(i, j) > 0);
		
	}

}
