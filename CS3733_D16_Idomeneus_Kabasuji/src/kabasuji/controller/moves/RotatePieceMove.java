package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;

/**
 * Move class to rotate piece in bullpen by passing in the particular piece and
 * direction in the constructor. Validity of move is always checked before
 * execution of move.
 * 
 * @author jwu
 */

public class RotatePieceMove extends Move {
	// Piece of interest
	Piece piece;
	// direction of rotation
	boolean right;

	// Constructor for Rotate Piece Move
	/**
	 * creates a RotatePieceMove
	 * @param piece the piece to rotate
	 * @param right true if the direction to rotate is right, false if left
	 */
	public RotatePieceMove(Piece piece, boolean right) {
		this.piece = piece;
		this.right = right;
	}

	@Override
	/**
	 * rotates the selected piece
	 * @return whether or not the move was executed
	 */
	public boolean execute(Kabasuji kabasuji) {
		if (!valid(kabasuji)) {
			return false;
		}
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() == null) {
			kabasuji.getSelectedLevel().getBoard().getSelectedPiece().rotate(right);
		} else {
			kabasuji.getSelectedLevel().getBullpen().getSelectedPiece().rotate(right);
		}
		return true;
	}

	@Override
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if current selected piece is not empty
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() != null
				|| kabasuji.getSelectedLevel().getBoard().getSelectedPiece() != null) {
			return true;
		}
		return false;
	}
}
