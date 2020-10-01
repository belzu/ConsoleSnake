package application;
import java.io.IOException;
import java.util.Scanner;
import java.io.Console;
public class Main {
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cmd cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    	System.out.println(e);
	    }
	}
	public static void main(String[] args) throws InterruptedException{

		// Constants
		final int SCREEN_WIDTH = 20; // Columns
		final int SCREEN_HEIGHT = 10; // Rows
		final int SNAKE_STARTING_X = SCREEN_WIDTH / 2;
		final int SNAKE_STARTING_Y = SCREEN_HEIGHT / 2;

		// Init screen
		GameScreen screen = new GameScreen(SCREEN_WIDTH, SCREEN_HEIGHT);
		screen.InitScreen();

		// Init walls
		Wall wall = new Wall('#');
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last
																		// row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last
																		// column

		// Init player
		SnakeBody snake = new SnakeBody(SNAKE_STARTING_X, SNAKE_STARTING_Y, screen);
		Snake snakeHead = snake.getSnakeHead();
//		snake.increaseSnake(screen);
		screen.setObjectOnLocation(snakeHead, snakeHead.getX(), snakeHead.getY());

		// Init food
		Food food = new Food('*');
		food.addRandomFood(screen, food);
		
		//Init trap
		int num = 0;
		Trap trap = new Trap('X');
		trap.addRandomTrap(screen, trap,num);
		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;
		int cont = 0;
		int moves = 0;
		char lastChar = ' ';
		Gate gate = new Gate('&');
		// The game logic starts here
		boolean isRunning = true;
		while (isRunning) {
//			screen.clearConsole();
			screen.PrintScreen();
			System.out.println();
			for(int l= 0; l<6;l++){
			System.out.print(" ");
			}			
			System.out.print("LEVEL ->  " +(num+1) + "	|	"+ cont +  "	|	"+ moves + " moves" );
			System.out.print("\n");
//			System.out.println(cont);
//			System.out.println(moves + " moves");
			input = lastChar;
			try {
				input = scanner.nextLine().charAt(0);
			}
			catch (Exception e) {
				System.out.println(input);
			    // sum = 0. If you needed to do anything else for invalid input
			    // put it here.
			}
			switch (input) {
			case 'a':
				lastChar='a';
				if(screen.getObjectOnLocation(snakeHead.getX()-1, snakeHead.getY())=='X' || 
						screen.getObjectOnLocation(snakeHead.getX()-1, snakeHead.getY())=='O') {
					System.out.println("GAME OVER");
					System.out.println("Final punctuation: " + cont);
					System.out.println("Reached level: " +(num+1));
					System.exit(0);
				}
				if(screen.getObjectOnLocation(snakeHead.getX()-1, snakeHead.getY())=='*') {
					food.addRandomFood(screen, food);
					snake.increaseSnake(screen);
					cont++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX()-1, snakeHead.getY()) =='&') {
					snake.minimizeSnake();
					screen.ClearScreen();
					food.addRandomFood(screen, food);
					snake.setX(SNAKE_STARTING_X);
					snake.setY(SNAKE_STARTING_Y);
					num++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX()-1, snakeHead.getY())!='#')
				try {
					snake.moveBodyLeft(screen);
				}
				catch(Exception e) {
					System.err.println("Error");
				}
					
				break;
			case 'd':
				lastChar='d';
				if(screen.getObjectOnLocation(snakeHead.getX()+1, snakeHead.getY())=='X'|| 
						screen.getObjectOnLocation(snakeHead.getX()+1, snakeHead.getY())=='O') {
					System.out.println("GAME OVER");
					System.out.println("Final punctuation: " + (cont+1));
					System.out.println("Reached level: " +(num+1));
					System.exit(0);
				}
	
				if(screen.getObjectOnLocation(snakeHead.getX()+1, snakeHead.getY())=='*') {
					food.addRandomFood(screen, food);
					snake.increaseSnake(screen);
					cont++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX()+1, snakeHead.getY()) =='&') {
					snake.minimizeSnake();
					screen.ClearScreen();
					food.addRandomFood(screen, food);
					snake.setX(SNAKE_STARTING_X);
					snake.setY(SNAKE_STARTING_Y);
					num++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX()+1, snakeHead.getY())!='#')
				try {
					snake.moveBodyRight(screen);
				}
				catch(Exception e) {
					System.err.println("Error");
				}
				break;
			case 'w':
				lastChar='w';
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()-1)=='X'|| 
						screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()-1)=='O') {
					System.out.println("GAME OVER");
					System.out.println("Final punctuation: " + cont);
					System.out.println("Reached level: " +(num+1));
					System.exit(0);
				}
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()-1)=='*') {
					food.addRandomFood(screen, food);
					snake.increaseSnake(screen);
					cont++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()-1) =='&') {
					snake.minimizeSnake();
					screen.ClearScreen();
					food.addRandomFood(screen, food);
					snake.setX(SNAKE_STARTING_X);
					snake.setY(SNAKE_STARTING_Y);
					num++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()-1)!='#')
				try {
					snake.moveBodyUp(screen);
				}
				catch(Exception e) {
					System.err.println("Error");
				}
				break;
			case 's':
				lastChar='s';
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()+1)=='X'|| 
						screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()+1)=='O') {
					System.out.println("GAME OVER");
					System.out.println("Final punctuation: " + cont);
					System.out.println("Reached level: " +(num+1));
					System.exit(0);
				}
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()+1)=='*') {
					food.addRandomFood(screen, food);
					snake.increaseSnake(screen);
					cont++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()+1) =='&') {
					snake.minimizeSnake();
					screen.ClearScreen();
					food.addRandomFood(screen, food);
					snake.setX(SNAKE_STARTING_X);
					snake.setY(SNAKE_STARTING_Y);
					num++;
				}
				if(screen.getObjectOnLocation(snakeHead.getX(), snakeHead.getY()+1) !='#')
				try {
					snake.moveBodyDown(screen);
				}
				catch(Exception e) {
					System.err.println("Error");
				}
				break;
			}
			if(moves % 100==0) food.addRandomFood(screen, food);
			if(moves % 2==0) trap.addRandomTrap(screen, trap,num);
			moves++;
			for (int i = 0; i < 100; ++i) System.out.println();
//			clearConsole();
			
			if(cont % 15 == 0 && cont != 0) {
				gate.addRandomGate(screen, gate);
				cont++;
			}
		}
		
	}

}
