package kabasuji.model;

public class Piece
{
	BlankTile[][] tiles;
	
	public Piece(BlankTile[][] t)
	{
		tiles = t;
	}
	
	public void rotate(boolean left)
	{
		flip(left);
		transpose();
	}
	
	public void flip(boolean vertical)
	{
		BlankTile[][] newTiles = new BlankTile[tiles.length][tiles.length];
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(vertical)
					newTiles[i][j] = tiles[tiles.length-1-i][j];
				else
					newTiles[i][j] = tiles[i][tiles.length-1-j];
			}
		}
		tiles = newTiles;
	}
	
	private void transpose()
	{
		BlankTile[][] newTiles = new BlankTile[tiles.length][tiles.length];
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				newTiles[i][j] = tiles[tiles.length-1-i][tiles.length-1-j];
			}
		}
		tiles = newTiles;
	}
}
