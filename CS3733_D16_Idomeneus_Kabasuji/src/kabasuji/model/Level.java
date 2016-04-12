package kabasuji.model;

public abstract class Level {
	Board board;
	Bullpen bullpen;
	int stars;
	boolean locked;
	
	Level(Board bd, Bullpen bp)
	{
		this.board = bd;
		this.bullpen = bp;
	}

	int getScore()
	{
		return board.getStars();
	}
	
}
