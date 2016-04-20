package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class ChangeScreenMove extends Move{
	
	// target screen represented as integer
	int newScreen;
	
	// Constructor for Change Screen Move
	public ChangeScreenMove(int newScreen ){
		this.newScreen = newScreen;
	}

	@Override
	public boolean execute(Kabasuji kabasuji) {
		if(!valid(kabasuji)){
			return false;
		}
		/** sets screen of kabasuji game to desired**/
		kabasuji.setCurrentScreen(newScreen);
		return true;
	}

	@Override
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if the current screen is not equal to the new screen
		if (kabasuji.getCurrentScreen() != newScreen){
			return true;
		}
		return false;
	}
}
