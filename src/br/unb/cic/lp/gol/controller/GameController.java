package br.unb.cic.lp.gol.controller;

import java.security.InvalidParameterException;

/**
 * Classe que atua como um controlador do 
 * padrao MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 * @author rbonifacio
 */
public class GameController extends Controller {
	
	public void start() {
		
		getBoard().createScreen();
		getBoard().update();
		
	}
	
	public void makeCellAlive(int i, int j) {
		
		try {
			
			getEngine().makeCellAlive(i, j);
			getBoard().update();
			
		}
		
		catch(InvalidParameterException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public boolean isCellAlive(int i, int j) {
		
		return getEngine().isCellAlive(i, j);
		
	}
	
	public void nextGeneration() {
		
		try {
			
			getEngine().nextGeneration();
			getBoard().update();
			
		}
		
		catch (Exception e) {
			
			String message = "There's no cells alive!";
			getBoard().displayMessage(message);
			
		}
		
	}
	
	public void undo() {
		
		try {

			getEngine().undo();
			getBoard().update();

		}
		
		catch (Exception e) {
			
			String message = "No more possible returns!";
			getBoard().displayMessage(message);
			
		}	
		
	}
	
	public void halt() {
		
		int revivedCells = getEngine().getStatistics().getRevivedCells();
		int killedCells = getEngine().getStatistics().getKilledCells();
		
		String message = "Revived cells: " + revivedCells + "\nKilled cells: " + killedCells;
		
		getBoard().displayMessage(message);
		
	}	
	
}
