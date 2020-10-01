package application;

	public class Trap extends GameObject {

		public Trap(char symbol) {
			setSymbol(symbol);
		}

		// Add food to random location inside the matrix limits
		public void addRandomTrap(GameScreen screen, Trap trap, int num) {
			int cont = 0;
			for(int i = 0; i<screen.getScreenWidth();i++) {
				for(int j = 0; j<screen.getScreenHeight();j++) {
					if(screen.getObjectOnLocation(i, j)=='X') {
						if(cont >= num) screen.ClearScreenLocation(i, j);
						else cont++;
					}
				}				
			}
			int x = (int) (Math.random() * (screen.getScreenWidth() - 1));
			int y = (int) (Math.random() * (screen.getScreenHeight() - 1));
			while(screen.getObjectOnLocation(x, y) != '.') {
				x = (int) (Math.random() * (screen.getScreenWidth() - 1));
				y = (int) (Math.random() * (screen.getScreenHeight() - 1));
			}
			screen.setObjectOnLocation(trap,x,y);
		}
}
