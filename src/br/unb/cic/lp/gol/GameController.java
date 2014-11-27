package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;

/**
 * Classe que atua como um controlador do 
 * padrao MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 * @author rbonifacio
 */
public class GameController {

	private GameEngine engine;
	private GameViewGUI board;
	
	public GameEngine getEngine() {
		
		return engine;
		
	}
	
	public void setEngine(GameEngine engine) {
		
		this.engine = engine;
		
	}
	
	public GameViewGUI getBoard() {
		
		return board;
		
	}
	
	public void setBoard(GameViewGUI board) {
		
		this.board = board;
		
	}
	
	public void start() {
		
		board.update();
		
	}
	
	public void halt() {
		
		int revivedCells = engine.getStatistics().getRevivedCells();
		int killedCells = engine.getStatistics().getKilledCells();
		
		String message = "Revived cells: " + revivedCells + "\nKilled cells: " + killedCells;
		
		board.showStatistics(message);
		
	}
	
	public void makeCellAlive(int i, int j) {
		
		try {
			
			engine.makeCellAlive(i, j);
			board.update();
			
		}
		
		catch(InvalidParameterException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void nextGeneration() {
		
		engine.nextGeneration();
		board.update();
		
	}
	
}
