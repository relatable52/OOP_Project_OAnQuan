package game.gui;

import game.controls.board.*;
import game.controls.*;
import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel{
	private BoardDrawer myBD;
	private PlayerDrawer myPD;
	
	public GameCanvas(Board myBoard) {
		this.myBD = new BoardDrawer(myBoard, this);
	}
	public GameCanvas(Game myGame) {
		this.myBD = new BoardDrawer(myGame, this);
		this.myPD = new PlayerDrawer(myGame, this);
	}
	
	@Override
	public void paint(Graphics g) {
		this.myBD.setMyG(g);
		this.myPD.setMyG(g);
		
		this.myBD.draw();
		this.myPD.draw();
	}
}
