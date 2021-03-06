package levelbuilder.controller.moves;

import kabasuji.model.Builder;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class IncrementPieceBuilderMove extends BuilderMove{
	
	/**target screen represented as integer*/
	int pieceNum;
	
	/**
	 * creates an IncrementPieceBuilderMove
	 * @param pieceNum the location of the piece in the array of numbers of pieces
	 */
	public IncrementPieceBuilderMove(int pieceNum){
		this.pieceNum = pieceNum;
	}

	@Override
	/**
	 * increments the number of a certain type of piece
	 * @return whether or not the move was executed
	 */
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		// Give information to the builder
		builder.incrementNum(pieceNum);
		
		return true;
	}

	@Override
	/**
	 * determines whether the move can be made.
	 * @return whether the move can be made
	 */
	public boolean valid(Builder builder) {
				
		return true;
	}
}
