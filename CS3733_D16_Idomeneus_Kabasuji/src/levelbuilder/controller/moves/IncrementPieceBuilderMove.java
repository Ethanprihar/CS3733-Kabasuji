package levelbuilder.controller.moves;

import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class IncrementPieceBuilderMove extends BuilderMove{
	
	// target screen represented as integer
	int pieceNum;
	
	// Constructor for Change Screen Move
	public IncrementPieceBuilderMove(int pieceNum){
		this.pieceNum = pieceNum;
	}

	@Override
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		// Give information to the builder
		builder.incrementNum(pieceNum);
		
		return true;
	}

	@Override
	public boolean valid(Builder builder) {
				
		return true;
	}
}
