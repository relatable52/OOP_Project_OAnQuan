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
	private HelpPage myHelp;
	private int mode;
	private Game myGame;
	//private JMenuBar myMB;
	
	public MainWindow(Game g) {
		this.myGame = g;
		this.mode = 1;
		myGC = new GameCanvas(this.myGame);
		myMenu = new MainMenu(this);
		myHelp = new HelpPage(this);
		setLayout(new BorderLayout());
		
		add(myMenu);
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
	}
	
	public void newGame() {
		remove(myMenu);
		add(myGC, BorderLayout.CENTER);
		setVisible(true);
		mode = 2;
		System.out.println("1");
	}
	
	public void showHelp() {
		remove(myMenu);
		add(myHelp, BorderLayout.CENTER);
		setVisible(true);
		mode = 3;
		System.out.println("1");
	}
	
	public void backToMain() {
		remove(myHelp);
		add(myMenu);
		setVisible(true);
		mode = 4;
		//System.out.println("1");
	}
	
	public void redraw() {
		this.myGC.repaint();
	}
	
	public int getMode() {
		return mode;
	}
}
