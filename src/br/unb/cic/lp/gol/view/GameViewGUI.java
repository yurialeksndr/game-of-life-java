package br.unb.cic.lp.gol.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.unb.cic.lp.gol.rules.Rules;


public class GameViewGUI extends View {
	
	private CustomGrid grid;
	
	private JFrame frame;
	private JPanel mainPanel;
	private JButton nextGenerationButton;
	private JButton undoButton;
	private JButton haltButton;
	private JComboBox<String> rulesBox;
	
	private String[] chosenRules;
	
	/*
	 * Construtor da classe
	 */
	public GameViewGUI (String[] chosenRules) {
		
		this.chosenRules = chosenRules;
		
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
		
		getController().nextGeneration();
		
	}
	
	
	private void halt() {
		
		getController().halt();
		
	}
	
	
	private void undo() {
		
		getController().undo();
		
	}
	
	
    public void createScreen () {
    	
    	prepararJanela();
    	prepararBotaoNextGeneration();
    	prepararBotaoUndo();
    	prepararBoxRegras();
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
    
    
    private void prepararBoxRegras () {
    	
    	this.rulesBox = new JComboBox<String>(chosenRules);
    	this.rulesBox.setBounds(15, 57, 227, 27);
    	this.rulesBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String ruleName = chosenRules[rulesBox.getSelectedIndex()];
				try {
					
					Class<?> ruleClass = Class.forName("br.unb.cic.lp.gol.rules." + ruleName);
					Rules rule = (Rules) ruleClass.newInstance();
					getController().setRule(rule);
					
				} 
				
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} 
				
				catch (InstantiationException e1) {
					e1.printStackTrace();
				} 
				
				catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
    	
    	this.rulesBox.setSelectedIndex(0);
    	
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
    	
    	this.grid = new CustomGrid(getController());
    	grid.setBounds(0, 100, 500, 500);
    	
    }
    
    
    private void prepararPainelPrincipal () {
    	
    	this.mainPanel = new JPanel();
    	this.mainPanel.setLayout(null);
    	this.mainPanel.add(this.nextGenerationButton);
    	this.mainPanel.add(this.undoButton);
    	this.mainPanel.add(this.rulesBox);
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
