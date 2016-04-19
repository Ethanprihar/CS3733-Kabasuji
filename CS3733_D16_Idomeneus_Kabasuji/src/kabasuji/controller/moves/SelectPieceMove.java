package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;

/**
 * Move class to select piece in bullpen by passing in the particular piece
 * in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class SelectPieceMove extends Move{
	// Piece of interest
	Piece piece;
	
	// Constructor for Select Piece Move
	public SelectPieceMove(Piece piece){
		this.piece = piece;
	}

	@Override
	public boolean execute(Kabasuji kabasuji) {
		if(!valid(kabasuji)){
			return false;
		}	
		/** changes the selected piece**/
		kabasuji.getSelectedLevel().getBullpen().selectPiece(piece);
		return true;
	}

	@Override
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if current piece does not equal target piece
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() != piece){
			return true;
		}
		return false;
	}
}
