package br.unb.cic.lp.gol;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GameViewGUI extends View {
	
	private Model engine;
	private Controller controller;
	private CustomGrid grid;
	
	private JFrame frame;
	private JPanel mainPanel;
	private JButton nextGenerationButton;
	private JButton undoButton;
	private JButton haltButton;
	
	
	/**
	 * Construtor da classe GameViewGUI
	 */
    public GameViewGUI(Controller gameController, Model gameEngine) {
        
    	this.controller = gameController;
    	this.engine = gameEngine;
    	
    	this.montarTela();
    	
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
	
	private void undo() {
		
		controller.undo();
		
	}
	
    private void montarTela () {
    	
    	prepararJanela();
    	prepararBotaoNextGeneration();
    	prepararBotaoUndo();
    	prepararBotaoHalt();
    	prepararGrid();
    	prepararPainelPrincipal();
    	mostrarJanela();
    	
    }
    
    private void prepararJanela () {
    	
    	this.frame = new JFrame("Game of Life - POO 2014.2");
    	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.frame.setLayout(new BorderLayout());
	    
    }
    
    private void prepararBotaoNextGeneration () {
    	
    	this.nextGenerationButton = new JButton("Next Generation");
    	this.nextGenerationButton.setBounds(15, 15, 227, 27);
    	this.nextGenerationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				nextGeneration();
				
			}
		});	  
    }
    
    private void prepararBotaoUndo () {
    	
    	this.undoButton = new JButton("Undo");
    	this.undoButton.setBounds(257, 15, 227, 27);
    	this.undoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				undo();
				
			}
		});
    }
    
    private void prepararBotaoHalt () {
    	
    	this.haltButton = new JButton("Halt");
    	this.haltButton.setBounds(257, 57, 227, 27);
    	this.haltButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				halt();
				
			}
		});	
    }
    
    private void prepararGrid () {
    	
    	this.grid = new CustomGrid(this.controller, this.engine);
    	grid.setBounds(0, 100, 500, 500);
    	
    }
    
    private void prepararPainelPrincipal () {
    	
    	this.mainPanel = new JPanel();
    	this.mainPanel.setLayout(null);
    	this.mainPanel.add(this.nextGenerationButton);
    	this.mainPanel.add(this.undoButton);
    	this.mainPanel.add(this.haltButton);
    	this.mainPanel.add(this.grid);
       	
    }
    
    private void mostrarJanela () {
    	
    	this.frame.add(mainPanel);
    	this.frame.setSize(500, 600);
    	this.frame.setLocationRelativeTo(null);
	    this.frame.setVisible(true);
    	
    }
    
    /*
     * Método para mostrar uma mensagem em nova janela,
     * de acordo com o texto enviado.
     */
    public void displayMessage (String message) {
    	
    	JOptionPane.showMessageDialog(null, message);
    	
    }
 
}
