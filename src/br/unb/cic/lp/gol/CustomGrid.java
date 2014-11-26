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
	
	private int columnCount = 10;
    private int rowCount = 10;
    private List<Rectangle> cells;
    private Point hoverCell;
    private Point clickedCell;
    private static final long serialVersionUID = 1L;
    MouseAdapter mouseMovement;
    MouseListener mouseClick;

    
    public CustomGrid () {
    	
    	cells = new ArrayList<Rectangle>(columnCount * rowCount);
                
    	this.configureMouseListeners();
		
        this.addMouseMotionListener(mouseMovement);
		this.addMouseListener(mouseClick);
        
    }
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    @Override
    public void invalidate() {
        cells.clear();
        hoverCell = null;
        clickedCell = null;
        super.invalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;

        int xOffset = (width - (columnCount * cellWidth)) / 2;
        int yOffset = (height - (rowCount * cellHeight)) / 2;

        if (cells.isEmpty()) {
        	
            for (int row = 0; row < rowCount; row++) {
            	
                for (int col = 0; col < columnCount; col++) {
                	
                    Rectangle cell = new Rectangle(
                            xOffset + (col * cellWidth),
                            yOffset + (row * cellHeight),
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
        
        if (clickedCell != null) {

            int index = clickedCell.x + (clickedCell.y * columnCount);
            Rectangle cell = cells.get(index);
            g2d.setColor(Color.YELLOW);
            g2d.fill(cell);
            //clickedCell = null;

        }

        g2d.setColor(Color.GRAY);
        
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

                hoverCell = new Point(column, row);
                repaint();

            }
            
        };
        
        
        mouseClick = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("click identificado");
				
				int width = getWidth();
                int height = getHeight();
                
                int cellWidth = width / columnCount;
                int cellHeight = height / rowCount;

                int column = e.getX() / cellWidth;
                int row = e.getY() / cellHeight;

                clickedCell = new Point(column, row);
                repaint();
				
			}
		};
    }
    //fim configureMouseListeners
    
}