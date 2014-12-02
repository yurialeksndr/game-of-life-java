package br.unb.cic.lp.gol;

/**
 * 
 * @author rodrigobonifacio
 */
public class Statistics {
	private int revivedCells;
	private int killedCells;
	
	public Statistics() {
		
		revivedCells = 0;
		killedCells = 0;
		
	}

	public int getRevivedCells() {
		return revivedCells;
	}

	public void recordRevive() {
		this.revivedCells++;
	}
	
	public void setRevivedCells (int value) {	
		this.revivedCells = value;
	}
	
	public int getKilledCells() {
		return killedCells;
	}

	public void recordKill() {
		this.killedCells++;
	}
	
	public void setKilledCells (int value) {
		this.killedCells = value;
	}

}
