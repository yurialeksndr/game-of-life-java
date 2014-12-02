package br.unb.cic.lp.gol;

public abstract class Rules {
	
	public abstract boolean shouldKeepAlive(int i, int j, Model engine);
	public abstract boolean shouldRevive(int i, int j, Model engine);
	
}
