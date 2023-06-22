package game.gui;

import game.controls.board.*;
import game.controls.*;
import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel{
	private BoardDrawer myBD;
	
	public GameCanvas(Board myBoard) {
		this.myBD = new BoardDrawer(myBoard, this);
	}
	public GameCanvas(Game myGame) {
		this.myBD = new BoardDrawer(myGame, this);
	}
	
	@Override
	public void paint(Graphics g) {
		this.myBD.setMyG(g);
		this.myBD.draw();
	}
	
}
