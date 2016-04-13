package kabasuji.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Kabasuji
{
	// to indicate opening, level select, and level play screens
	int currentScreen;
	ArrayList<Level> levels;
	Level selectedLevel;
	
	public Kabasuji()
	{
		currentScreen = 1;
		try
		{
			FileInputStream saveFile = new FileInputStream("levels.data");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			levels = (ArrayList<Level>) save.readObject();
			save.close();
		}
		catch (Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
		if(levels.get(0).getLocked())
			levels.get(0).setLocked(false);
	}
	
	public void selectLevel(Level l)
	{
		selectedLevel = l;
	}
	
	public void unlockNextLevel()
	{
		levels.get(levels.indexOf(selectedLevel)+1).setLocked(false);
	}
	
	// getter for current Screen
	public int getCurrentScreen(){
		return currentScreen;
	}
	// setter for current Screen
	public void setCurrentScreen(int newCurrentScreen){
		currentScreen = newCurrentScreen;
	}
}
