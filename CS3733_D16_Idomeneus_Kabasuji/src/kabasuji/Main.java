package kabasuji;

import kabasuji.model.Kabasuji;
import kabasuji.view.SplashWindow;
import kabasuji.view.TopLevelApplication;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Kabasuji kabasuji = new Kabasuji();
		TopLevelApplication frame = new TopLevelApplication(kabasuji);
		// start splash screen
		new SplashWindow();
		// after splash screen ends, show game
		frame.setVisible(true);
	}
}
