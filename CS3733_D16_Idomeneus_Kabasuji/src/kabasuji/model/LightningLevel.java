package kabasuji.model;

public class LightningLevel extends Level {

	int timeLimit;
	boolean timeLeft;
	
	public LightningLevel(LightningBoard bd, Bullpen bp, int tl) {
		super(bd, bp);
		timeLimit = tl;
		timeLeft = true;
	}
	
	public Integer getEndCondition()
	{
		return timeLimit;
	}
	
	public void setEndCondition(int ec)
	{
		timeLimit = ec;
	}
	
	public boolean canMoveBullpenToBoard(Tile destination)
	{
		return (board.canAddPiece(bullpen.getSelectedPiece(), destination) && hasTimeLeft());
	}
	
	public boolean canMoveBoardToBullpen()
	{
		return false;
	}
	
	public boolean canMoveBoardToBoard(Tile destination)
	{
		return false;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}
	
	/*
	 * Returns a booleans indicating if there is time left in the game
	 */
	public boolean hasTimeLeft() {
		return timeLeft;
	}
	
	public void setTimeLimit(int tl) {
		timeLimit = tl;
	}
	
	public void setTimeLeft(boolean tl) {
		timeLeft = tl;
	}

}
