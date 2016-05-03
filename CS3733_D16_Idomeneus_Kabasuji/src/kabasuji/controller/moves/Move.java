package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;
/**
 * Abstract Move class.
 * @author jwu
 *
 */

public abstract class Move {

	/**
	 * Executes the move
	 * @return whether or not the move was executed
	 */
	public abstract boolean execute(Kabasuji kabasuji);
	
	/**
	 * determines whether the move can be made
	 * @return whether the move can be made
	 */
	public abstract boolean valid(Kabasuji kabasuji);
}

