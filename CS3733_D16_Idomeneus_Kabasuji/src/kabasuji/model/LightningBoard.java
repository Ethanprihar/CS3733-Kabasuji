package kabasuji.model;

public class LightningBoard extends Board {
	
	LightningBoard(Tile[][] t) {
		super(t);
	}
	

	/** Can piece be added to given target tile as anchor
	 * 
	 */
	@Override
	public boolean canAddPiece(Piece p, Tile start)
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

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}
}
