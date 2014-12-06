package br.unb.cic.lp.gol;

/**
 * Essa implementacao utiliza o algoritmo Coagulations, ou seja:
 * 
 * revive com 3,7 ou 8 E mantem viva com 2,3,5,6,7 ou 8
 * 
 * Esse formato tambem e conhecido como B378/S235678
 * 
 * @author Diego Azevedo
 *
 */
public class CoagulationsRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j) != 1 && engine.numberOfNeighborhoodAliveCells(i, j) != 4);
	
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j) == 3 || engine.numberOfNeighborhoodAliveCells(i, j) == 7 || 
				engine.numberOfNeighborhoodAliveCells(i, j) == 8 );

	}

}
