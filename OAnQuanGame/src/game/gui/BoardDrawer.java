package game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

import game.controls.board.*;

public class BoardDrawer extends JPanel {
	private Board myBoard;
	private int cellSize = 100;
	private int danRadius = 5;
	private int quanRadius = 15;
	
	public BoardDrawer(Board myBoard) {
		this.myBoard = myBoard;
	}
	
	public BoardDrawer(Board myBoard, int size, int dan, int quan) {
		this.myBoard = myBoard;
		this.cellSize = size;
		this.danRadius = dan;
		this.quanRadius = quan;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		drawBoardLines(graphic2d);
		drawStones(graphic2d);
	}
	
	private void drawBoardLines(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(5));
		for(int i = 0; i<10; i++) {
			int x = getWidth()/2 - (5*this.cellSize)/2 + (i%5)*this.cellSize;
			int y = getHeight()/2 - this.cellSize + (i/5)*this.cellSize;
			g.drawRect(x, y, this.cellSize, this.cellSize);
		}
		g.drawArc((getWidth()/2-(7*this.cellSize)/2), (getHeight()/2-this.cellSize), 2*this.cellSize, 2*this.cellSize, 90, 180);
		g.drawArc((getWidth()/2+(3*this.cellSize)/2), (getHeight()/2-this.cellSize), 2*this.cellSize, 2*this.cellSize, -90, 180);
	}
	
	private void drawStones(Graphics2D g) {
		BoardCell[] cells = this.myBoard.getCells();
		for(int i = 0; i<12; i++) {
			if(!cells[i].isOQuan()) {
				int ord = (i<5)?i:(i-1);
				drawInDan(g, ord, cells[i].getNumberOfStones());
			}
		}
	}
	
	private void drawInDan(Graphics2D g, int ord, int num) {
		int side = (int)Math.ceil(Math.sqrt(num));
		int d = (int)(this.cellSize*0.9/(side+1));
		int centerX = getWidth()/2 - 2*this.cellSize + (ord%5)*this.cellSize;
		int centerY = getHeight()/2 - this.cellSize/2 + (ord/5)*this.cellSize;
		//g.drawOval(centerX-d/2, centerY-d/2, d, d);
		for(int i=0; i<num; i++) {
			g.drawOval((int)(centerX + ((i%side)-(side*0.5-0.5))*d) - this.danRadius/2, (int)(centerY - ((i/side)-(side*0.5-0.5))*d) - this.danRadius/2, this.danRadius, this.danRadius);
		}
	}
}
