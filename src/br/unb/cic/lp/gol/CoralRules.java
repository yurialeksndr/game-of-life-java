package br.unb.cic.lp.gol;

/**
 * Essa implementacao utiliza o algoritmo Coral, ou seja:
 * 
 * revive com 3 e mantem viva com 4,5,6,7 ou 8
 * 
 * Esse formato tambem e conhecido como B3/S45678
 * 
 * @author Diego Azevedo
 *
 */
public class CoralRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) > 3);
	
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 3);
		
	}

}
