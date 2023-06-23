package game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;

import game.controls.board.*;
import game.controls.player.*;
import game.controls.*;

public class MainWindow extends JFrame{
	private GameCanvas myGC;
	private MainMenu myMenu;
	private int mode;
	private Game myGame;
	//private JMenuBar myMB;
	
	public MainWindow(Game g) {
		this.myGame = g;
		myGC = new GameCanvas(this.myGame);
		myMenu = new MainMenu(this);
		setLayout(new BorderLayout());
		mode = 1;
		
		add(myMenu, BorderLayout.CENTER);
		//add(pane, "Game");
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
	}
	
	public void newGame() {
		remove(myMenu);
		this.myGame.start();
		add(myGC, BorderLayout.CENTER);
		setVisible(true);
		this.mode = 1;
	}
	
	public void redraw() {
		this.myGC.repaint();
	}
	
	public int getMode() {
		return mode;
	}
}
