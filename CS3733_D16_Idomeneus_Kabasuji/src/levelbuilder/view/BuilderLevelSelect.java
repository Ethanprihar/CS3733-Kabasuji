package levelbuilder.view;

import javax.swing.JPanel;
import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.SelectLevelBuilderController;
import levelbuilder.controller.GoToMainMenuBuilderController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BuilderLevelSelect extends JPanel {
	/**The builder*/
	Builder builder;
	/**The top level application*/
	TopLevelApplicationBuilder app;


	/** Level Button GUI elements **/
	JLabelIcon[] levelselectbtn;
	/**The button labels*/
	JLabel[] buttonlbl;
	/**main menu button*/
	JLabelIcon mainmenubtn;

	/** dimensions of level button array */
	int row;
	/**column dimension of level button array */
	int col;

	/**
	 * Builds a builder level select for viewing.
	 * @param builder the builer to get the levels for
	 * @param app the application to get levels from 
	 */
	public BuilderLevelSelect(Builder builder, TopLevelApplicationBuilder app) {
		
		this.builder = builder;
		this.app = app;
		this.levelselectbtn = new JLabelIcon[builder.getLevels().size()];
		this.buttonlbl = new JLabel[builder.getLevels().size()];
		
		// set layout to null
		setLayout(null);

		// temporary row and col setup ***********
		row = 5;
		col = 3;

		// Create the background canvas ** important
		JLabelIcon background = new JLabelIcon("BuilderLevelSelect_New.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		// Create an array of JLabelIcon for the buttons
		//JLabelIcon[] levelselectbtn = new JLabelIcon[15];
		
		// Create an array of JLabels for the buttons
		//JLabel[] buttonlbl = new JLabel[15];
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				
				try{
				
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
					levelselectbtn[i * 5 + j].addMouseListener(
							new SelectLevelBuilderController(builder, app, levelselectbtn[i * 5 + j], i * 5 + j + 1));
					background.add(levelselectbtn[i * 5 + j]);
				}
				
				catch (IndexOutOfBoundsException e) {
					System.out.println("Level Out of Bounds");
				}
			}
		}
		
		mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
		mainmenubtn.addMouseListener(new GoToMainMenuBuilderController(builder, app, mainmenubtn));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		background.add(mainmenubtn);
	}
	
	/**
	 * gets the main menu button
	 * @return main menu button
	 */
	public JLabelIcon getMainMenuButton() {
		return mainmenubtn;
	}
	
	/**
	 * Gets the level select button
	 * @param i Level to select button of
	 * @return the level selected button
	 */
	public JLabelIcon getLevelSelectButton(int i) {
		if((i >= 0) && (i < builder.getLevels().size())) {
			return levelselectbtn[i];
		}
		else {
			System.out.println("Level Select Index out of bounds");
			return levelselectbtn[0];
		}
	}
	
}
