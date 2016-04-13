package kabasuji.model;

public class PuzzleLevel extends Level {

	int movesUsed;
	int maxMoves;
	
	PuzzleLevel(PuzzleBoard bd, Bullpen bp, int mm) {
		super(bd, bp);
		maxMoves = mm;
		movesUsed = 0; // initialize the moves used to 0
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
	
	public void moveBoardToBoard(Tile destination)
	{
		board.shiftPiece(board.getSelectedPiece(), destination);
		board.selectPiece(null);
	}
	
	public boolean canMoveBullpenToBoard(Tile destination) {
		// check that the player has moves left and the piece can be added to the board
		return ((hasMovesLeft()) && (board.canAddPiece(bullpen.selectedPiece, destination)));	
	}
	
	public boolean canMoveBoardToBullpen() {
		// check that the player has moves left and the piece can be added to the board
		return hasMovesLeft();
	}
	
	public boolean canMoveBoardToBoard(Tile destination) {
		// check that the player has moves left and the piece can be added to the board
		return ((hasMovesLeft()) && (board.canShiftPiece(bullpen.selectedPiece, destination)));
	}

}
