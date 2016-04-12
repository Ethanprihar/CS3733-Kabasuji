package kabasuji.model;

public class ReleaseTile extends PlayableTile {
	int number; // 0 - 5
	int color; //0, 1 or 2

	// Constructor for Release Tile
	public ReleaseTile(int number, int color) {
		super();
		this.color = color;
		this.number = number;
	}

	
	public int getColor() {
		return color;
	}

	public void setColor(int c) {
		color = c;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int n) {
		number = n;
	}
}
