package kabasuji.model;

public class ReleaseBoard extends Board {
	
	ReleaseBoard(BlankTile[][] t) {
		super(t);
	}

	@Override
	public boolean canAddPiece() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Pieces can never be removed from Release boards.
	 */
	@Override
	public boolean canRemovePiece() {
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getStars() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}