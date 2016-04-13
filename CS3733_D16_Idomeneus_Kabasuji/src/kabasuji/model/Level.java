package kabasuji.model;

public abstract class Level {
	Board board;
	Bullpen bullpen;
	int stars;
	boolean locked;
	
	Level(Board bd, Bullpen bp)
	{
		this.board = bd;
		this.bullpen = bp;
		stars = 0; // initialize number of stars to 0
	}
	
	public abstract boolean canMoveBullpenToBoard(Tile destination);
	
	public abstract boolean canMoveBoardToBullpen();
	
	public abstract boolean canMoveBoardToBoard(Tile destination);
	
	public void moveBullpenToBoard(Tile destination)
	{
		board.addPiece(bullpen.getSelectedPiece(), destination);
		bullpen.removePiece(bullpen.getSelectedPiece());
		bullpen.selectPiece(null);
	}
	
	public void moveBoardToBullpen()
	{
		bullpen.addPiece(board.getSelectedPiece());
		board.removePiece(board.getSelectedPiece());
		board.selectPiece(null);
	}

	public int getScore()
	{
		return board.getStars();
	}
	
	public boolean getLocked()
	{
		return locked;
	}
	
	public void setLocked(boolean l)
	{
		locked = l;
	}
	
}
