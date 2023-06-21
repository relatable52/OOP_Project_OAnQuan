package game.controls.player;

import java.util.*;

import game.controls.board.*;

public class Player {
	private ArrayList<Stone> inHand;
	private ArrayList<Stone> taken;
	private int playerId;
	private boolean endTurn = false;
	private int curIndex;
	
	public Player(int id) {
		this.inHand = new ArrayList<Stone>();
		this.taken = new ArrayList<Stone>();
		this.playerId = id;
	}
	
	public boolean makeMove(Board b) {
		if(this.inHand.size() == 0) {
			ArrayList<Stone> cur = b.getCells()[curIndex].getStonesInCell();
			if(cur.size() == 0) {
				if()
			}
			for(Stone s: cur) {
				this.inHand.add(s);
			}
			cur.clear();
		}
		else {
			
		}
		return endTurn;
	}
}
