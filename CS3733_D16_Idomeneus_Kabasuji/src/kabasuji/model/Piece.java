package kabasuji.model;

import java.io.Serializable;

public class Piece implements Serializable
{
	Tile[][] tiles;
	
	public Piece(Tile[][] t)
	{
		tiles = t;
		for(int i = 0; i<tiles.length; i++)
		{
			for(int j = 0; j<tiles.length; j++)
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
	
	public boolean equals(Piece p)
	{
		boolean equal = true;
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(equal)
					equal = p.getTile(i,j).equals(getTile(i,j));
			}
		}
		return equal;
	}
	
	public Piece copy()
	{
		Tile[][] t = new Tile[tiles.length][tiles.length];
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				boolean v = tiles[i][j].isValid();
				t[i][j] = new Tile(false, v, 0, 0);
			}
		}
		return new Piece(t);
	}
	public Tile[][] getTiles(){
		return tiles;
	}
}
