package levelbuilder.view;

import javax.swing.JPanel;
import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.GoToMainMenuBuilderController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BuilderLevelSelect extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;

	/**
	 * Create the Main Menu Panel.
	 */

	public BuilderLevelSelect(Builder builder, TopLevelApplicationBuilder app) {
		
		this.builder = builder;
		this.app = app;

		// Create the background canvas ** important
		JLabelIcon background = new JLabelIcon("BuilderLevelSelect_New.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		// Create an array of JLabelIcon for the buttons
		JLabelIcon[] levelselectbtn = new JLabelIcon[15];
		
		// Create an array of JLabels for the buttons
		JLabel[] buttonlbl = new JLabel[15];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				levelselectbtn[i * 5 + j] = new JLabelIcon("generalbutton.png", 70, 70);
				// set location relative to background
				int lvlbtnw = (int) levelselectbtn[i * 5 + j].getSize().getWidth();
				int lvlbtnh = (int) levelselectbtn[i * 5 + j].getSize().getHeight();
				levelselectbtn[i * 5 + j].setLocation((int) (Screen.width / 6 * (j + 1) - lvlbtnw/2),
						(int) (Screen.height / 12 * (i * 2 + 4) - lvlbtnh/2));
				buttonlbl[i * 5 + j] = new JLabel("<html>Select<br>" + "Level " + (i * 5 + j + 1) + "</html>",
						SwingConstants.CENTER);
				buttonlbl[i * 5 + j].setBounds(0, 0, 70, 70);
				buttonlbl[i * 5 + j].setFont(new Font("Onyx", Font.BOLD, 18));
				levelselectbtn[i * 5 + j].add(buttonlbl[i * 5 + j]);
				//TODO : levelselectbtn[i * 5 + j].addMouseListener(
						//new BuilderSelectLevelController(builder, app, levelselectbtn[i * 5 + j], i * 5 + j + 1));
				background.add(levelselectbtn[i * 5 + j]);
			}
		}
		
		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
		mainmenubtn.addMouseListener(new GoToMainMenuBuilderController(builder, app, mainmenubtn));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		background.add(mainmenubtn);
	}
	
}
