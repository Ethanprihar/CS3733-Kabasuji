package kabasuji.controller.moves;

import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class ChangeScreenBuilderMove extends BuilderMove{
	
	// target screen represented as integer
	int newScreen;
	
	// Constructor for Level Select Move
	public ChangeScreenBuilderMove(int newScreen ){
		this.newScreen = newScreen;
	}

	@Override
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		/** sets screen of kabasuji game to desired**/
		builder.setCurrentScreen(newScreen);
		return true;
	}

	@Override
	public boolean valid(Builder builder) {
		// move is valid if the current screen is not equal to the new screen
		if (builder.getCurrentScreen() != newScreen){
			return true;
		}
		return false;
	}
}
