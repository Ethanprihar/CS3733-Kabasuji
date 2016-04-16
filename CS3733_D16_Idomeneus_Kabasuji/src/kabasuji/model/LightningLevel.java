package kabasuji.model;

public class LightningLevel extends Level {

	int timeLimit;
	int currentTime;
	
	public LightningLevel(LightningBoard bd, Bullpen bp, int tl) {
		super(bd, bp);
		timeLimit = tl;
		currentTime = 0;
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
	
	public int getCurrentTime() {
		return currentTime;
	}
	
	public void setTimeLimit(int tl) {
		timeLimit = tl;
	}
	
	public void setCurrentTime(int ct) {
		currentTime = ct;
	}
	
	// returns true if there is time left in the game
	public boolean hasTimeLeft() {
		return ((timeLimit - currentTime) > 0);
	}
	
	// returns the amount of time left in the game
	public int getTimeLeft() {
		return (timeLimit - currentTime);
	}


}
