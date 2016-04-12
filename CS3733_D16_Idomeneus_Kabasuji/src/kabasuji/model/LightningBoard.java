package kabasuji.model;

public class LightningBoard extends Board {
	
	LightningBoard(Tile[][] t) {
		super(t);
	}
	
	@Override
	public boolean canAddPiece(Piece p, Tile start) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}
}
