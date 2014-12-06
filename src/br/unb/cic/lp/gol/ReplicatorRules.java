package br.unb.cic.lp.gol;

/**
 * Essa implementacao utiliza o algoritmo Replicator, ou seja:
 * 
 * revive com 1,3,5 ou 7 E mantem viva com 1,3,5 ou 7
 * 
 * Esse formato tambem e conhecido como B1357/S1357
 * 
 * @author Diego Azevedo
 *
 */
public class ReplicatorRules extends Rules {

	@Override
	public boolean shouldKeepAlive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j)%2 == 1);
		
	}

	@Override
	public boolean shouldRevive(int i, int j, Model engine) {

		return (engine.numberOfNeighborhoodAliveCells(i, j)%2 == 1);

	}

}
