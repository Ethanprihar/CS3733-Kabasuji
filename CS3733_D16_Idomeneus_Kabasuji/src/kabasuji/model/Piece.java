package kabasuji.model;

public class Piece
{
	Tile[][] tiles;
	
	public Piece(Tile[][] t)
	{
		tiles = t;
		for(int i = 0; i<this.getDim(); i++)
		{
			for(int j = 0; j<this.getDim(); j++)
			{
				if(this.tiles[j][i].isValid())
				{
					this.tiles[j][i].setPiece(this);
				}
			}
		}
	}
	
	public void rotate(boolean right)
	{
		flip(right);
		transpose();
	}
	
	public void flip(boolean vertical)
	{
		Tile[][] newTiles = new Tile[tiles.length][tiles.length];
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
		Tile[][] newTiles = new Tile[tiles.length][tiles.length];
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				newTiles[i][j] = tiles[j][i];
			}
		}
		tiles = newTiles;
	}
	
	public Tile getTile(int y, int x)
	{
		return tiles[y][x];
	}
	
	public int getDim()
	{
		return tiles.length;
	}
}
