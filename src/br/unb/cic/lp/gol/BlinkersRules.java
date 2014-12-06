package br.unb.cic.lp.gol;

/**
 * Essa implementacao utiliza o algoritmo Bacteria, ou seja:
 * 
 * revive com 3,4 ou 5 E mantem viva com 2
 * 
 * Esse formato tambem e conhecido como B345/S2
 * 
 * @author Diego Azevedo
 *
 */
public class BlinkersRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 2);
	
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j) > 2 && engine.numberOfNeighborhoodAliveCells(i, j) < 6);

	}

}
