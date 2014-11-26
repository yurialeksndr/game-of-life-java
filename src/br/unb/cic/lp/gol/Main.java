package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
				
		GameController controller = new GameController();
		
		Statistics statistics = new Statistics();
		
		GameEngine engine = new GameEngine(10, 10, statistics);	
		
		GameViewGUI board = new GameViewGUI(controller, engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);
		
		controller.start();
	}
}
