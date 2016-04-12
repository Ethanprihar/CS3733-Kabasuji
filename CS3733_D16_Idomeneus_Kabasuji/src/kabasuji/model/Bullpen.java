package kabasuji.model;

import java.util.ArrayList;

public class Bullpen {

	ArrayList<Piece> pieces;
	Piece selectedPiece;

	public Bullpen() {
	}

	// Adds a piece to the pieces array list
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}

	// Remove a piece from the pieces array list
	public void removePiece(Piece piece) {
		pieces.remove(piece);
	}

	// Sets the selected piece in memory to the given newly selected piece.
	void selectPiece(Piece p) {
		this.selectedPiece = p;
	}

}
