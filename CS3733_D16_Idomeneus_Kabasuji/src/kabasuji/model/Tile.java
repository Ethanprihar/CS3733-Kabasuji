package kabasuji.model;

public class Tile {

	boolean valid; // whether the tile is part of a board or a piece or just extra in the matrix
	boolean hint;
	int color; // 0 mean no color, 1 - 3 means color
	int number; // 0 means no number, 1 - 6 means number
	Piece piece;

	public Tile(boolean h, boolean v, int c, int n) {
		hint = false;
		piece = null;
		color = 0;
		number = 0;
	}

	public void toggleHint() {
		hint = !hint;
	}

	public boolean isValid() {
		return valid;
	}

	public boolean isHint() {
		return hint;
	}

	public int getColor() {
		return color;
	}

	public int getNumber() {
		return number;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setValid(boolean v) {
		valid = v;
	}

	public void setHint(boolean h) {
		hint = h;
	}

	public void setColor(int c) {
		color = c;
	}

	public void setNumber(int n) {
		number = n;
	}
	
	public void setPiece(Piece p) {
		piece = p;
	}
}