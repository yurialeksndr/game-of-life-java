package br.unb.cic.lp.gol;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class GameViewGUI {
	
	private GameEngine engine;
	private GameController controller;
	private CustomGrid grid;
	
	
//	public static void main(String[] args) {
//		
//        new GameViewGUI(null, null);
//        
//    }
	
	
	/**
	 * Construtor da classe GameViewGUI
	 */
    public GameViewGUI(GameController gameController, GameEngine gameEngine) {
        
    	this.controller = gameController;
    	this.engine = gameEngine;
    	
    	this.grid = new CustomGrid(this.controller, this.engine);
    	
    	JFrame frame = new JFrame("Testing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    frame.add(grid);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);

    }
    
    /**
	 * Metodo para atualizar a view.
	 */
	public void update() {
		
		this.grid.repaint();

	}
	
	
	/**
	 * Os metodos estao nesta classe (e nao no grid), porque
	 * se relacionam com os eventos dos botoes
	 */
	private void nextGeneration() {
		controller.nextGeneration();
	}
	
	private void halt() {
		controller.halt();
	}
    

}
