package kabasuji.model;

import java.util.ArrayList;

public abstract class Board {
	BlankTile tiles[][] = new BlankTile[12][12];
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	Piece selectedPiece; //The selected piece. May be null.
	
	Board(BlankTile[][] t)
	{
		this.tiles = t;
	}
	
	// This method adds a piece to the board
	// using a tile on the board as the anchor point
	// for the overlapping of the piece's matrix of
	// tiles onto the board's matrix of tiles.
	// Only tiles in the piece's matrix that contain
	// a piece will be copied to the board's matrix.
	public void addPiece(Piece p, BlankTile start)
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
							if(p.getTile(y,x).getPiece() != null)
								tiles[i+y][j+x] = p.getTile(y,x);
						}
					}
				}
			}
		}
		pieces.add(p);		
	}
	
	public void removePiece(Piece p)
	{
		for(int i=0; i<tiles.length; i++)
		{
			for(int j=0; j<tiles.length; j++)
			{
				if(tiles[i][j].getPiece() != null && tiles[i][j].getPiece() == p)
				{
					tiles[i][j] = new Tile();
				}
			}
		}
		pieces.remove(p);
	}
	
	public abstract boolean canAddPiece();
	
	public abstract boolean canRemovePiece();
	
	public abstract boolean isComplete();
	
	// Sets the selected piece in memory to the given  newly selected piece.
	void selectPiece(Piece p)
	{
		this.selectedPiece = p;
	}

	/**
	 * Common to both Puzzle and Lightning boards.
	 * Release has it's own override.
	 * @return
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
}
