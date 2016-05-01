package kabasuji.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// AFTER YOU UNDO YOU CAN'T UPDATE BOARD HISTORY OR REDO BOARD MOVES

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
	
	public void deleteLevel()
	{
		if (levels.contains(selectedLevel))
			levels.remove(selectedLevel);
		selectedLevel = null;
	}

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
	
	// undoes the last tile change
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
	
	//redoes the last tile change
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

	//gets the number of a given piece.
	public int getNum(int index)
	{
		return numOfPieces[index];
	}
	
	// Return the pieces array
	public int[] getPieces(){
		return numOfPieces;
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
	
	public void setEndCondition(int ec)
	{
		endCondition = ec;
	}
	
	/*public void addToBullpen(int[] numOfPieces){
		for (int i = 0; i < numOfPieces.length; i++){
			for (int j = 0; j < numOfPieces[i]; j++){
				getSelectedLevel().getBullpen().getPieces().add(pieces[i]);
			}
		}
	}*/
}