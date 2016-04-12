package kabasuji.model;

public class PuzzleBoard extends Board {
	
	PuzzleBoard(Tile[][] t) {
		super(t);
	}
	
	/**
	 * Same as canAddPiece function except that a piece can shift to overlap itself.
	 */
	boolean canShiftPiece(Piece p, Tile start)
	{
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
							try { //If we're trying to place a piece out of range of the board
							if(((p.getTile(y,x).isValid()) && !(tiles[i+y][j+x].isValid())))
								return false;
							else if(((p.getTile(y,x).isValid()) && !((tiles[i+y][j+x].getPiece() == null) || (tiles[i+y][j+x].getPiece() == p))))
								return false;
							} catch (IndexOutOfBoundsException e) 
							{
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * Shifts a piece on the board to another valid location on the board.
	 */
	void shiftPiece(Piece p, Tile start)
	{
		removePiece(p);
		addPiece(p, start);
	}

	/**
	 * Can always remove pieces from the puzzle boards.
	 */
	@Override
	public boolean canRemovePiece() 
	{return true;}

	@Override
	public boolean isComplete() {
		return false;
	}

	

	
}
