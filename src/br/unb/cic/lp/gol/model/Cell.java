package br.unb.cic.lp.gol.model;

public class Cell {
	
	private boolean alive = false;

	
	public boolean isAlive() {
		
		return alive;
	
	}

	public void kill() {
	
		this.alive = false;
	
	}
	
	public void revive() {
		
		this.alive = true;
	
	}
}
