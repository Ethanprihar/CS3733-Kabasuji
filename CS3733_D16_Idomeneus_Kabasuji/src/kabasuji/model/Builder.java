package kabasuji.model;

import java.io.*;
import java.util.ArrayList;

public class Builder
{
	ArrayList<Level> levels;
	Level selectedLevel;
	UndoManager undoManager;

	public Builder()
	{
		try
		{
			FileInputStream saveFile = new FileInputStream("levels.sav");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public void loadLevel(Level l)
	{
		selectedLevel = l;
	}

	public void saveLevel()
	{
		if (!levels.contains(selectedLevel))
			levels.add(selectedLevel);
		selectedLevel = null;
	}
	
	public void deleteLevel()
	{
		if (levels.contains(selectedLevel))
			levels.remove(selectedLevel);
		selectedLevel = null;
	}

	public void addNewLevel(int type, int boardHeight, int boardWidth)
	{
		Bullpen bullpen = new Bullpen();
		Tile[][] tiles = new Tile[boardHeight][boardWidth];
		if (type == 0)
		{
			PuzzleBoard board = new PuzzleBoard(tiles);
			selectedLevel = new PuzzleLevel(board, bullpen, 0);
		}
		else if (type == 1)
		{
			LightningBoard board = new LightningBoard(tiles);
			selectedLevel = new LightningLevel(board, bullpen, 0);
		}
		else
		{
			ReleaseBoard board = new ReleaseBoard(tiles);
			selectedLevel = new ReleaseLevel(board, bullpen, 0);
		}
	}
	
	public void saveToDisc()
	{
		try
		{
			FileOutputStream saveFile = new FileOutputStream("levels.sav");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(levels);
			save.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}
	
	public Level getSelectedLevel()
	{
		return selectedLevel;
	}
}
