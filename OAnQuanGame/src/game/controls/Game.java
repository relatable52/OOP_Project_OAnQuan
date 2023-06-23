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
		isP1Turn = false;
		waitMove = true;
	}
	
	public void start() {
		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(playGame()) {
					for(int i = 0; i<500; i++) {}
				}
			}
		});
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
		if(isValidMove(ci)) {
			if(isP1Turn) {
				this.player1.moveSetup(ci, d);
			}
			else {
				this.player2.moveSetup(ci, d);
			}
			this.waitMove = false;
		}
	}
	
	public boolean isValidMove(int oc) {
		boolean ret = false;
		if(this.isP1Turn() && oc<5 && oc>=0 && myBoard.getCells()[oc].getNumberOfStones()>0) {
			ret = true;
		}
		if(!this.isP1Turn() && oc<11 && oc>5 && myBoard.getCells()[oc].getNumberOfStones()>0) {
			ret = true;
		}
		return (ret && this.waitingForMove());
	}
	
	public Board getBoard() {
		return this.myBoard;
	}
	
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}
	
	public boolean gameEnd() {
		return this.myBoard.gameEnd();
	}
	
	public int getWinner() {
		int ret = -1;
		if(player1.getPoint()>player2.getPoint()) {
			ret = 1;
		}
		else if(player2.getPoint()>player1.getPoint()) {
			ret = 2;
		}
		else {
			ret = 3;
		}
		return ret;
	}
}
