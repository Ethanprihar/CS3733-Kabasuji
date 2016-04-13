package kabasuji.model;

public class LightningLevel extends Level {

	int timeLimit;
	int currentTime;
	
	LightningLevel(LightningBoard bd, Bullpen bp, int tl) {
		super(bd, bp);
		timeLimit = tl;
		currentTime = 0;
	}
	
	public boolean canMoveBullpenToBoard(Tile destination)
	{
		if(board.canAddPiece(bullpen.getSelectedPiece(), destination) && hasTimeLeft())
		{
			return true;
		}
		return false;
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
		timeLimit = ct;
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
