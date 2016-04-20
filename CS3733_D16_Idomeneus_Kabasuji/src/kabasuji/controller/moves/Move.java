package kabasuji.controller.moves;

import kabasuji.model.Kabasuji;

public abstract class Move {

	/** Execute given move. */
	public abstract boolean execute(Kabasuji kabasuji);
	
	/** Request validity. */
	public abstract boolean valid(Kabasuji kabasuji);
}

