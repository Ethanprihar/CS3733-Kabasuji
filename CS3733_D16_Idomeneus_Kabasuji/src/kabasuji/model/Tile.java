package kabasuji.model;

import java.io.Serializable;

/**
 * this class keeps track of all the values asociated with tiles, like if they are
 * part of a board or piece, or it they have a color or number, or if they are a hint
 * @author Ethan
 *
 */
public class Tile implements Serializable{

	/* whether the tile is part of a board or a piece or just extra in the matrix */
	boolean valid;
	/* whether hint or not */
	boolean hint;
	/* 0 mean no color, 1 - 3 means color */
	int color;
	/* 0 means no number, 1 - 6 means number */
	int number;
	/* Piece the tile belongs to */
	Piece piece;

	/**
	 * creates a new tile
	 * @param h whether the tile is a hint
	 * @param v whether the tile is part of something
	 * @param c what color the tile has
	 * @param n what number the tile has
	 */
	public Tile(boolean h, boolean v, int c, int n) {
		hint = h;
		valid = v;
		piece = null;
		color = c;
		number = n;
	}

	/**
	 * toggles whether the tile is a hint or not
	 */
	public void toggleHint() {
		hint = !hint;
	}

	/**
	 * returns if the tile is part of a piece or board
	 * @return if the tile is valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * returns if the tile is a hint tile
	 * @return if the tile is a hint tile
	 */
	public boolean isHint() {
		return hint;
	}

	/**
	 * returns the color of the tile
	 * @return an int corresponding to the color of the tile
	 */
	public int getColor() {
		return color;
	}

	/**
	 * returns the number associated with the tile
	 * @return the number associated with the tile
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * returns the piece this tile is a part of
	 * @return the piece this tile is a part of
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * sets the tiles validity
	 * @param v the tiles validity
	 */
	public void setValid(boolean v) {
		valid = v;
	}

	/**
	 * sets if the tile is a hint tile
	 * @param h whether the tile is a hint
	 */
	public void setHint(boolean h) {
		hint = h;
	}

	/**
	 * sets the tiles color
	 * @param c the tiles color
	 */
	public void setColor(int c) {
		color = c;
	}

	/**
	 * sets the tiles number
	 * @param n the tiles number
	 */
	public void setNumber(int n) {
		number = n;
	}
	
	/**
	 * sets the tiles piece
	 * @param p the tiles piece
	 */
	public void setPiece(Piece p) {
		piece = p;
	}
	
	/**
	 * creates a copy of the tile
	 * @return a new tile that is a copy of this tile
	 */
	public Tile copy()
	{
		return new Tile(hint, valid, color, number);
	}
	
	/**
	 * determines whether two tiles are equal
	 * @param t the tile to compare this tile to
	 * @return whether the tiles are equal
	 */
	public boolean equals(Tile t)
	{
		if(getNumber()  != t.getNumber())
		{
			return false;
		}		
		if(isValid()  != t.isValid())
		{
			return false;
		}	
		if(isHint()  != t.isHint())
		{
			return false;
		}	
		if(getColor()  != t.getColor())
		{
			return false;
		}
		return true;
	}
	
	/**
	 * returns a string that displays traits of the tile
	 * @return a string that displays traits of the tile
	 */
	public String toString()
	{
		if(hint)
			return "h ";
		else if(valid)
			return "v ";
		else
			return "* ";
	}
}
