package levelbuilder.controller.moves;

import kabasuji.model.Builder;

public abstract class BuilderMove {

	/** Execute given move. */
	public abstract boolean execute(Builder builder);
	
	/** Request validity. */
	public abstract boolean valid(Builder builder);
}

