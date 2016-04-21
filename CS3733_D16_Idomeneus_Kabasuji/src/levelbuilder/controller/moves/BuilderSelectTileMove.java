package levelbuilder.controller.moves;

import kabasuji.model.Builder;
import kabasuji.model.Tile;

/**
 * Move class to move to different screens by passing in the screen number
 * as the target screen in the constructor. Validity of move is always checked
 * before execution of move
 * @author jwu
 */

public class BuilderSelectTileMove extends BuilderMove{
	
	// target tile
	Tile currentTile;
	
	// Constructor for Change Screen Move
	public BuilderSelectTileMove(Tile currentTile){
		this.currentTile = currentTile;
	}

	@Override
	public boolean execute(Builder builder) {
		if(!valid(builder)){
			return false;
		}
		// Give information to the builder to make the tile valid
		currentTile.setValid(true);
		
		return true;
	}

	@Override
	public boolean valid(Builder builder) {
		
		boolean valid = false;
		
		if (!(currentTile.isValid())){
			valid = true;
		}
				
		return valid;
	}
}
