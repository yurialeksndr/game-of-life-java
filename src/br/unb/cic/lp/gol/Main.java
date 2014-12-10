package br.unb.cic.lp.gol;

import br.unb.cic.lp.gol.controller.GameController;
import br.unb.cic.lp.gol.model.GameEngine;
import br.unb.cic.lp.gol.view.GameViewGUI;

public class Main {

	public static void main(String args[]) {
		
		String[] chosenRules = { "ConwayRules", "MazeRules", "CoagulationsRules", "BlinkersRules", 
				"AssimilationRules", "CoralRules", "HolsteinRules", "DayAndNightRules", "ReplicatorRules",
				"LandRushRules", "HighLifeRules"};
		
		GameController controller = new GameController();
		
		GameEngine engine = new GameEngine(25, 25);
		
		GameViewGUI board = new GameViewGUI(chosenRules);
		
		board.setController(controller);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		
		controller.start();
		
	}
	
}