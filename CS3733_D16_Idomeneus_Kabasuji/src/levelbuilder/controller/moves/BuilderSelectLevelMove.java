package levelbuilder.controller.moves;

import kabasuji.model.Builder;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move.
 * @author ocd
 */


// @ TODO THis might not need to exist at all...


public class BuilderSelectLevelMove extends BuilderMove{
	
	// target screen represented as integer
	int level;
	
	// Constructor for Level Select Move
	public BuilderSelectLevelMove(int level){
		this.level = level;
	}

	@Override
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		
		/** changes the selected level**/
		builder.loadLevel(builder.levels.get(level-1));
		return true;
	}

	@Override
	public boolean valid(Builder builder) {
		// move is valid if the current screen is not equal to the new screen
		if (!builder.levels.get(level-1).isLocked()){
			System.out.println("Level is " + !builder.levels.get(level-1).isLocked());
			return true;
		}
		return false;
	}


}
