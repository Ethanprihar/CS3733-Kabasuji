package kabasuji.model;

public class ReleaseLevel extends Level {

	int movesUsed;
	int maxMoves;
	
	ReleaseLevel(Board bd, Bullpen bp, int mm) {
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
	
}
