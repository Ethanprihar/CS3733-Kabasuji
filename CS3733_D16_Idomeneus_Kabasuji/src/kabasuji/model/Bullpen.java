package kabasuji.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

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
	
	/* pieces array */
	Piece[] piecestored;

	/**
	 * The constructor for the Bullpen class
	 */
	public Bullpen() {
		pieces = new ArrayList<Piece>();
		piecestored = new Piece[35];
		try
		{
			FileInputStream saveFile = new FileInputStream("pieces.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			piecestored = (Piece[]) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			System.out.println("No pieces were found");
		}
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
	public void replacePieceRand(int index){
		Random rand = new Random();
		int n = rand.nextInt(piecestored.length);
		pieces.set(index, piecestored[n].copy());
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
