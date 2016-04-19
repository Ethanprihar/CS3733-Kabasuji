package kabasuji.model;

public class ReleaseLevel extends Level {

	int movesUsed;
	int maxMoves;
	
	public ReleaseLevel(ReleaseBoard bd, Bullpen bp, int mm) {
		super(bd, bp);
		maxMoves = mm;
		movesUsed = 0; // initialize the moves used to 0
	}
	
	public int getEndCondition()
	{
		return maxMoves;
	}
	
	public void setEndCondition(int ec)
	{
		maxMoves = ec;
	}
	
	public int getMovesUsed() {
		return movesUsed;
	}
	
	public int getMaxMoves() {
		return maxMoves;
	}
	
	public void setMovesUsed(int m) {
		movesUsed = m;
	}
	
	public void setMaxMoves(int m) {
		maxMoves = m;
	}
	
	// Returns true if there are still moves left
	public boolean hasMovesLeft() {
		return ((maxMoves - movesUsed) > 0);
	}

	// Returns the number of moves left
	public int getMovesLeft() {
		return maxMoves - movesUsed;
	}
	
	
	
	public boolean canMoveBullpenToBoard(Tile destination) {
		// check that the player has moves left and the piece can be added to the board
		return ((hasMovesLeft()) && (board.canAddPiece(bullpen.selectedPiece, destination)));	
	}
	
	/**
	 * Release Mode does not allow board to bullpen movement
	 */
	public boolean canMoveBoardToBullpen() {
		return false;
	}
	
	/**
	 * Release Mode does not allow board to board movement
	 */
	public boolean canMoveBoardToBoard(Tile destination) {
		return true; 
	}
	
}
