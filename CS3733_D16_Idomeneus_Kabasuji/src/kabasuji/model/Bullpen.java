package kabasuji.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is the model class for the bullpen. It contains all the logic for the bullpen like adding or
 * removing the piece from the bullpen. This class keeps track of the selected piece in the bullpen.
 * @author Odell Dotson
 *
 */
public class Bullpen implements Serializable{

	/** Arraylist for the pieces */
	ArrayList<Piece> pieces;
	
	/** The selected piece in the bullpen */
	Piece selectedPiece;

	/**
	 * The constructor for the Bullpen class
	 */
	public Bullpen() {
		pieces = new ArrayList<Piece>();
	}
	
	/**
	 * This method makes a copy of the current bullpen and return the copy.
	 * @return The copied bullpen
	 */
	public Bullpen copy()
	{
		Bullpen bp = new Bullpen();
		for(Piece p: pieces)
		{
			bp.addPiece(p.copy());
		}
		return bp;
	}

	/**
	 * This method adds the specified piece to the pieces arraylist.
	 * @param piece The piece to be added to the arraylist
	 */
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}

	/**
	 * This method removes the specified piece from the pieces arraylist.
	 * @param piece The piece to be removes from the arraylist
	 */
	public void removePiece(Piece piece) {
		pieces.remove(piece);
	}

	/**
	 * This method sets the selected piece in memory to the given newly selected piece.
	 * @param piece The piece to be selected
	 */
	public void selectPiece(Piece p) {
		this.selectedPiece = p;
	}
	
	/**
	 * The getter method to get the current selected piece.
	 * @return The selected piece
	 */
	public Piece getSelectedPiece()
	{
		return selectedPiece;
	}
	
	/**
	 * This method determines if the pieces array is empty.
	 * @return True if the pieces array is empty and false otherwise
	 */
	public boolean isEmpty()
	{
		return pieces.size() == 0;
	}
	
	/**
	 * Getter method to get the arraylist of the pieces in the bullpen.
	 * @return The bullpen pieces arraylist
	 */
	public ArrayList<Piece> getPieces()
	{
		return pieces;
	}

}
