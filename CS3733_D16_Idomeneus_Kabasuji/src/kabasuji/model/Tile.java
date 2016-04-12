package kabasuji.model;

public class Tile extends BlankTile
{
	
	boolean valid; // whether the tile is interactable with
	boolean hint;
	Piece piece;
	int number; // 0 means no number, 1 - 6 means number
	int color; // 0 mean no color, 1 - 3 means color
	
	public Tile()
	{
		hint = false;
		piece = null;
	}
	
	public boolean isHint()
	{
		return hint;
	}
	
	public void setHint(boolean h)
	{
		hint = h;
	}
	
	public void toggleHint()
	{
		hint = !hint;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public void setPiece(Piece p)
	{
		piece = p;
	}
}
