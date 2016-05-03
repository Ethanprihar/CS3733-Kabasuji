package kabasuji.model;

/**
 * This class extends Level class to get the shared logic between the different types of levels. It contains the 
 * specific lightning level logic for example the timer information.
 * @author Ethan
 *
 */
public class LightningLevel extends Level {

	/** The time limit in seconds for the level */
	int timeLimit;
	
	/** The current time in seconds */
	int currentTime;
	
	/**
	 * Constructor for the class
	 * @param bd Lightning Board
	 * @param bp Lightning level bullpen
	 * @param tl Time limit for the level
	 */
	public LightningLevel(LightningBoard bd, Bullpen bp, int tl) {
		super(bd, bp);
		timeLimit = tl;
		currentTime = 0;
	}
	
	/**
	 * This method makes a copy of the current lightning level. It will copy all the information about the level.
	 * @return The copied level
	 */
	public Level copy()
	{
		LightningLevel l = new LightningLevel((LightningBoard)board.copy(), bullpen.copy(), timeLimit);
		l.setLocked(false);
		return l;
	}
	
	/**
	 * This method adds 1 to the current time.
	 */
	public void incrementCurrentTime() {
		currentTime += 1;
	}
	
	/**
	 * Setter for the time in the level.
	 * @param time The time in int which you want to set
	 */
	public void setCurrentTime(int time) {
		currentTime = time;
	}
	
	/**
	 * Getter for the current time in the level.
	 * @return The current time in seconds in the level
	 */
	public int getCurrentTime() {
		return currentTime;
	}
	
	/**
	 * Getter for the time limit in the lightning level.
	 * @return The time limit in seconds in the level
	 */
	public Integer getEndCondition()
	{
		return timeLimit;
	}
	
	/**
	 * Setter for the time limit in the lightning level.
	 */
	public void setEndCondition(int ec)
	{
		timeLimit = ec;
	}
	
	/**
	 * This method checks if the piece can be moved from bullpen to the board. It checks for the time in the
	 * lightning level and allows the player to mode the piece if there is time left along with the other logic.
	 * @return True if the piece can be moved
	 */
	public boolean canMoveBullpenToBoard(Tile destination)
	{
		return (board.canAddPiece(bullpen.getSelectedPiece(), destination) && hasTimeLeft());
	}
	
	/**
	 * This method determines if the piece can be moved back to bullpen from the board.
	 * @return False because it is a lightning level
	 */
	public boolean canMoveBoardToBullpen()
	{
		return false;
	}
	
	/**
	 * This method determines if the piece can be moved from one position on the board to another position
	 * on the board.
	 * @return False because it is a lightning level
	 */
	public boolean canMoveBoardToBoard(Tile destination)
	{
		return false;
	}
	
	/**
	 * Getter for the time limit in the level.
	 * @return The time limit in the level
	 */
	public int getTimeLimit() {
		return timeLimit;
	}
	
	/**
	 * Calculate and returns the time left in the level at any point of time.
	 * @return The time left in the level
	 */
	public int getTimeLeft() {
		return timeLimit - currentTime;
	}
	
	/**
	 * This method determines whether there is time left in the level or not (> 0).
	 * @return True if there is time left i.e > 0
	 */
	public boolean hasTimeLeft() {
		return ((timeLimit - currentTime) > 0);
	}
	
	/**
	 * Setter for the time limit in the level.
	 * @param tl The time limit in seconds that is to be set
	 */
	public void setTimeLimit(int tl) {
		timeLimit = tl;
	}

}
