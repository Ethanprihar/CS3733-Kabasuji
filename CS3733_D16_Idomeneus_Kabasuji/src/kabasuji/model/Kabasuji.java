package kabasuji.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * this class is responsible for maintaining the state of the game while its being played
 * it keeps track of the players progress through all the levels
 * @author Ethan
 *
 */
public class Kabasuji {
	/* to indicate opening, level select, and level play screens */
	int currentScreen;
	/** List of Levels */
	public ArrayList<Level> levels;
	/* current selected Level */
	public Level selectedLevel;

	/**
	 * This constructor starts kabasuji by loading all the levels from levels.data.
	 */
	public Kabasuji() {
		currentScreen = 1;
		loadLevels();
		if(levels == null)
			levels = new ArrayList<Level>();
		if(levels.size() > 0 && levels.get(0).isLocked())
			levels.get(0).setLocked(false);
	}

	/**
	 * this method selects a level to be played
	 * @param l the level to select
	 */
	public void selectLevel(Level l) {
		selectedLevel = l;
	}

	/**
	 * returns the list of all levels
	 * @return the list of all levels
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}

	/**
	 * changes the list of all levels to be a list of one level for testing
	 */
	public void loadTestLevels()
	{
		try
		{
			FileInputStream saveFile = new FileInputStream("testLevels.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}
	
	/**
	 * returns an int corresponding to the current screen being displayed
	 * @return an int corresponding to the current screen being displayed
	 */
	public int getCurrentScreen() {
		return currentScreen;
	}

	/**
	 * sets the current screen
	 * @param newCurrentScreen the next screen to be at
	 */
	public void setCurrentScreen(int newCurrentScreen) {
		currentScreen = newCurrentScreen;
	}

	/**
	 * returns the level being played
	 * @return the level being played
	 */
	public Level getSelectedLevel() {
		return selectedLevel;
	}

	/**
	 * sets a level to be played
	 * @param l the level to be played
	 */
	public void setSelectedLevel(Level l) {
		selectedLevel = l;
	}

	/**
	 * makes the level after the level being played the level being played
	 */
	public void nextLevel() {
		int index = levels.indexOf(selectedLevel);
		saveLevels();
		selectedLevel = levels.get(index + 1);
	}

	/**
	 * makes the level being played back to the way it was before the player started playing it
	 */
	public void resetLevel() {
		int index = levels.indexOf(selectedLevel);
		selectedLevel = null;
		loadLevels();
		if(index == -1)
			index = levels.size() - 1;
		selectedLevel = levels.get(index);

		// reset moves used for puzzle mode
		if (selectedLevel instanceof PuzzleLevel) {
			((PuzzleLevel) selectedLevel).setMovesUsed(0);
		}
		// reset moves used for release mode
		else if (selectedLevel instanceof ReleaseLevel) {
			((ReleaseLevel) selectedLevel).setMovesUsed(0);
		}
		// reset time used for release mode
		else if (selectedLevel instanceof LightningLevel) {
			((LightningLevel) selectedLevel).setCurrentTime(0);
		}
	}

	/**
	 * sets parameters of kabasuji based on the selected level
	 * to get ready to play that level
	 */
	public void loadLevel() {

		int index = levels.indexOf(selectedLevel);
		selectedLevel = levels.get(index);

		// reset moves used for puzzle mode
		if (selectedLevel instanceof PuzzleLevel) {
			((PuzzleLevel) selectedLevel).setMovesUsed(0);
			((PuzzleLevel) selectedLevel).getBoard().setNumStars(0);
		}
		// reset moves used for release mode
		else if (selectedLevel instanceof ReleaseLevel) {
			((ReleaseLevel) selectedLevel).setMovesUsed(0);
			((ReleaseLevel) selectedLevel).getBoard().setNumStars(0);
		}
		// reset moves used for release mode
		else if (selectedLevel instanceof LightningLevel) {
			((LightningLevel) selectedLevel).setCurrentTime(0);
			((LightningLevel) selectedLevel).getBoard().setNumStars(0);
		}

	}

	/**
	 * loads all of the levels to be played from levels.data
	 */
	private void loadLevels() {
		try {
			FileInputStream saveFile = new FileInputStream("levels.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		} catch (Exception exc) {
			//exc.printStackTrace(); // If there was an error, print the info.
		}
		if(levels != null)
			for (int i = 0; i < levels.size() - 1; i++) {
				if (levels.get(i).getHighScore() > 0) {
					levels.get(i).setLocked(false);
					levels.get(i + 1).setLocked(false);
				}
			}
	}

	/**
	 * saves the list of levels to levels.data after updating the high scores
	 * and whether a level is locked
	 */
	public void saveLevels() {
		// if they improve their score
		if (selectedLevel != null)
		{
			if (selectedLevel.getStars() > selectedLevel.getHighScore())
			{
				int temp = selectedLevel.getStars();
				if (!(levels.size() <= levels.indexOf(selectedLevel) + 1)) {
					boolean makeUnlocked = false;
					if (levels.get(levels.indexOf(selectedLevel) + 1).isLocked())
						makeUnlocked = true;
					resetLevel();
					if (makeUnlocked)
						levels.get(levels.indexOf(selectedLevel) + 1).setLocked(false);
				}
				resetLevel();
				selectedLevel.setLocked(false);
				selectedLevel.setHighScore(temp);
			}
			// if they dont improve their score
			else
				resetLevel();
			try {
				FileOutputStream saveFile = new FileOutputStream("levels.data");
				ObjectOutputStream save = new ObjectOutputStream(saveFile);
				save.reset();
				save.writeObject(levels);
				save.close();
			} catch (Exception exc) {
				// exc.printStackTrace(); // If there was an error, print the
				// info.
			}
		}
	}
}
