package kabasuji.model;

public class LightningLevel extends Level {

	int timeLimit;
	int currentTime;
	
	LightningLevel(Board bd, Bullpen bp, int tl) {
		super(bd, bp);
		timeLimit = tl;
		currentTime = 0;
	}
	
	public abstract boolean canMoveBullpenToBoard(Tile destination);
	
	public abstract boolean canMoveBoardToBullpen();
	
	public abstract boolean canMoveBoardToBoard(Tile destination);
	
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
