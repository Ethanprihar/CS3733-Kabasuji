package kabasuji.model;

public class LightningLevel extends Level {

	int timeLimit;
	int currentTime;
	
	public LightningLevel(LightningBoard bd, Bullpen bp, int tl) {
		super(bd, bp);
		timeLimit = tl;
		currentTime = 0;
	}
	
	public void incrementCurrentTime() {
		currentTime += 1;
	}
	
	public void setCurrentTime(int time) {
		currentTime = time;
	}
	
	public int getCurrentTime() {
		return currentTime;
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
	
	public int getTimeLeft() {
		return timeLimit - currentTime;
	}
	
	/*
	 * Returns a booleans indicating if there is time left in the game
	 */
	public boolean hasTimeLeft() {
		return ((timeLimit - currentTime) > 0);
	}
	
	public void setTimeLimit(int tl) {
		timeLimit = tl;
	}

}
