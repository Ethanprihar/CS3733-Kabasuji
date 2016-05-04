package levelbuilder.controller.moves;

import javax.swing.JTextField;

import kabasuji.model.Builder;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class LevelModeBuilderMove extends BuilderMove{
	
	/**target screen represented as integer*/
	int levelType;
	/**The board dimension*/
	JTextField boardDimensions;
	
	// Constructor for Change Screen Move
	/**
	 * creates a LevelModeBuilderMove
	 * @param levelType the type of level to build
	 * @param boardDimensions the height and width of the board in the level
	 */
	public LevelModeBuilderMove(int levelType, JTextField boardDimensions){
		this.levelType = levelType;
		this.boardDimensions = boardDimensions;
	}

	@Override
	/**
	 * Sets the level type for the builder.
	 * @return whether or not the move was executed
	 */
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		builder.setCurrentScreen(levelType);
		return true;
	}

	@Override
	/**
	 * determines whether the move can be made.
	 * @return whether the move can be made
	 */
	public boolean valid(Builder builder) {
		
		boolean valid = false;
		try {
			// Check for the input in the textfield
			String boardDimensionstext = boardDimensions.getText();
			int dimensions = Integer.parseInt(boardDimensionstext);
			System.out.println(dimensions);
			
			if ((!((dimensions < 3) || (dimensions > 12))) && (levelType == 0 || levelType == 1 || levelType == 2)){
				valid = true;
			}
		}catch(IllegalArgumentException e){
			System.out.println("Invalid board dimensions");
			valid = false;
		}
		
		// Check for the appropriate mouse click for the level type
		if ((levelType == 0) && (valid == true)){
			return true;
		}
		
		else if ((levelType == 1) && (valid == true)){
			return true;
		}
		
		else if ((levelType == 2) && (valid == true)){
			return true;
		}
		
		return false;
	}
}
