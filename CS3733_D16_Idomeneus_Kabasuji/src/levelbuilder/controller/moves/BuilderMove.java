package levelbuilder.controller.moves;

import kabasuji.model.Builder;

/**
 * this class is the parent class for all moves in the builder. the move is able to determine
 * if it can be made and then make itself
 * @author Jason
 *
 */
public abstract class BuilderMove {

	/**
	 * Executes the move
	 * @return whether or not the move was executed
	 */
	public abstract boolean execute(Builder builder);
	
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public abstract boolean valid(Builder builder);

}

