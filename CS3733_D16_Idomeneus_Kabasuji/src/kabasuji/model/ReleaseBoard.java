package kabasuji.model;

@SuppressWarnings("serial")
public class ReleaseBoard extends Board {
	
	public ReleaseBoard(Tile[][] t) {
		super(t);
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

				if(tiles[i][j].getPiece() != null)
				{
					if (tiles[i][j].getColor() == 1)
					{
						color0Released[tiles[i][j].getNumber()-1] = 1;
					}
					else if (tiles[i][j].getColor() == 2)
					{
						color1Released[tiles[i][j].getNumber()-1] = 1;
					}
					else if (tiles[i][j].getColor() == 3)
					{
						color2Released[tiles[i][j].getNumber()-1] = 1;
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
	
	public ReleaseBoard copy()
	{
		Tile[][] t = new Tile[tiles.length][tiles.length];
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				t[i][j] = tiles[i][j].copy();
			}
		}
		return new ReleaseBoard(t);
	}
	

	
}