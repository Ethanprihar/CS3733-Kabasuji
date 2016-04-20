package kabasuji.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// TODO make a copy method in board
// TODO make a equals method in board

public class Builder
{
	int currentScreen;
	ArrayList<Level> levels;
	Piece[] pieces;
	int[] numOfPieces;
	Level selectedLevel;
	int endCondition;
	int currentColor;
	int currentNumber;
	ArrayList<Board> boardHistory;
	ArrayList<int[]> bullpenHistory;
	
	public Builder()
	{
		currentColor = 0;
		currentNumber = 0;
		pieces = new Piece[35];
		numOfPieces = new int[35];
		levels = new ArrayList<Level>();
		boardHistory = new ArrayList<Board>();
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
		endCondition = selectedLevel.getEndCondition();
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
		selectedLevel.setEndCondition(endCondition);
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

	public void addNewLevel(int type, int dim)
	{
		Bullpen bullpen = new Bullpen();
		Tile[][] tiles = new Tile[dim][dim];
		for(int i=0; i<dim;i++)
		{
			for(int j=0; j<dim; j++)
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
	// needs to be called before changing a tile or changing a number of pieces
	public void updateHistory()
	{
		boolean remove = false;
		for(int i=0; i<boardHistory.size(); i++)
		{
			if(!remove && boardHistory.get(i).equals(selectedLevel.getBoard()) && Arrays.equals(bullpenHistory.get(i), numOfPieces))
				remove = true;
			if(remove)
			{
				boardHistory.remove(boardHistory.get(i));
				bullpenHistory.remove(bullpenHistory.get(i));
				i--;
			}
		}
		boardHistory.add(selectedLevel.getBoard().copy());
		bullpenHistory.add(numOfPieces.clone());
	}
	
	// undoes the last tile change
	public void undo()
	{
		for(int i=0; i<boardHistory.size(); i++)
		{
			if(boardHistory.get(i).equals(selectedLevel.getBoard()) && Arrays.equals(bullpenHistory.get(i), numOfPieces) && (i != 0))
			{
				selectedLevel.setBoard(boardHistory.get(i-1));
				numOfPieces = bullpenHistory.get(i-1);
				return;
			}
		}
	}
	
	//redoes the last tile change
	public void redo()
	{
		for(int i=0; i<boardHistory.size(); i++)
		{
			if(boardHistory.get(i).equals(selectedLevel.getBoard()) && Arrays.equals(bullpenHistory.get(i), numOfPieces) && (i != boardHistory.size() - 1))
			{
				selectedLevel.setBoard(boardHistory.get(i-1));
				numOfPieces = bullpenHistory.get(i-1);
				return;
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
	
	public int getCurrentScreen()
	{
		return currentScreen;
	}
	
	public void setCurrentScreen(int newScreen)
	{
		currentScreen = newScreen;
	}
	
	public void incrementNum(int index)
	{
		numOfPieces[index]++;
	}
	
	public int getCurrentNumber()
	{
		return currentNumber;
	}
	
	public void setCurrentNumber(int n)
	{
		currentNumber = n;
	}
	
	public int getCurrentColor()
	{
		return currentColor;
	}
	
	public void setCurrentColor(int c)
	{
		currentColor = c;
	}
}
