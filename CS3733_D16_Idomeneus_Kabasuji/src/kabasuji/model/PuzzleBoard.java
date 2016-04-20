package kabasuji.model;

@SuppressWarnings("serial")
public class PuzzleBoard extends Board {
	
	public PuzzleBoard(Tile[][] t) {
		super(t);
	}
	
	/**
	 * Same as canAddPiece function except that a piece can shift to overlap itself.
	 */
	public boolean canShiftPiece(Piece p, Tile start)
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
							else if(((p.getTile(y,x).isValid()) && 
									!((tiles[i+y][j+x].getPiece() == null) || 
											(tiles[i+y][j+x].getPiece() == p))))
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
	public void shiftPiece(Piece p, Tile start)
	{
		removePiece(p);
		addPiece(p, start);
	}
	
	public PuzzleBoard copy()
	{
		Tile[][] t = new Tile[tiles.length][tiles.length];
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				t[i][j] = tiles[i][j].copy();
			}
		}
		return new PuzzleBoard(t);
	}

	/**
	 * Can always remove pieces from the puzzle boards.
	 */
	@Override
	public boolean canRemovePiece(Piece p) 
	{return true;}
}
