package kabasuji.model;

import java.io.*;
import java.util.ArrayList;

// TODO make a copy method in board
// TODO make a equals method in board

public class Builder
{
	int currentScreen;
	ArrayList<Level> levels;
	Piece[] pieces;
	int[] numOfPieces;
	Level selectedLevel;
	ArrayList<Board> history;

	public Builder()
	{
		pieces = new Piece[35];
		numOfPieces = new int[35];
		levels = new ArrayList<Level>();
		history = new ArrayList<Board>();
		try
		{
			FileInputStream saveFile = new FileInputStream("levels.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			//exc.printStackTrace(); // If there was an error, print the info.
		}
		try
		{
			FileInputStream saveFile = new FileInputStream("pieces.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			pieces = (Piece[]) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			//exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public void loadLevel(Level l)
	{
		selectedLevel = l;
		numOfPieces = new int[35];
		// this will set the 35 numbers corresponding to the 35
		// textfields that determine what pieces are in the bullpen
		for(Piece p: selectedLevel.getBullpen().getPieces())
		{
			for(int i=0; i<35; i++)
			{
				if(p.equals(pieces[i]))
				{
					numOfPieces[i]++;
				}
			}
		}
	}
	
	public void saveLevel()
	{
		for(int i=0; i<35; i++)
		{
			for(int j=0; j<numOfPieces[i]; j++)
			{
				selectedLevel.getBullpen().addPiece(pieces[i].copy());
			}
		}
		if (!levels.contains(selectedLevel))
			levels.add(selectedLevel);
		selectedLevel = null;
		numOfPieces = new int[35];
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
		for(int i=0; i<boardHeight;i++)
		{
			for(int j=0; j<boardWidth; j++)
			{
				tiles[i][j] = new Tile(false, true, 0, 0);
			}
		}
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
		selectedLevel.setLocked(true);
	}
	
	public void saveToDisc()
	{
		try
		{
			FileOutputStream saveFile = new FileOutputStream("levels.data");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.reset();
			save.writeObject(levels);
			save.close();
		}
		catch (Exception exc)
		{
			//exc.printStackTrace(); // If there was an error, print the info.
		}
	}
	
	// adds the current board to the history
	// needs to be called before changing a tile
	public void updateHistory()
	{
		boolean remove = false;
		for(Board b: history)
		{
			if(!remove && b.equals(selectedLevel.getBoard()))
			{
				remove = true;
			}
			if(remove)
			{
				history.remove(b);
			}
		}
		history.add(selectedLevel.getBoard());
	}
	
	// undoes the last tile change
	public void undo()
	{
		if(history.size() != 0)
		{
			for(Board b: history)
			{
				if(b.equals(selectedLevel.getBoard()))
				{
					selectedLevel.setBoard(history.get(history.indexOf(b)-1));
					break;
				}
			}
		}
	}
	
	//redoes the last tile change
	public void redo()
	{
		if(history.size() != 0)
		{
			for(Board b: history)
			{
				if(b.equals(selectedLevel.getBoard()) && (history.size()-1 > history.indexOf(b)))
				{
					selectedLevel.setBoard(history.get(history.indexOf(b)+1));
					break;
				}
			}
		}
	}
	
	public Level getSelectedLevel()
	{
		return selectedLevel;
	}
	
	public ArrayList<Level> getLevels()
	{
		return levels;
	}
	
	public void setLevels(ArrayList<Level> l)
	{
		levels = l;
	}
	public int getCurrentScreen(){
		return currentScreen;
	}
	public void setCurrentScreen(int newScreen){
		currentScreen = newScreen;
	}
}
