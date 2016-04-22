package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;

/**
 * Move class to rotate piece in bullpen by passing in the particular piece and direction
 * in the constructor. Validity of move is always checked
 * before execution of move.
 * @author jwu
 */

public class RotatePieceMove extends Move{
	// Piece of interest
	Piece piece;
	// direction of rotation
	boolean right;
	
	// Constructor for Rotate Piece Move
	public RotatePieceMove(Piece piece, boolean right){
		this.piece = piece;
		this.right = right;
	}

	@Override
	public boolean execute(Kabasuji kabasuji) {
		if(!valid(kabasuji)){
			return false;
		}	
		/** rotates the selected piece**/
		kabasuji.getSelectedLevel().getBullpen().getSelectedPiece().rotate(right);
		return true;
	}

	@Override
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if current selected piece is not empty
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() != null){
			return true;
		}
		return false;
	}
}
