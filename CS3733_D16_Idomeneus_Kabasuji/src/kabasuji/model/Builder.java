package kabasuji.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * this class monitors and controls the state of the level builder. it has all the functionality
 * to load and save levels and is responsible undoing and redoing in level builder
 * @author Ethan
 */

public class Builder
{
	int currentScreen;
	public ArrayList<Level> levels;
	Piece[] pieces;
	int[] numOfPieces;
	Level selectedLevel;
	int endCondition;
	int currentColor;
	int currentNumber;
	Stack<Board> boardHistory;
	Stack<Board> boardRedoList;
	Stack<int[]> bullpenHistory;
	Stack<int[]> bullpenRedoList;
	boolean didUndo;
	
	/**
	 * this is the constructor for builder, it initializes all the variables but leaves them empty
	 * then it loads all the levels and pieces from files.
	 */
	public Builder()
	{
		currentColor = 0;
		currentNumber = 0;
		pieces = new Piece[35];
		numOfPieces = new int[35];
		levels = new ArrayList<Level>();
		boardHistory = new Stack<Board>();
		boardRedoList = new Stack<Board>();
		bullpenHistory = new Stack<int[]>();
		bullpenRedoList = new Stack<int[]>();
		didUndo = false;
		try
		{
			selectedLevel = null;
			FileInputStream saveFile = new FileInputStream("levels.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			System.out.println("No levels were found");
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
			System.out.println("No pieces were found");
		}
	}

	/**
	 * this function is called when the player requests to edit a level that already exists
	 * it makes the selected level the level they choose to edit and changes the bullpen to
	 * be what it is for the loaded level
	 * @param l The level that is being selected for editing
	 */
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
		updateHistory();
	}
	
	/**
	 * this method takes the current numOfPieces array and uses it to add the corresponding pieces
	 * to the selected levels bullpen
	 * @param numOfPiecesOnLoad The array of numbers corresponding to how many of each piece the bullpen has
	 */
	public void saveLevel(int[] numOfPiecesOnLoad)
	{
		if(!(selectedLevel.getEndCondition() > 0))		//If this is being saved for the first time
		{		
			for(int i=0; i<35; i++)
			{
				for(int j=0; j<numOfPieces[i]; j++)
				{
					selectedLevel.getBullpen().addPiece(pieces[i].copy());
				}
				System.out.println("added " + numOfPieces[i] + " of piece " + i);
			}
		}
		else
		{
			for(int i=0; i<35; i++)
			{
				for(int j=numOfPiecesOnLoad[i]; j<numOfPieces[i]; j++)
				{
					selectedLevel.getBullpen().addPiece(pieces[i].copy());
				}
				//System.out.println("added " + numOfPieces[i] + " of piece " + i);
			}
		}
		
		
		selectedLevel.setEndCondition(endCondition);
		if (!levels.contains(selectedLevel))
			levels.add(selectedLevel);
		numOfPieces = new int[35];
		System.out.println("Printing levels.size() for some reason: " + levels.size());
	}
	/**
	 * this function saves the current level to a different file that can be loaded in kabasuji
	 * to test whether this level is a good level without adding it to the list of all levels
	 * @param numOfPiecesOnLoad the array of numbers corresponding to how many pieces are in the bullpen
	 */
	public void makeTestLevel(int[] numOfPiecesOnLoad)
	{
		ArrayList<Level> testLevels = new ArrayList<Level>();
		Level testLevel = selectedLevel.copy();
		
		if(!(testLevel.getEndCondition() > 0))		//If this is being saved for the first time
		{		
			for(int i=0; i<35; i++)
			{
				for(int j=0; j<numOfPieces[i]; j++)
				{
					testLevel.getBullpen().addPiece(pieces[i].copy());
				}
			}
		}
		else
		{
			for(int i=0; i<35; i++)
			{
				for(int j=numOfPiecesOnLoad[i]; j<numOfPieces[i]; j++)
				{
					testLevel.getBullpen().addPiece(pieces[i].copy());
				}
			}
		}
		testLevel.setEndCondition(endCondition);
		testLevels.add(testLevel);
		try
		{
			FileOutputStream saveFile = new FileOutputStream("testLevels.data");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.reset();
			save.writeObject(testLevels);
			save.close();
		}
		catch (Exception exc)
		{
			//exc.printStackTrace(); // If there was an error, print the info.
		}
	}
	
	/**
	 * this method removes the current selected level from the list of all levels
	 */
	public void deleteLevel()
	{
		if (levels.contains(selectedLevel))
			levels.remove(selectedLevel);
		selectedLevel = null;
	}

	/**
	 * this method creates a new level that the user can then edit
	 * @param type this determines whether the level is a puzzle, lightning, or release level
	 * @param dim this determines how many tiles high and wide the board starts out with.
	 */
	public void addNewLevel(int type, int dim)
	{
		numOfPieces = new int[35];
		boardHistory = new Stack<Board>();
		bullpenHistory = new Stack<int[]>();
		Bullpen bullpen = new Bullpen();
		Tile[][] tiles = new Tile[dim][dim];
		for(int i=0; i<dim;i++)
		{
			for(int j=0; j<dim; j++)
			{
				tiles[i][j] = new Tile(false, true, 0, 0);
			}
		}
		if (type == Level.Puzzle)
		{
			PuzzleBoard board = new PuzzleBoard(tiles);
			selectedLevel = new PuzzleLevel(board, bullpen, 0);
		}
		else if (type == Level.Lighting)
		{
			LightningBoard board = new LightningBoard(tiles);
			selectedLevel = new LightningLevel(board, bullpen, 0);
		}
		else if (type == Level.Release)
		{
			ReleaseBoard board = new ReleaseBoard(tiles);
			selectedLevel = new ReleaseLevel(board, bullpen, 0);
		}
		else {
			System.out.println("Builder.java: Invalid integer for level type");
			selectedLevel = null;
		}
		selectedLevel.setLocked(true);
		updateHistory();
	}
	
	/**
	 * this method saves the current list of all levels to the levels.data file so they
	 * can be loaded in kabasuji for playing
	 */
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
	
	/**
	 * this method saves the current state of the board and the bullpen of the current level
	 * it adds the state to a list of states in order to record the history of the level
	 * this method will erase knowledge of items that have been undone
	 */
	public void updateHistory()
	{
		System.out.println("History is being updated");
		boardRedoList.clear();
		bullpenRedoList.clear();
		boardHistory.add(selectedLevel.getBoard().copy());
		bullpenHistory.add(numOfPieces.clone());
		System.out.println("Current board history:");
		for(Board b: boardHistory)
		{
			System.out.println(b.toString());
		}
		System.out.println("Current redo list:");
		for(Board b: boardRedoList)
		{
			System.out.println(b.toString());
		}
	}
	
	/**
	 * this method reverts the state of the level to it's previous state
	 */
	public void undo()
	{
		// check to make sure we arn't at the first state
		if(boardHistory.size() > 1)
		{
			didUndo = true;
			boardRedoList.add(boardHistory.pop());
			bullpenRedoList.add(bullpenHistory.pop());
			int last = boardHistory.size() - 1;
			selectedLevel.setBoard(boardHistory.get(last));
			numOfPieces = bullpenHistory.get(last);
			boardHistory.add(boardHistory.pop().copy());
			bullpenHistory.add(bullpenHistory.pop().clone());
			for(Board b: boardHistory)
			{
				System.out.println(b.toString());
			}
		}
		// if there is nothing to undo, say so
		else
		{
			System.out.println("Nothing to undo");
		}
	}
	
	/**
	 * this method will bring the level to the state it was before a move was undone
	 */
	public void redo()
	{
		if(boardRedoList.size() > 0)
		{
			boardHistory.add(boardRedoList.pop());
			bullpenHistory.add(bullpenRedoList.pop());
			int last = boardHistory.size() - 1;
			selectedLevel.setBoard(boardHistory.get(last));
			numOfPieces = bullpenHistory.get(last);
			boardHistory.add(boardHistory.pop().copy());
			bullpenHistory.add(bullpenHistory.pop().clone());
			for(Board b: boardHistory)
			{
				System.out.println(b.toString());
			}
		}
		// if there is nothing to redo, say so
		else
		{
			System.out.println("Nothing to redo");
		}
	}
	
	/**
	 * returns the selected level
	 * @return the selected level
	 */
	public Level getSelectedLevel()
	{
		return selectedLevel;
	}
	
	/**
	 * returns the list of all levels
	 * @return the list of all levels
	 */
	public ArrayList<Level> getLevels()
	{
		return levels;
	}
	
	/**
	 * this method replaces the list of levels with a new list of levels
	 * @param l the list of levels that will replace the current list of levels
	 */
	public void setLevels(ArrayList<Level> l)
	{
		levels = l;
	}
	
	/**
	 * returns what screen is being displayed
	 * @return an int corresponding to what screen is displayed
	 */
	public int getCurrentScreen()
	{
		return currentScreen;
	}
	
	/**
	 * sets the value of the current screen
	 * @param newScreen this is the new current screen value
	 */
	public void setCurrentScreen(int newScreen)
	{
		currentScreen = newScreen;
	}

	/**
	 * this increases the number of a type of piece in the bullpen
	 * @param index an int corresponding to the piece that we are adding one more of
	 */
	public void incrementNum(int index)
	{
		numOfPieces[index]++;
	}

	/**
	 * returns how many of a certain piece are in the bullpen
	 * @param index the piece that we want to know how many of are in the bullpen
	 * @return how many of the given piece are in the bullpen
	 */
	public int getNum(int index)
	{
		return numOfPieces[index];
	}
	
	/**
	 * returns the list of how many of each piece are in the bullpen
	 * @return the list of how many of each piece are in the bullpen
	 */
	public int[] getPieces(){
		return numOfPieces;
	}
	
	/**
	 * returns the current number for release level tiles
	 * @return the current number for release level tiles
	 */
	public int getCurrentNumber()
	{
		return currentNumber;
	}
	
	/**
	 * sets the current number that tiles will be given for release levels
	 * @param n the number a tile will be given for release levels
	 */
	public void setCurrentNumber(int n)
	{
		currentNumber = n;
	}
	
	public int getCurrentColor()
	{
		return currentColor;
	}
	
	/**
	 * sets the current color that a tile will become when clicked on for release level building
	 * @param c the color a tile will become if clicked on
	 */
	public void setCurrentColor(int c)
	{
		currentColor = c;
	}
	
	/**
	 * this method sets the value of the end condition of the level, either total moves or time limit
	 * @param ec the end condition
	 */
	public void setEndCondition(int ec)
	{
		endCondition = ec;
	}
	
	public boolean addRandomRelease()
	{
		if(selectedLevel.getBoard().getTiles().length < 5)
			return false;
		int[] row = new int[18];
		int[] col = new int[18];
		int newRow = 0;
		int newCol = 0;
		for(int color = 1; color <= 3; color++)
		{
			for(int number = 1; number <=6; number++)
			{
				boolean newPos = false;
				while(!newPos)
				{
					newRow = (int)(Math.random() * selectedLevel.getBoard().getTiles().length + 1);
					newCol = (int)(Math.random() * selectedLevel.getBoard().getTiles().length + 1);
					newPos = true;
					for(int i = 0; i<18; i++)
					{
						if(row[i] == newRow && col[i] == newCol)
							newPos = false;
					}
				}
				selectedLevel.getBoard().getTile(newRow, newCol).setColor(color);
				selectedLevel.getBoard().getTile(newRow, newCol).setNumber(number);
				row[(color-1)*6+number] = newRow;
				col[(color-1)*6+number] = newCol;
			}
		}
		return true;
	}
}