package levelbuilder.view;

import javax.swing.JPanel;
import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
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
		JLabelIcon background = new JLabelIcon("BuilderLevelSelect.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		// Create an array of JLabelIcon for the buttons
		JLabelIcon[] levelselectbtn = new JLabelIcon[15];
		
		// Create an array of JLabels for the buttons
		JLabel[] buttonlbl = new JLabel[15];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
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
				
		// This loop will position buttons, create labels for them, add labels to the buttons at the right position and also add buttons to the background
		/*for (int i = 0; i < 3; i++){
			buildermainbtn[i] = new JLabelIcon("generalbutton.png", 70, 70);
			buildermainbtn[i].setLocation(
					(int) (Screen.width + ((i*3 - buildermainbtn[i].getSize().getWidth()/5 - 2)*buildermainbtn[i].getSize().getWidth())/2),
					(int) (Screen.height + 3*buildermainbtn[i].getSize().getWidth())/2);
			
			String lbl = new String("Puzzle");
			if (i == 1){
				lbl = "Lightning";
			}
			else if (i == 2){
				lbl = "Release";
			}
			buildermainlbl[i] = new JLabel(lbl, SwingConstants.CENTER);
			buildermainlbl[i].setBounds(0,0,(int)(buildermainbtn[i].getSize().getWidth()),(int)(buildermainbtn[i].getSize().getHeight()));	
			buildermainlbl[i].setFont(new Font("Onyx", Font.BOLD, 18));
			buildermainbtn[i].add(buildermainlbl[i]);
			
			// Create a mouse listener for the buttons and the board dimensions
			buildermainbtn[i].addMouseListener(new EditNewLevelBuilderController(builder, app, buildermainbtn[i], i, boardDimensions));
			background.add(buildermainbtn[i]);*/
		}
		
		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
		//TODO : mainmenubtn.addMouseListener(new GoToMainMenuBuilderController(builder, app, mainmenubtn));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		background.add(mainmenubtn);
	}
	
}
