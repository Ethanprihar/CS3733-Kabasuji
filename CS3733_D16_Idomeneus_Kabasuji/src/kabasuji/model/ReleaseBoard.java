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
		int stars = 0;
		
		int color0Score = 6;
		int color1Score = 6;
		int color2Score = 6;

		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(tiles[i][j] instanceof ReleaseTile) // TODO We shouldn't need instanceof but maybe this was designed poorly?
				{
					if (tiles[i][j].getColor() == 0)
					{
						color0Released[tiles[i][j].getNumber()] = 1;
					}
					else if (tiles[i][j].getColor() == 1)
					{
						color1Released[tiles[i][j].getNumber()] = 1;
					}
					else if (tiles[i][j].getColor() == 2)
					{
						color2Released[tiles[i][j].getNumber()] = 1;
					}
				}
			}
		}

		
		for(int k = 0; k<6; k++)
		{
			if(color0Released[k] == 1)
			{
				color0Score--;
			}
			if(color1Released[k] == 1)
			{
				color1Score--;
			}
			if(color2Released[k] == 1)
			{
				color2Score--;
			}
		}
		if(color0Score == 0)
			stars++;
		if(color1Score == 0)
			stars++;
		if(color2Score == 0)
			stars++;
		
		return stars;
	}
	
	
}