package br.unb.cic.lp.gol.controller;

import br.unb.cic.lp.gol.model.Model;
import br.unb.cic.lp.gol.rules.Rules;
import br.unb.cic.lp.gol.view.View;


public abstract class Controller {
	
	private Model engine;
	private View board;
	
	public abstract void start();
	public abstract void makeCellAlive(int i, int j);
	public abstract boolean isCellAlive(int i, int j);
	public abstract void nextGeneration();
	public abstract void undo();
	public abstract void halt();

	public Model getEngine() {
		
		return engine;
		
	}
	
	public void setEngine(Model engine) {
		
		this.engine = engine;
		
	}
	
	
	public View getBoard() {
		
		return board;
		
	}
	
	public void setBoard(View board) {
		
		this.board = board;
		
	}
	
	
	public void setRule(Rules rule) {
		
		this.engine.setRule(rule);
	
	}
	
	public Rules getRule() {
		
		return this.engine.getRule();
		
	}	
	
	
	public int getHeight() {
	
		return engine.getHeight();
	
	}

	public int getWidth() {
		
		return engine.getWidth();
	
	}
	
}
