package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
				
		GameController controller = new GameController();
		
		GameEngine engine = new GameEngine(25, 25);
		
		GameViewGUI board = new GameViewGUI();
		board.setController(controller);
		board.setEngine(engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		
		controller.start();
		
	}
}