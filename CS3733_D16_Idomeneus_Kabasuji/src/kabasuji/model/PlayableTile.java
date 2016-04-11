package kabasuji.model;

public class PlayableTile extends BlankTile
{
	boolean hint;
	Piece piece;
	
	public PlayableTile()
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
