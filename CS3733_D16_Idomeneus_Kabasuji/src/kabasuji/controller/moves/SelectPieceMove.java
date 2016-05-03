package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;

/**
 * Move class to select piece in bullpen by passing in the particular piece in
 * the constructor. Validity of move is always checked before execution of move
 * 
 * @author jwu
 */

public class SelectPieceMove extends Move {
	// Piece of interest
	Piece piece;

	/**
	 * creates a SelectPieceMove
	 * @param piece the piece that is to be selected
	 */
	public SelectPieceMove(Piece piece) {
		this.piece = piece;
	}

	@Override
	/**
	 * changes the selected piece
	 * @return whether or not the move was executed
	 */
	public boolean execute(Kabasuji kabasuji) {
		if (!valid(kabasuji)) {
			return false;
		}
		kabasuji.getSelectedLevel().getBullpen().selectPiece(piece);
		// kabasuji.getSelectedLevel().getBoard().selectPiece(piece);

		return true;
	}

	@Override
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if current piece does not equal target piece
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() != piece) {
			return true;
		}
		return false;
	}
}
