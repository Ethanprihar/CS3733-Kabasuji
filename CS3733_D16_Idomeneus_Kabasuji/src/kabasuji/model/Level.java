package kabasuji.model;

import java.io.Serializable;

public abstract class Level implements Serializable{
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

	public void updateStars()
	{
		stars = board.getStars();
	}
	
	public int getStars()
	{
		return stars;
	}
	
	public boolean canGoNextLevel()
	{
		return stars > 0;
	}
	
	public boolean getLocked()
	{
		return locked;
	}
	
	public void setLocked(boolean l)
	{
		locked = l;
	}
	
	public Bullpen getBullpen()
	{
		return bullpen;
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void setBoard(Board b)
	{
		board = b;
	}
}
