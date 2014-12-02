package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Representa um ambiente (environment) do jogo GameOfLife.
 * Um ambiente eh representado como um array bidimensional de celulas, com
 * altura (height) e comprimento (width).
 * 
 * @author rbonifacio
 */
public class GameEngine extends Model {
	
	private int height;
	private int width;
	private Rules rule;
	private Stack<Cell[][]> gameHistory;
	private Stack<Statistics> statisticsHistory;
	
	/**
	 * Construtor da classe Environment.
	 * 
	 * @param height: dimensao vertical do ambiente
	 * @param width: dimensao horizontal do ambiente
	 */
	public GameEngine(int height, int width, Rules rule) {
		
		this.height = height;
		this.width = width;
		this.rule = rule;
		
		//Criando a pilha que irá armazenar o histórico
		this.gameHistory = new Stack<Cell[][]>();
		
		//Criando a pilha que irá armazenar o histórico de estatísticas
		this.statisticsHistory = new Stack<Statistics>();
		
		//Criando a primeira matriz (vazia)
		Cell[][] cells = new Cell[height][width];
		createCells(cells);
		this.gameHistory.push(cells);
		
		//Criando a primeira estatística (zerada)
		Statistics statistics = new Statistics();
		this.statisticsHistory.push(statistics);
		
	}

	/**
	 * Calcula uma nova geracao do ambiente. Essa implementacao utiliza o
	 * algoritmo do Conway, ou seja:
	 * 
	 * a) uma celula morta com exatamente tres celulas vizinhas vivas se torna
	 * uma celula viva.
	 * 
	 * b) uma celula viva com duas ou tres celulas vizinhas vivas permanece
	 * viva.
	 * 
	 * c) em todos os outros casos a celula morre ou continua morta.
	 */
	public void nextGeneration() throws Exception {
		
		if (numberOfAliveCells() > 0) {
		
			List<Cell> mustRevive = new ArrayList<Cell>();
			List<Cell> mustKill = new ArrayList<Cell>();
			
			Cell[][] cells = new Cell[height][width];
			createCells(cells);
			copyCellsFromTo(gameHistory.peek(), cells);
			
			Statistics statistics = new Statistics();
							
			for (int i = 0; i < height; i++) {
				
				for (int j = 0; j < width; j++) {
					
					if (rule.shouldRevive(i, j, this)) {
						
						mustRevive.add(cells[i][j]);
					} 
					
					else if ((!rule.shouldKeepAlive(i, j, this)) && cells[i][j].isAlive()) {
						
						mustKill.add(cells[i][j]);
					}
				}
			}
			
			for (Cell cell : mustRevive) {
				
				cell.revive();
				statistics.recordRevive();

			}
			
			for (Cell cell : mustKill) {
				
				cell.kill();
				statistics.recordKill();

			}
			
			gameHistory.push(cells);
			
			calculateStatisticsHistory(statistics);
			statisticsHistory.push(statistics);
			
		}
		
		else {
			
			throw new Exception("No more cells alive.");
			
		}
	}
	
	/*
	 * Método para reverter o jogo para estados anteriores.
	 * Caso não seja possível executar o retorno, uma exceção é lançada para a controller.
	 */
	public void undo() throws Exception {
		
		if (gameHistory.size() > 1) {
		
			gameHistory.pop();
			statisticsHistory.pop();
						
		}
		
		else {
			
			throw new Exception("No more possible undos.");
			
		}
	}
	
	/**
	 * Torna a celula de posicao (i, j) viva
	 * 
	 * @param i posicao vertical da celula
	 * @param j posicao horizontal da celula
	 * 
	 * @throws InvalidParameterException caso a posicao (i, j) nao seja valida.
	 */
	public void makeCellAlive(int i, int j) throws InvalidParameterException {
		
		Cell[][] cells = new Cell[height][width];
		createCells(cells);
		copyCellsFromTo(gameHistory.peek(), cells);
		
		Statistics statistics = new Statistics();
		
		if(validPosition(i, j)) {

			cells[i][j].revive();
			statistics.recordRevive();

			gameHistory.push(cells);
			
			calculateStatisticsHistory(statistics);
			statisticsHistory.push(statistics);
			
		}
		
		else {
			
			new InvalidParameterException("Invalid position (" + i + ", " + j + ")" );
			
		}
		
	}
	
	
	/**
	 * Verifica se uma celula na posicao (i, j) estah viva.
	 * 
	 * @param i Posicao vertical da celula
	 * @param j Posicao horizontal da celula
	 * @return Verdadeiro caso a celula de posicao (i,j) esteja viva.
	 * 
	 * @throws InvalidParameterException caso a posicao (i,j) nao seja valida. 
	 */
	public boolean isCellAlive(int i, int j) throws InvalidParameterException {
		
		if(validPosition(i, j)) {
			
			return gameHistory.peek()[i][j].isAlive();			
		}
		
		else {
			
			throw new InvalidParameterException("Invalid position (" + i + ", " + j + ")" );
		}
	}
	

	/**
	 * Retorna o numero de celulas vivas no ambiente. 
	 * Esse metodo eh particularmente util para o calculo de 
	 * estatisticas e para melhorar a testabilidade.
	 * 
	 * @return  numero de celulas vivas.
	 */
	public int numberOfAliveCells() {

		int aliveCells = 0;
		
		for(int i = 0; i < height; i++) {
			
			for(int j = 0; j < width; j++) {
				
				if(isCellAlive(i,j)) {
					
					aliveCells++;
					
				}
			}
		}
		
		return aliveCells;
	}
	

	/*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
	 * de referencia identificada pelos argumentos (i,j).
	 */
	public int numberOfNeighborhoodAliveCells(int i, int j) {

		int alive = 0;
		
		for (int a = i - 1; a <= i + 1; a++) {
			
			for (int b = j - 1; b <= j + 1; b++) {
				
				int tempA = setInfiniteGridForRow(a);
				int tempB = setInfiniteGridForColumn(b);
				
				if (validPosition(tempA, tempB)  && (!(tempA == i && tempB == j)) && gameHistory.peek()[tempA][tempB].isAlive()) {
					
					alive++;
					
				}
			}
		}
		
		return alive;
	}
	
	
	/*
	 * O metodo abaixo recalcula (se necessario) a vizinhanca de uma celula
	 * para viabilizar o grid infinito
	 */
	private int setInfiniteGridForRow (int a) {
		
		if (a == -1) {			
			a = this.height - 1;
		}
		
		else if (a == this.height) {			
			a = 0;
		}
		
		return a;
		
	}
	
	private int setInfiniteGridForColumn (int b) {
		
		if (b == -1) {			
			b = this.width - 1;
		}
		
		else if (b == this.width) {			
			b = 0;
		}
		
		return b;
		
	}
	

	/*
	 * Verifica se uma posicao (a, b) referencia uma celula valida no tabuleiro.
	 */
	private boolean validPosition(int a, int b) {
		
		return a >= 0 && a < height && b >= 0 && b < width;
		
	}
	

	/* Metodos de acesso as propriedades height e width */
	
	public int getHeight() {
		return height;
	}

	//public void setHeight(int height) {
		//this.height = height;
	//}

	public int getWidth() {
		return width;
	}

	//public void setWidth(int width) {
		//this.width = width;
	//}
	
	
	/*
	 * Método para consultar o topo da pilha de estatisticas
	 */
	public Statistics getStatistics () {
		
		return this.statisticsHistory.peek();
		
	}
	
	
	/*
	 * Método para consultar o topo da pilha de células do jogo
	 */
	public Cell[][] getCurrentGameState () {
		
		return this.gameHistory.peek();
		
	}
	
	
	/*
	 * Método para alocar as células da matriz passada
	 */
	private void createCells (Cell[][] cells) {
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
			
				cells[i][j] = new Cell();
			}
		}
	}
	
	
	/*
	 * Método para copiar as células de uma matriz para outra
	 */
	private void copyCellsFromTo (Cell[][] topOfStack, Cell[][] cells) {
		
		for (int i = 0; i < height; i++) {
			
			for (int j = 0; j < width; j++) {
				
				Boolean cellStatus = topOfStack[i][j].isAlive();
				
				if (cellStatus) {
					
					cells[i][j].revive(); 
					
				}
				
				else {
					
					cells[i][j].kill();
					
				}
			}
		}
	}
	
	/*
	 * Método para calcular as estatísticas a serem inseridas no histórico
	 */
	private void calculateStatisticsHistory (Statistics statistics) {
		
		statistics.setRevivedCells(statistics.getRevivedCells() + statisticsHistory.peek().getRevivedCells());
		statistics.setKilledCells(statistics.getKilledCells() + statisticsHistory.peek().getKilledCells());
		
	}
	
}
