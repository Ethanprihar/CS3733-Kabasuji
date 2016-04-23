package kabasuji.model;

import java.io.Serializable;

public abstract class Level implements Serializable{
	Board board;
	Bullpen bullpen;
	boolean locked;
	int highScore;
	
	/** useful constants **/
	final static int Puzzle = 0;
	final static int Lighting = 1;
	final static int Release = 2;
	
	Level(Board bd, Bullpen bp)
	{
		this.board = bd;
		this.bullpen = bp;
		highScore = 0;
	}
	
	public abstract int getEndCondition();
	
	public abstract void setEndCondition(int ec);
	
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
	
	public int getStars()
	{
		return board.getStars();
	}
	
	public int getHighScore()
	{
		return highScore;
	}
	
	public void setHighScore(int hs)
	{
		highScore = hs;
	}
	
	public boolean canGoNextLevel()
	{
		return getStars() > 0;
	}
	
	public boolean isLocked()
	{
		return locked;
	}
	
	public void setLocked(boolean l)
	{
		locked = l;
	}
	
	public void setBullpen(Bullpen bp){
		bullpen = bp;
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
