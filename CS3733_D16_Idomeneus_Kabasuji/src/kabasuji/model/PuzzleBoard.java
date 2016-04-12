package kabasuji.model;

public class PuzzleBoard extends Board {
	
	PuzzleBoard(BlankTile[][] t) {
		super(t);
	}
	
	boolean canShiftPiece(Piece p)
	{
		return true;
	}

	void shiftPiece(Piece p)
	{
		
	}
	
}
