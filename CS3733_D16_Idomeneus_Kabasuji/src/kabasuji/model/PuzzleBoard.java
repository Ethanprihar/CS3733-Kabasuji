package kabasuji.model;

public class PuzzleBoard extends Board {
	
	PuzzleBoard(Tile[][] t) {
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
	public boolean canAddPiece(Piece p, Tile start) {
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(tiles[i][j] == start)
				{
					for(int y=0; y<p.getDim(); y++)
					{
						for(int x=0; x<p.getDim(); x++)
						{
							if( !(p.getTile(y,x).isValid()))
								tiles[i+y][j+x] = p.getTile(y,x);
						}
					}
				}
			}
		}
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
