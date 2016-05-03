package levelbuilder;

import kabasuji.model.Builder;
import kabasuji.model.Level;
import kabasuji.view.SplashWindow;
import levelbuilder.view.TopLevelApplicationBuilder;

public class LBMain {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// THIS CODE SEGMENT WILL RESET THE LEVELS FILE AND ADD 15 FRESH LEVELS
		// Builder builder = new Builder();
		// builder.setLevels(new ArrayList<Level>());
		// for(int i=0; i<15; i++)
		// {
		// builder.addNewLevel(i%3, 12, 12);
		// builder.saveLevel();
		// System.out.println(builder.getLevels());
		// }
		// builder.saveToDisc();
		Builder builder = new Builder();
		System.out.println("In Builder the levels:");
		for (Level l : builder.getLevels()) {
			System.out.println(l.isLocked());
		}
		TopLevelApplicationBuilder frame = new TopLevelApplicationBuilder(builder);
		// start splash screen
		new SplashWindow();
		// after splash screen ends, show game
		frame.setVisible(true);
	}
}
