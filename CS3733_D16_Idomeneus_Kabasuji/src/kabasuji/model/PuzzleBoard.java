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

	@Override
	public int getStars() {
		int uncoveredTiles = 0;
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(tiles[i][j].isValid() && tiles[i][j].getPiece() == null)
				{
					uncoveredTiles++;
				}
			}
		}
		//Return the number of stars.
		return (uncoveredTiles == 0) ? 3 : (uncoveredTiles <= 6) ? 2 : (uncoveredTiles <=12) ? 1: 0;
	}
	
}
