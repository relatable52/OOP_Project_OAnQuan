package game.controls;

import game.controls.board.*;
import game.controls.player.Player;

public class Game {
	private Board myBoard;
	private Player player1;
	private Player player2;
	private boolean isP1Turn;
	private boolean waitMove;
	private Thread t1;
	
	public Game() {
		myBoard = new Board();
		player1 = new Player(1);
		player2 = new Player(2);
		isP1Turn = true;
		waitMove = true;
	}
	
	public void start() {
		t1 = new Thread() {
			@Override
			public void run() {
				while(playGame()) {}
			}
		};
		t1.start();
	}
	
	public boolean playGame() {
		boolean ret = true;
		if(!waitMove && !myBoard.gameEnd()) {
			if(isP1Turn) {
				player1.makeMove(myBoard);
				if(player1.isTurn() != isP1Turn) {
					waitMove = true;
					isP1Turn = player1.isTurn();
				}
			}
			else {
				player2.makeMove(myBoard);
				if(player2.isTurn() == isP1Turn) {
					waitMove = true;
					isP1Turn = !player2.isTurn();
				}
			}
		}
		if(myBoard.gameEnd()) {
			if(player1.getPoint()>player2.getPoint()) {
				System.out.println("Player 1 win");
			}
			else if(player2.getPoint()>player1.getPoint()) {
				System.out.println("Player 2 win");
			}
			else {
				System.out.println("Tie");
			}
			ret = false;
		}
		return ret;
	}
	
	public boolean waitingForMove() {
		return waitMove;
	}
	
	public boolean isP1Turn() {
		return isP1Turn;
	}
	
	public void setMove(int ci, int d) {
		if(isP1Turn) {
			this.player1.moveSetup(ci, d);
		}
		else {
			this.player2.moveSetup(ci, d);
		}
	}
	
	public Board getBoard() {
		return this.myBoard;
	}

}
