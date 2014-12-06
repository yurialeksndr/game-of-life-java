package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
		
		String[] chosenRules = { "ConwayRules", "MazeRules" };
		
		GameController controller = new GameController();
		
		GameEngine engine = new GameEngine(25, 25);
		
		GameViewGUI board = new GameViewGUI(chosenRules);
		
		board.setController(controller);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		
		controller.start();
		
	}
	
}