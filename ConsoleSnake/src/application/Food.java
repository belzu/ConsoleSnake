package application;

public class Food extends GameObject {

	public Food(char symbol) {
		setSymbol(symbol);
	}

	// Add food to random location inside the matrix limits
	public void addRandomFood(GameScreen screen, Food food) {
		int x = (int) (Math.random() * (screen.getScreenWidth() - 1));
		int y = (int) (Math.random() * (screen.getScreenHeight() - 1));
		while(screen.getObjectOnLocation(x, y) != '.') {
			x = (int) (Math.random() * (screen.getScreenWidth() - 1));
			y = (int) (Math.random() * (screen.getScreenHeight() - 1));
		}
		screen.setObjectOnLocation(food, x,y);
	}
}
