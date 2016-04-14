package kabasuji.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Board implements Serializable{
	Tile[][] tiles;// = new Tile[][];
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	Piece selectedPiece; //The selected piece. May be null.
	
	Board(Tile[][] t)
	{
		this.tiles = t;
	}
	
	/**
	 * 
	 * This method adds a piece to the board
	 * using a tile on the board as the anchor point
	 * for the overlapping of the piece's matrix of
	 * tiles onto the board's matrix of tiles.
	 * Only tiles in the piece's matrix that contain
	 * a piece will be copied to the board's matrix.
	 */
	public void addPiece(Piece p, Tile start)
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

							if(p.getTile(y,x).isValid())
							{
								tiles[i+y][j+x].setPiece(p);
								tiles[i+y][j+x].setValid(true);
							}
						}
					}
				}
			}
		}
		pieces.add(p);		
	}
	
	
	/**
	 * Removes a piece from the board.
	 */
	public void removePiece(Piece p)
	{
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(tiles[i][j].getPiece() == p)
				{
					tiles[i][j].setPiece(null);
				}
			}
		}
		pieces.remove(p);
	}
	
	/** 
	 * Can piece be added to the board, given target tile as anchor
	 * 
	 */
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
;
							if((p.getTile(y,x).isValid()))
								if(!(tiles[i+y][j+x].isValid()))
									return false;
								else if(!(tiles[i+y][j+x].getPiece() == null))
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
	 * Default false, puzzle overrides.
	 */
	public boolean canRemovePiece(Piece p)
	{
		return false;
	}
	
	
	public abstract boolean isComplete();
	
	// Sets the selected piece in memory to the given  newly selected piece.
	public void selectPiece(Piece p)
	{
		this.selectedPiece = p;
	}
	
	public Piece getSelectedPiece()
	{
		return this.selectedPiece;
	}

	/**
	 * Common to both Puzzle and Lightning boards.
	 * Release has it's own override.
	 */
	public int getStars() {

		int uncoveredTiles = 0;
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(tiles[i][j].isValid() && tiles[i][j].getPiece() == null)
				{
					uncoveredTiles++;
				}
			}
		}
		//Return the number of stars.
		return (uncoveredTiles == 0) ? 3 : (uncoveredTiles <= 6) ? 2 : (uncoveredTiles <=12) ? 1: 0;
	}
	
	public void shiftPiece(Piece p, Tile start) {}
	
	public boolean canShiftPiece(Piece p, Tile start) {
		return false;
	}

}
