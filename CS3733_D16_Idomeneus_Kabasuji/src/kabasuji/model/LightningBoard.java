package kabasuji.model;

public class LightningBoard extends Board {
	
	LightningBoard(BlankTile[][] t) {
		super(t);
	}
	
	
	@Override
	boolean canRemovePiece()
	{
		return false;
	}
}
