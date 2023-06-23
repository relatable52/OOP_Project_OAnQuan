package game;

import game.controls.Game;
import game.gui.MainWindow;

public class MainProgram {
	public static void main(String[] args) {
		Game myGame = new Game();
		myGame.start();
		MainWindow myWindow = new MainWindow(myGame);
		
		while(myWindow.getMode() == 1) {
			myWindow.redraw();
		}
	}
}
