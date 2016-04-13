package kabasuji.model;

public class Kabasuji {
	// to indicate opening, level select, and level play screens
	int currentScreen;
	public Kabasuji(){
		currentScreen = 1;
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
