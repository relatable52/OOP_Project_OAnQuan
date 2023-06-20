package game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import game.controls.board.*;

public class MainWindow extends JFrame{
	private BoardDrawer myBD;
	//private JMenuBar myMB;
	
	public MainWindow(Board b) {
		myBD = new BoardDrawer(b);
		add(myBD, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ô Ăn Quan");
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Board b = new Board();
		new MainWindow(b);
	}
}
