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
	
	/**
	 * creates a FlipPieceMove
	 * @param piece the piece to flip
	 * @param vertical boolean to determine if flipping vertical or horizontal
	 */
	public FlipPieceMove(Piece piece, boolean vertical){
		this.piece = piece;
		this.vertical = vertical;
	}

	@Override
	/**
	 * flips the selected piece
	 * @return whether or not the move was executed
	 */
	public boolean execute(Kabasuji kabasuji) {
		if (!valid(kabasuji)) {
			return false;
		}
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() == null) {
			kabasuji.getSelectedLevel().getBoard().getSelectedPiece().flip(vertical);
		} else {
			kabasuji.getSelectedLevel().getBullpen().getSelectedPiece().flip(vertical);
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
