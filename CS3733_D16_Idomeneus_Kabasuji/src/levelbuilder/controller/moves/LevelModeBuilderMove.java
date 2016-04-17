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

public class LevelModeBuilderMove extends BuilderMove{
	
	// target screen represented as integer
	int levelType;
	JTextField boardDimensions;
	
	// Constructor for Change Screen Move
	public LevelModeBuilderMove(int levelType, JTextField boardDimensions){
		this.levelType = levelType;
		this.boardDimensions = boardDimensions;
	}

	@Override
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		/** sets screen of builder to desired**/
		builder.setCurrentScreen(levelType);
		return true;
	}

	@Override
	public boolean valid(Builder builder) {
		
		boolean valid = false;
		try {
			// Check for the input in the textfield
			String boardDimensionstext = boardDimensions.getText();
			int dimensions = Integer.parseInt(boardDimensionstext);
			System.out.println(dimensions);
			
			if ((!((dimensions < 3) || (dimensions > 12))) && (levelType == 1 || levelType == 2 || levelType == 3)){
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
		
		return false;
	}
}
