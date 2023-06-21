package game.gui;

import game.controls.board.*;
import java.awt.*;
import javax.swing.*;

public class GameCanvas extends JPanel{
	private BoardDrawer myBD;
	
	public GameCanvas(Board myBoard) {
		this.myBD = new BoardDrawer(myBoard, this);
	}
	
	@Override
	public void paint(Graphics g) {
		this.myBD.setMyG(g);
		this.myBD.draw();
	}
	
}
