package kabasuji.model;

import java.io.Serializable;

/**
 * This class is an abstract model class for the levels. It contains the shared logic for the different types
 * of the levels like Puzzle, Lightning and Release. 
 * @author Ethan
 *
 */
public abstract class Level implements Serializable{
	
	/** The board for the level */
	Board board;
	
	/** The bullpen for the level */
	Bullpen bullpen;
	
	/** Variable to keep track of the state of the level i.e. locked or unlocked */
	boolean locked;
	
	/** Highest score for the level */
	int highScore;
	
	/** useful constants **/
	public final static int Puzzle = 0;
	public final static int Lighting = 1;
	public final static int Release = 2;
	
	/**
	 * Constructor for the level abstract class
	 * @param bd Board for the level
	 * @param bp Bullpen for the level
	 */
	Level(Board bd, Bullpen bp)
	{
		this.board = bd;
		this.bullpen = bp;
		highScore = 0;
	}
	
	/**
	 * Getter for the end condition i.e number of moves in the puzzle and release level and time in the 
	 * lightning level.
	 * @return The number of moves or time
	 */
	public abstract Integer getEndCondition();
	
	/**
	 * Setter for the end condition i.e number of moves in the puzzle and release level and time in the 
	 * lightning level.
	 * @param ec The number of moves or time
	 */
	public abstract void setEndCondition(int ec);
	
	/**
	 * This abstract method determines if a piece can be moved from bullpen to the board in a level.
	 * @param destination Tiles location on the board
	 * @return True if the move can be made
	 */
	public abstract boolean canMoveBullpenToBoard(Tile destination);
	
	/**
	 * This abstract method determines if a piece can be moved from the board back to the bullpen in a level.
	 * @return True if the move can be made
	 */
	public abstract boolean canMoveBoardToBullpen();
	
	/**
	 * This abstract method determines if a piece can be moved from one position on the board to 
	 * another position on the board in a level.
	 * @param destination Tiles location on the board
	 * @return True if the move can be made
	 */
	public abstract boolean canMoveBoardToBoard(Tile destination);
	
	/**
	 * This method makes a copy of the current level. It will copy all the information about the level.
	 * @return The copied level
	 */
	public abstract Level copy();
	
	/**
	 * This method makes the piece move from bullpen to the board.
	 * @param destination Tiles location on the board
	 */
	public void moveBullpenToBoard(Tile destination)
	{
		board.addPiece(bullpen.getSelectedPiece(), destination);
		bullpen.removePiece(bullpen.getSelectedPiece());
		bullpen.selectPiece(null);
	}
	
	/**
	 * This method makes the piece move from board back to the bullpen.
	 */
	public void moveBoardToBullpen()
	{
		bullpen.addPiece(board.getSelectedPiece());
		board.removePiece(board.getSelectedPiece());
		//board.selectPiece(null);
	}
	
	/**
	 * This method clears the bullpen and makes it a null object.
	 */
	public void clearBullpen()
	{
		bullpen = null;
	}
	
	/**
	 * This method gets the number of stars the player has achieved in a level.
	 * @return The number of stars achieved
	 */
	public int getStars()
	{
		return board.getStars();
	}
	
	/**
	 * This method gets the highest score the player has achieved for a particular level.
	 * @return The highest score in terms of the number of stars
	 */
	public int getHighScore()
	{
		return highScore;
	}
	
	/**
	 * Setter method for the highest score for the level.
	 * @param hs The number of stars to set
	 */
	public void setHighScore(int hs)
	{
		highScore = hs;
	}
	
	/**
	 * This method determines if the player can go to the next level or not based on the number of stars
	 * achieved. The player has to have at least one star to move to the next level.
	 * @return True if the player can go the next level
	 */
	public boolean canGoNextLevel()
	{
		return getStars() > 0;
	}
	
	/**
	 * This method determines if the level is locked or not.
	 * @return True if the level is locked
	 */
	public boolean isLocked()
	{
		return locked;
	}
	
	/**
	 * Setter to make a level locked.
	 * @param l True to make a level locked
	 */
	public void setLocked(boolean l)
	{
		locked = l;
	}
	
	/**
	 * Setter for the bullpen.
	 * @param bp The specified bullpen
	 */
	public void setBullpen(Bullpen bp){
		bullpen = bp;
	}
	
	/**
	 * Getter for the bullpen.
	 * @return The bullpen for the level
	 */
	public Bullpen getBullpen()
	{
		return bullpen;
	}
	
	/**
	 * Getter for the board.
	 * @return The board for the level
	 */
	public Board getBoard()
	{
		return board;
	}
	
	/**
	 * Setter for the board.
	 * @param b The specified board
	 */
	public void setBoard(Board b)
	{
		board = b;
	}
}
