package kabasuji.model;

public class LightningBoard extends Board {
	
	LightningBoard(BlankTile[][] t) {
		super(t);
	}
	
	/**
	 * Pieces can never be removed from Lightning boards.
	 */
	@Override
	public boolean canRemovePiece()
	{
		return false;
	}


	@Override
	public boolean canAddPiece() {
		// TODO Auto-generated method stub
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
