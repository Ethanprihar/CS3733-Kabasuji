package kabasuji.model;

public class ReleaseTile extends Tile {
	int number; // 0 means no number, 1 - 6 means number
	int color; // 0 mean no color, 1 - 3 means color

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
