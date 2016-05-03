package kabasuji.model;

/**
 * This class extends Level class to get the shared logic between the different types of levels. It contains the 
 * specific puzzle level logic for example the number of moves information.
 * @author Ethan
 *
 */
public class PuzzleLevel extends Level {

	/** The number of moves already used by the player */
	int movesUsed;
	
	/** The maximum number of moves for the level */
	int maxMoves;

	/**
	 * Constructor for the class
	 * @param bd Puzzle board for the level
	 * @param bp Puzzle level bullpen
	 * @param mm The max number of moves allowed
	 */
	public PuzzleLevel(PuzzleBoard bd, Bullpen bp, int mm) {
		super(bd, bp);
		maxMoves = mm;
		movesUsed = 0; // initialize the moves used to 0
	}
	
	/**
	 * This method makes a copy of the puzzle level by saving all the information about the level.
	 * @return The copied puzzle level
	 */
	public Level copy()
	{
		PuzzleLevel l = new PuzzleLevel((PuzzleBoard)board.copy(), bullpen.copy(), maxMoves);
		l.setLocked(false);
		return l;
	}

	/**
	 * Getter for the end condition i.e. the max number of moves in the puzzle level.
	 * @return The number of moves allowed
	 */
	public Integer getEndCondition() {
		return maxMoves;
	}

	/**
	 * Setter for the end condition in the puzzle level.
	 * @param ec The number of moves to set for the level
	 */
	public void setEndCondition(int ec) {
		maxMoves = ec;
	}

	/**
	 * Getter for the number of moves used by the player
	 * @return The number of moves used
	 */
	public int getMovesUsed() {
		return movesUsed;
	}

	/**
	 * Getter for the maximum number of moves allowed in the level.
	 * @return The max number of moves
	 */
	public int getMaxMoves() {
		return maxMoves;
	}

	/**
	 * Setter for the moves used by the player in the level.
	 * @param m The number of moves used
	 */
	public void setMovesUsed(int m) {
		movesUsed = m;
	}

	/**
	 * Setter for the max moves in the level
	 * @param m The max number of moves as int to set
	 */
	public void setMaxMoves(int m) {
		maxMoves = m;
	}

	/**
	 * Returns true if there are still moves left.
	 * @return True if there are moves left i.e > 0
	 */
	public boolean hasMovesLeft() {
		return ((maxMoves - movesUsed) > 0);
	}

	/**
	 * Returns the number of moves left by subtracting max moves by moves used.
	 * @return The number of moves left in the level
	 */
	public int getMovesLeft() {
		return maxMoves - movesUsed;
	}

	/**
	 * Method to make the board to board move to a different location on the board.
	 * @param destination Destination tile on the board to add the piece
	 */
	public void moveBoardToBoard(Tile destination) {
		board.shiftPiece(board.getSelectedPiece(), destination);
		// board.selectPiece(null);
	}

	/**
	 * Method to determine if the bullpen to board move can be made. It has same implementation with
	 * the additional logic about the moves left. Only allow this move if there are moves left.
	 * @return True if the move can be made
	 */
	public boolean canMoveBullpenToBoard(Tile destination) {
		// check that the player has moves left and the piece can be added to
		// the board
		return ((hasMovesLeft()) && (board.canAddPiece(bullpen.selectedPiece, destination)));
	}

	/**
	 * Method to determine if the board to bullpen move can be made.
	 * @return True if the move can be made
	 */
	public boolean canMoveBoardToBullpen() {
		// check that the player has moves left and the piece can be added to
		// the board
		return hasMovesLeft();
	}

	/**
	 * Method to determine if the board to board (at a different position) move can be made. 
	 * It has same implementation with the additional logic about the moves left. 
	 * Only allow this move if there are moves left.
	 * @return True if the move can be made
	 */
	public boolean canMoveBoardToBoard(Tile destination) {
		// check that the player has moves left and the piece can be added to
		// the board
		// Changed to pass in board.selectedPiece instead of
		// bullpen.selectedPiece
		return ((hasMovesLeft()) && (board.canShiftPiece(board.selectedPiece, destination)));
	}

}
