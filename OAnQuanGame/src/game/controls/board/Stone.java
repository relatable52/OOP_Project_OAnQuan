package game.controls.board;

public class Stone {
	private int value;
	private boolean isQuan;
	
	public Stone(boolean isQuan) {
		this.isQuan = isQuan;
		if(isQuan) {
			this.value = 1;
		}
		else {
			this.value = 5;
		}
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isQuan() {
		return this.isQuan;
	}
}
