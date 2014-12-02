package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;

/**
 * Classe que atua como um controlador do 
 * padrao MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 * @author rbonifacio
 */
public class GameController extends Controller {

	private Model engine;
	private View board;
	
	public Model getEngine() {
		
		return engine;
		
	}
	
	public void setEngine(Model engine) {
		
		this.engine = engine;
		
	}
	
	public View getBoard() {
		
		return board;
		
	}
	
	public void setBoard(View board) {
		
		this.board = board;
		
	}
	
	public void start() {
		
		board.update();
		
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
		
		try {
			
			engine.nextGeneration();
			board.update();
			
		}
		
		catch (Exception e) {
			
			String message = "There's no cells alive!";
			board.displayMessage(message);
			
		}
	}
	
	public void undo() {
		
		try {

			engine.undo();
			board.update();

		}
		
		catch (Exception e) {
			
			String message = "No more possible returns!";
			board.displayMessage(message);
			
		}	
	}
	
	public void halt() {
		
		int revivedCells = engine.getStatistics().getRevivedCells();
		int killedCells = engine.getStatistics().getKilledCells();
		
		String message = "Revived cells: " + revivedCells + "\nKilled cells: " + killedCells;
		
		board.displayMessage(message);
		
	}
	
}
