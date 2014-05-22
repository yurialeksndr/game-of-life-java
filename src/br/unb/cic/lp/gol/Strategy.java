package br.unb.cic.lp.gol;

/**
 * Abstrai a regra usada para verificar se uma 
 * celula deve ser mantida viva ou transitar de morta 
 * para viva. 
 * 
 * @author rbonifacio
 */
public interface Strategy {
	public boolean shouldKeepAlive(int i, int j);
	public boolean shouldRevive(int i, int j);
}
