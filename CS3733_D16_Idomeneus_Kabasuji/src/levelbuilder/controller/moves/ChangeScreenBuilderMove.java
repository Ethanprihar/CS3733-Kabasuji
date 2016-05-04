package levelbuilder.controller.moves;

import kabasuji.model.Builder;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class ChangeScreenBuilderMove extends BuilderMove{
	
	/**target screen represented as integer*/
	int newScreen;
	
	/**
	 * creates a ChangeScreenBuilderMove.
	 * @param newScreen the new screen to be displayed
	 */
	public ChangeScreenBuilderMove(int newScreen ){
		this.newScreen = newScreen;
	}

	@Override
	/**
	 * changes the builder screen.
	 * @return whether or not the move was executed
	 */
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		builder.setCurrentScreen(newScreen);
		return true;
	}

	@Override
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public boolean valid(Builder builder) {
		// move is valid if the current screen is not equal to the new screen
		if (builder.getCurrentScreen() != newScreen){
			return true;
		}
		return false;
	}
}
