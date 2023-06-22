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
	//private JMenuBar myMB;
	
	public MainWindow(Game g) {
		myGC = new GameCanvas(g);
		add(myGC, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Game myGame = new Game();
		MainWindow myWindow = new MainWindow(myGame);
		
		while(true) {
			myWindow.myGC.repaint();
		}
	}
}
