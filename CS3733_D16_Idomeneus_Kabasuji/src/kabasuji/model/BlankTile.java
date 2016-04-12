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
}
