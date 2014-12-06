package br.unb.cic.lp.gol;

/**
 * Essa implementacao utiliza o algoritmo Dia e Noite, ou seja:
 * 
 * revive com 3,6,7 ou 8 E mantem viva com 3,4,6,7 ou 8
 * 
 * Esse formato tambem e conhecido como B3678/S34678
 * 
 * @author Diego Azevedo
 *
 */
public class DayAndNightRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j) > 5 || engine.numberOfNeighborhoodAliveCells(i, j) ==3 || 
				engine.numberOfNeighborhoodAliveCells(i, j) == 4 );

	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) > 5 || engine.numberOfNeighborhoodAliveCells(i, j) ==3);
	
	}

}
