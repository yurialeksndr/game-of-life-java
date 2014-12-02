package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
		
		Rules rule = new MazeRules();
		
		GameController controller = new GameController();
		
		GameEngine engine = new GameEngine(50, 50, rule);
		
		GameViewGUI board = new GameViewGUI();
		board.setController(controller);
		board.setEngine(engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		
		controller.start();
		
	}
}