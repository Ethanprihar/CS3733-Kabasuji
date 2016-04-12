package kabasuji.model;

public class BlankTile
{
	public BlankTile(){}
	
	// this method will be used to determine if a tile is part of the board
	public boolean isValid()
	{
		return false;
	}
	
	public Piece getPiece()
	{
		return null;
	}
	
	public int getColor() {
		return -1;
	}

	public void setColor() {	
	}

	public int getNumber() {
		return -1;
	}

	public void setNumber(int n) {
	}
}
