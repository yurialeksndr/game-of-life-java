package br.unb.cic.lp.gol;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class GameViewGUI {
	
	public static void main(String[] args) {
        new GameViewGUI();
    }

    public GameViewGUI() {
        
    	JFrame frame = new JFrame("Testing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    frame.add(new CustomGrid());
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);        
        
    }

}
