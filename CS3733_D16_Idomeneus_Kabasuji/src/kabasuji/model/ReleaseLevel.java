package kabasuji.model;

/**
 * this class is responsible for dealing with the specifics of
 * a release level which is under what conditions a piece can be moved to the board
 * from the bullpen
 * @author Ethan
 *
 */
public class ReleaseLevel extends Level {

	int movesUsed;
	int maxMoves;
	
	/**
	 * creates a new release level
	 * @param bd the board that is part of the level
	 * @param bp the bullpen that is part of the level
	 * @param mm the maximum number of moves the player can make this level
	 */
	public ReleaseLevel(ReleaseBoard bd, Bullpen bp, int mm) {
		super(bd, bp);
		maxMoves = mm;
		movesUsed = 0; // initialize the moves used to 0
	}
	
	/**
	 * returns a new level that is a copy of this level
	 * @return a new level that is a copy of this level
	 */
	public Level copy()
	{
		ReleaseLevel l = new ReleaseLevel((ReleaseBoard)board.copy(), bullpen.copy(), maxMoves);
		l.setLocked(false);
		return l;
	}
	
	/**
	 * returns what the max number of moves for this level is
	 * @return the max number of moves for this level
	 */
	public Integer getEndCondition()
	{
		return maxMoves;
	}
	
	/**
	 * sets the max number of moves for this level
	 * @param ec the max number of moves to set for this level
	 */
	public void setEndCondition(int ec)
	{
		maxMoves = ec;
	}
	
	/**
	 * returns how many moves have been used so far in this level
	 * @return how many moves have been used so far in this level
	 */
	public int getMovesUsed() {
		return movesUsed;
	}
	
	/**
	 * returns the max moves
	 * @return the max moves
	 */
	public int getMaxMoves() {
		return maxMoves;
	}
	
	/**
	 * sets the number of moves that have been used this level
	 * @param m number of moves used this level
	 */
	public void setMovesUsed(int m) {
		movesUsed = m;
	}
	
	/**
	 * sets the max number of moves
	 * @param m the max number of moves
	 */
	public void setMaxMoves(int m) {
		maxMoves = m;
	}
	
	/**
	 * determines whether there are moves left
	 * @return true if there are moves left, false if no moves left
	 */
	public boolean hasMovesLeft() {
		return ((maxMoves - movesUsed) > 0);
	}

	/**
	 * returns how many moves the player can make
	 * @return how many moves the player can make
	 */
	public int getMovesLeft() {
		return maxMoves - movesUsed;
	}
	
	/**
	 * returns whether or not the player can move a piece from the bullpen to the board
	 * @param the tile that is the top left tile of a 6 by 6 section of the board that the piece
	 * matrix will overlap
	 * @return true if the player can make this move, false if not
	 */
	public boolean canMoveBullpenToBoard(Tile destination) {
		// check that the player has moves left and the piece can be added to the board
		return ((hasMovesLeft()) && (board.canAddPiece(bullpen.selectedPiece, destination)));	
	}
	
	/**
	 * Release Mode does not allow board to bullpen movement
	 * @return false
	 */
	public boolean canMoveBoardToBullpen() {
		return false;
	}
	
	/**
	 * Release Mode does not allow board to board movement
	 * @return false
	 */
	public boolean canMoveBoardToBoard(Tile destination) {
		return false; 
	}

}
