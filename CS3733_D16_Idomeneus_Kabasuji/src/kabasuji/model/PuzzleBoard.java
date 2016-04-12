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

	@Override
	public boolean canAddPiece() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRemovePiece() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
