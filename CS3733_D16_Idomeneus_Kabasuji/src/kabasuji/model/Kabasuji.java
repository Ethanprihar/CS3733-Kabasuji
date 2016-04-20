package kabasuji.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Kabasuji
{
	// to indicate opening, level select, and level play screens
	int currentScreen;
	public ArrayList<Level> levels;
	public Level selectedLevel;
	
	public Kabasuji()
	{
		currentScreen = 1;
		loadLevels();
		if(levels.get(0).getLocked())
			levels.get(0).setLocked(false);
			levels.get(1).setLocked(false);
	}
	
	public void selectLevel(Level l)
	{
		selectedLevel = l;
	}
	
	public void unlockNextLevel()
	{
		levels.get(levels.indexOf(selectedLevel)+1).setLocked(false);
	}
	
	public ArrayList<Level> getLevels()
	{
		return levels;
	}
	
	// getter for current Screen
	public int getCurrentScreen(){
		return currentScreen;
	}
	// setter for current Screen
	public void setCurrentScreen(int newCurrentScreen){
		currentScreen = newCurrentScreen;
	}
	
	public Level getSelectedLevel(){
		return selectedLevel;
	}
	
	public void setSelectedLevel(Level l){
		selectedLevel = l;
	}
	
	public void resetLevel()
	{
		int index = levels.indexOf(selectedLevel);
		selectedLevel = null;
		loadLevels();
		selectedLevel = levels.get(index);
	}
	
	private void loadLevels()
	{
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
	}
	
	public void saveLevels()
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
}
