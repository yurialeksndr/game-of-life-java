package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
		
		System.out.println("testando commit em repositório remoto.");
		
		GameController controller = new GameController();
		
		Statistics statistics = new Statistics();
		
		GameEngine engine = new GameEngine(10, 10, statistics);	
		
		GameView board = new GameView(controller, engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);
		
		controller.start();
	}
}
