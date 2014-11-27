package br.unb.cic.lp.gol;

public class Main {
	//TODO BOTÃO PLAY
	//TODO BOTÃO UNDO
	//TODO MELHORAS NO DESIGN
	//TODO MODOS INTERMEDIÁRIOS PARA AS CÉLULAS (EX: ZUMBI)
	public static void main(String args[]) {
				
		GameController controller = new GameController();
		
		GameEngine engine = new GameEngine(25, 25);	
		
		GameViewGUI board = new GameViewGUI(controller, engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		
		controller.start();
		
	}
}