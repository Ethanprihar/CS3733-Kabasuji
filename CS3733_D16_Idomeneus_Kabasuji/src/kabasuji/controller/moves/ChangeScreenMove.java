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
	
	/**
	 * creates a changescreenmove
	 * @param newScreen this is the new screen to go to
	 */
	public ChangeScreenMove(int newScreen ){
		this.newScreen = newScreen;
	}

	@Override
	/**
	 * changes from one screen to another
	 * @return whether or not the move was executed
	 */
	public boolean execute(Kabasuji kabasuji) {
		if(!valid(kabasuji)){
			return false;
		}
		kabasuji.setCurrentScreen(newScreen);
		return true;
	}

	@Override
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if the current screen is not equal to the new screen
		if (kabasuji.getCurrentScreen() != newScreen){
			return true;
		}
		return false;
	}
}
