package application;

import No_use.Screen;

public class GameScreen {
	Screen pantalla;
	private int width, height;
	private char[][] screenMatrix;

	public GameScreen(int width, int height) {
		this.width = width;
		this.height = height;
		this.screenMatrix = new char[this.height][this.width];
		pantalla = new Screen();
	}

	// Fill array with dots
	public void InitScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.screenMatrix[i][j] = '.';
			}
		}
	}

	// Print the screen to console
	public void PrintScreen() {
		
		for(int l= 0; l<18;l++){
		System.out.print(" ");
		}
		System.out.print(" C O N S O L E	S N A K E 	by: Ignacio Belzunegui(most)");
		System.out.println();
		System.out.println();
		for (int i = 0; i < this.height; i++) {
			/* Situa la distancia a la que esta situado el tablero del extremo de la pantalla */
			for(int l= 0; l<23;l++){
			System.out.print(" ");
			}
			for (int j = 0; j < this.width; j++) {
//				pantalla.textArea.setText(pantalla.textArea.getText() + this.screenMatrix[i][j]);				
				System.out.print(this.screenMatrix[i][j]);
			}
			System.out.println();
		}
	}

	//Screen clear location
	public void ClearScreenLocation(int x, int y) {
		this.screenMatrix[y][x] = '.';
	}

	// Getters
	public int getScreenWidth() {
		return this.width;
	}

	public int getScreenHeight() {
		return this.height;
	}

	public char getObjectOnLocation(int x, int y) {
		return this.screenMatrix[y][x];
	}

	// Setters
	public void setObjectOnLocation(GameObject object, int x, int y) {
		this.screenMatrix[y][x] = object.getSymbol();
	}
	
	public void ClearScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if(this.screenMatrix[i][j]!='#' &&this.screenMatrix[i][j]!='@' && this.screenMatrix[i][j]!='o')
					this.screenMatrix[i][j] = '.';
			}
		}
	}
	

	
}
