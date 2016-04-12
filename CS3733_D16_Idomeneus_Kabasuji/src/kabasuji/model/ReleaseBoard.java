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
		int[] color0Released = new int[6];
		int[] color1Released = new int[6];
		int[] color2Released = new int[6];
		
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
//				if(tiles[i][j] instanceof ReleaseTile) // TODO We shouldn't need instanceof but maybe this was designed poorly?
//				{
//					if (tiles[i][j].getColor() == 0)
//					{
//						
//					}
//				}
			}
		}
		return -1;
	}
	
	
}