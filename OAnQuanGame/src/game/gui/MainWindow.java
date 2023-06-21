package game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import game.controls.board.*;

public class MainWindow extends JFrame{
	private GameCanvas myGC;
	//private JMenuBar myMB;
	
	public MainWindow(Board b) {
		myGC = new GameCanvas(b);
		add(myGC, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		MainWindow myWindow = new MainWindow(b);
		while(true) {
			myWindow.myGC.repaint();
		}
	}
}
