package br.unb.cic.lp.gol;

/**
 * Essa implementacao utiliza o algoritmo Holstein, ou seja:
 * 
 * revive com 3,5,6,7 ou 8 e mantem viva com 4,6,7 ou 8
 * 
 * Esse formato tambem e conhecido como B35678/S4678
 * 
 * @author Diego Azevedo
 *
 */
public class HolsteinRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {
	
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 4 || engine.numberOfNeighborhoodAliveCells(i, j) > 5);
		
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {
		
		return (engine.numberOfNeighborhoodAliveCells(i, j) == 3 || engine.numberOfNeighborhoodAliveCells(i, j) > 4);
		
	}

}
