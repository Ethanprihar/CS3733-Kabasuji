package kabasuji.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Kabasuji {
	// to indicate opening, level select, and level play screens
	int currentScreen;
	public ArrayList<Level> levels;
	public Level selectedLevel;

	public Kabasuji() {
		currentScreen = 1;
		loadLevels();
		if (levels.get(0).isLocked())
			levels.get(0).setLocked(false);
	}

	public void selectLevel(Level l) {
		selectedLevel = l;
	}

	public ArrayList<Level> getLevels() {
		return levels;
	}

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
	
	// getter for current Screen
	public int getCurrentScreen() {
		return currentScreen;
	}

	// setter for current Screen
	public void setCurrentScreen(int newCurrentScreen) {
		currentScreen = newCurrentScreen;
	}

	public Level getSelectedLevel() {
		return selectedLevel;
	}

	public void setSelectedLevel(Level l) {
		selectedLevel = l;
	}

	public void nextLevel() {
		int index = levels.indexOf(selectedLevel);
		saveLevels();
		selectedLevel = levels.get(index + 1);
	}

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

	private void loadLevels() {
		try {
			FileInputStream saveFile = new FileInputStream("levels.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
		for (int i = 0; i < levels.size() - 1; i++) {
			if (levels.get(i).getHighScore() > 0) {
				levels.get(i).setLocked(false);
				levels.get(i + 1).setLocked(false);
			}
		}
	}

	public void saveLevels() {
		// if they improve their score
		if (selectedLevel != null) {
			if (selectedLevel.getStars() > selectedLevel.getHighScore()) {
				int temp = selectedLevel.getStars();
				if (!(levels.size() <= levels.indexOf(selectedLevel) + 1)) {
					boolean makeUnlocked = false;
					if (levels.get(levels.indexOf(selectedLevel) + 1).isLocked())
						makeUnlocked = true;
					resetLevel();
					if (makeUnlocked)
						levels.get(levels.indexOf(selectedLevel) + 1).setLocked(false);
				}
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
