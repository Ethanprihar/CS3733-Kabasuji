package kabasuji.model;

public abstract class Level {
	Board board;
	Bullpen bullpen;
	Integer stars;
	boolean locked;
	
	Level(Board bd, Bullpen bp)
	{
		this.board = bd;
		this.bullpen = bp;
	}
	
	void resetLevel()
	{

	}

	int getScore()
	{
		return board.getStars();
	}
	
}
