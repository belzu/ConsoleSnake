package application;

public class Gate extends GameObject {

	public Gate(char symbol) {
		setSymbol(symbol);
	}

	// Add food to random location inside the matrix limits
	public void addRandomGate(GameScreen screen, Gate gate) {
		int x = (int) (Math.random() * (screen.getScreenWidth() - 1));
		int y = (int) (Math.random() * (screen.getScreenHeight() - 1));
		while(screen.getObjectOnLocation(x, y) != '.') {
			x = (int) (Math.random() * (screen.getScreenWidth() - 1));
			y = (int) (Math.random() * (screen.getScreenHeight() - 1));
		}
		screen.setObjectOnLocation(gate, x,y);
	}

}
