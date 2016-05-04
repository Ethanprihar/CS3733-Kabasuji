package kabasuji.model;

import java.awt.Point;
import java.io.Serializable;

/**
 * this class stores all data relevant to pieces, such as their shape
 * it also contains all the logic for rotating and flipping pieces
 * @author Ethan
 *
 */
public class Piece implements Serializable
{
	/* 2D array of tiles to show piece */
	Tile[][] tiles;
	
	/* represents top leftmost existing tile with row bias */
	Point refpnt;
	
	/**
	 * this constructor creates a piece based on the contents
	 * of a matrix of tiles
	 * @param t the matrix of tiles that becomes the pieces shape
	 */
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
	
	/**
	 * rotates the piece 90 degrees in the direction specified
	 * @param right a boolean that if true, the piece is rotated right
	 * and if false, the piece rotates left
	 */
	public void rotate(boolean right)
	{
		flip(right);
		transpose();
	}
	
	/**
	 * this method flips the piece
	 * @param vertical if true the piece is flipped vertically
	 * and if false the pieces if flipped horizontally
	 */
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
	
	/**
	 * this method makes the piece matrix a transpose of its former self
	 * this is used as a helper method for rotating
	 */
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
	
	/**
	 * this method returns the tile at a specified location in the matrix
	 * @param y the row of the tile
	 * @param x the column of the tile
	 * @return the tile at the specified row and column
	 */
	public Tile getTile(int y, int x)
	{
		return tiles[y][x];
	}
	
	/**
	 * returns the dimension of the piece
	 * @return an int that is the number of rows and columns in the piece matrix
	 */
	public int getDim()
	{
		return tiles.length;
	}
	
	/**
	 * determines whether two pieces are the same shape
	 * @param p the piece that this piece is compared to
	 * @return boolean that is true if the pieces are the same shape
	 */
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
	
	/**
	 * returns a new piece with the same shape as this piece
	 * @return a new piece with the same shape as this piece
	 */
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
	
	/**
	 * returns the tile matrix that makes up the piece
	 * @return the tile matrix that makes up the piece
	 */
	public Tile[][] getTiles(){
		return tiles;
	}
	
	/**
	 * returns the location of the topmost leftmost part of the piece
	 * @return a point with the location of the topmost leftmost tile of the piece
	 */
	public Point findReferencePoint(){
		for(int i = 0; i< tiles.length; i++){
			for (int j = 0; j < tiles.length; j++){
				if(tiles[j][i].isValid()){
					refpnt = new Point(i,j);
					return refpnt;
				}
			}
		}
		System.out.println("NO REFERENCE POINT");
		return null;
	}
}
