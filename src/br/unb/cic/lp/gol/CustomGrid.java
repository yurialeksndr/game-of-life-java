package br.unb.cic.lp.gol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class CustomGrid extends JPanel {
	
	private static final int GRID_DIMENSION = 500;
	
	private Model engine;
	private Controller controller;
	
	private int columnCount;
    private int rowCount;
    private List<Rectangle> cells;
    private Point hoverCell;
    private static final long serialVersionUID = 1L;
    MouseAdapter mouseMovement;
    MouseListener mouseClick;

    
    public CustomGrid (Controller gameController, Model gameEngine) {
    	
    	this.engine = gameEngine;
    	this.controller = gameController;
    	
    	columnCount = engine.getWidth();
    	rowCount = engine.getHeight();

    	cells = new ArrayList<Rectangle>(columnCount * rowCount);
                
    	this.configureMouseListeners();
        this.addMouseMotionListener(mouseMovement);
		this.addMouseListener(mouseClick);
        
    }
    
    @Override
    public Dimension getPreferredSize() {
    	
        return new Dimension(GRID_DIMENSION, GRID_DIMENSION);
        
    }

    @Override
    public void invalidate() {
    	
        cells.clear();
        hoverCell = null;
        super.invalidate();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        int cellWidth = (int) width / columnCount;
        int cellHeight = (int) height / rowCount;

        //int xOffset = (width - (columnCount * cellWidth)) / 2;
        //int yOffset = (height - (rowCount * cellHeight)) / 2;
        
        int xOffset = 0;
        int yOffset = 0;

        if (cells.isEmpty()) {
        	
            for (int row = 0; row < rowCount; row++) {
            	
                for (int col = 0; col < columnCount; col++) {
                	
                    Rectangle cell = new Rectangle(
                            xOffset + (row * cellHeight),
                            yOffset + (col * cellWidth),
                            cellWidth,
                            cellHeight);
                    
                    cells.add(cell);
                    
                }
            }
        }

        if (hoverCell != null) {

            int index = hoverCell.x + (hoverCell.y * columnCount);

            Rectangle cell = cells.get(index);
            g2d.setColor(Color.DARK_GRAY);
            g2d.fill(cell);

        }
        
        for (int row = 0; row < rowCount; row++) {
		
			for (int column = 0; column < columnCount; column++) {
			
				int index = row + (column * columnCount);
				Rectangle cell = cells.get(index);
				
				if (engine.isCellAlive(row, column)) {
	
					g2d.setColor(Color.ORANGE);
					g2d.fill(cell);
					
				}
				
			}
		}

        g2d.setColor(Color.BLACK);

        for (Rectangle cell : cells) {

        	g2d.draw(cell);
        	
        }

        g2d.dispose();
        
    }
    
    
    //configureMouseListeners
    private void configureMouseListeners () {
    	
        mouseMovement = new MouseAdapter() {
        	
            @Override
            public void mouseMoved(MouseEvent e) {
                
            	//Point point = e.getPoint();

                int width = getWidth();
                int height = getHeight();
                
                int cellWidth = width / columnCount;
                int cellHeight = height / rowCount;

                int column = e.getX() / cellWidth;
                int row = e.getY() / cellHeight;

                hoverCell = new Point(row, column);
                repaint();

            }
            
        };
        
        
        mouseClick = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int width = getWidth();
                int height = getHeight();
                
                int cellWidth = width / columnCount;
                int cellHeight = height / rowCount;

                int column = e.getX() / cellWidth;
                int row = e.getY() / cellHeight;
                
                controller.makeCellAlive(row, column);

                repaint();
				
			}
		};
    }
    //fim configureMouseListeners
    
}