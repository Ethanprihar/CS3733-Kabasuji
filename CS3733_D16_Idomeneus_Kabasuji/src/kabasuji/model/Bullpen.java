package kabasuji.model;
import java.util.ArrayList;

public class Bullpen {

	//ArrayList<ArrayList<BlankTile>> tiles = new ArrayList<ArrayList<BlankTile>>();
	ArrayList<Piece> pieces;
	Piece selectedPiece;
	
	// Bullpen class constructor
	public Bullpen() {}
	
	// Adds a piece to the pieces array list
	public void addPiece(Piece piece) {
		
		if(canAddPiece(piece)) {
			pieces.add(piece);
		}
	}
	
	// Remove a piece from the bullpen
	public void removePiece(Piece piece) {
		
		if(canRemovePiece(piece)) {
			pieces.remove(piece);
		}
	}
	
	// Determines if a piece can be added to the bullpen
	public boolean canAddPiece(Piece piece) {
		return true;
	}
	
	// Determines if a piece can be removed from the bullpen
	public boolean canRemovePiece(Piece piece) {
		return true;
	}
	
	// Sets the selected piece in memory to the given newly selected piece.
	void selectPiece(Piece p)
	{
		this.selectedPiece = p;
	}
	
}
