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
	
	void addPiece()
	{}
	
	void removePiece()
	{}
	
	boolean canAddPiece()
	{return true;}
	
	boolean canRemovePiece()
	{return true;}
	
	boolean isComplete()
	{return true;}
	
	// Sets the selected piece in memory to the given  newly selected piece.
	void selectPiece(Piece p)
	{
		this.selectedPiece = p;
	}
}
