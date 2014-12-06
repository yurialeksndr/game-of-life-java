package br.unb.cic.lp.gol;

public abstract class View {
	
	private Controller controller;
	
	public abstract void displayMessage (String message);
	public abstract void createScreen();
	public abstract void update();
	
	public Controller getController() {
		
		return controller;
		
	}
	
	public void setController(Controller controller) {
		
		this.controller = controller;
		
	}

}
