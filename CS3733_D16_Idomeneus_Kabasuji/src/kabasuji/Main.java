package kabasuji;

import java.util.ArrayList;

import kabasuji.model.*;
import kabasuji.view.SplashWindow;
import kabasuji.view.TopLevelApplication;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		//THIS CODE SEGMENT WILL RESET THE LEVELS FILE AND ADD 15 FRESH LEVELS
//		Builder builder = new Builder();
//		builder.setLevels(new ArrayList<Level>());
//		for(int i=0; i<15; i++)
//		{
//			builder.addNewLevel(i%3, 12, 12);
//			builder.saveLevel();
//			System.out.println(builder.getLevels());
//		}
//		builder.saveToDisc();
		Kabasuji kabasuji = new Kabasuji();
		System.out.println("In Kabasuji the levels:");
		for(Level l: kabasuji.getLevels())
		{
			System.out.println(l.getLocked());
		}
		TopLevelApplication frame = new TopLevelApplication(kabasuji);
		// start splash screen
		new SplashWindow();
		// after splash screen ends, show game
		frame.setVisible(true);
	}
}
