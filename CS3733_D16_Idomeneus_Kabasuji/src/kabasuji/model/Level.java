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
		stars = 0; // initialize number of stars to 0
	}
	
	public abstract boolean canMoveBullpenToBoard(Tile destination);
	
	public abstract boolean canMoveBoardToBullpen();
	
	public abstract boolean canMoveBoardToBoard(Tile destination);

	int getScore()
	{
		return board.getStars();
	}
	
}
