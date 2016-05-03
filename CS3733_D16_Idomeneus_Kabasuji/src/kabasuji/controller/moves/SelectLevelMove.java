package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move.
 * @author jwu
 */

public class SelectLevelMove extends Move{
	
	// target screen represented as integer
	int level;
	
	// Constructor for Level Select Move
	/**
	 * creates a SelectLevelMove
	 * @param level the level that will be selected
	 */
	public SelectLevelMove(int level){
		this.level = level;
	}

	@Override
	/**
	 * changes the selected level
	 * @return whether or not the move was executed
	 */
	public boolean execute(Kabasuji kabasuji) {
		if(!valid(kabasuji)){
			return false;
		}
		kabasuji.setSelectedLevel(kabasuji.levels.get(level-1));
		return true;
	}

	@Override
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public boolean valid(Kabasuji kabasuji) {
		// move is valid if the current screen is not equal to the new screen
		if (!kabasuji.levels.get(level-1).isLocked()){
			System.out.println("Level is " + !kabasuji.levels.get(level-1).isLocked());
			return true;
		}
		return false;
	}
}
