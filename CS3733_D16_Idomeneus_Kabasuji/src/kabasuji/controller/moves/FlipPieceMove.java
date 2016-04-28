package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;

/**
 * Move class to flip piece in bullpen by passing in the particular piece and direction
 * in the constructor. Validity of move is always checked
 * before execution of move.
 * @author jwu
 */

public class FlipPieceMove extends Move{
	// Piece of interest
	Piece piece;
	// direction of flip
	boolean vertical;
	
	// Constructor for Rotate Piece Move
	public FlipPieceMove(Piece piece, boolean vertical){
		this.piece = piece;
		this.vertical = vertical;
	}

	@Override
	public boolean execute(Kabasuji kabasuji) {
		if (!valid(kabasuji)) {
			return false;
		}
		/** rotates the selected piece **/
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() == null) {
			kabasuji.getSelectedLevel().getBoard().getSelectedPiece().flip(vertical);
		} else {
			kabasuji.getSelectedLevel().getBullpen().getSelectedPiece().flip(vertical);
		}
		return true;
	}

	@Override
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if current selected piece is not empty
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() != null
				|| kabasuji.getSelectedLevel().getBoard().getSelectedPiece() != null) {
			return true;
		}
		return false;
	}
}
