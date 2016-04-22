package levelbuilder.view;

import javax.swing.JPanel;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.LoadLevelsBuilderController;
import levelbuilder.controller.CreateNewLevelBuilderController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BuilderMainMenu extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;

	/**
	 * Create the Main Menu Panel.
	 */

	public BuilderMainMenu(Builder builder, TopLevelApplicationBuilder app) {
		
		this.builder = builder;
		this.app = app;

		// Create the background canvas ** important
		JLabelIcon background = new JLabelIcon("BuilderTitleScreen.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		// Create an array of JLabelIcon for the buttons
		JLabelIcon[] buildermainbtn = new JLabelIcon[2];
		
		// Create an array of JLabels for the buttons
		JLabel[] buildermainlbl = new JLabel[2];
		
		// This loop will position buttons, create labels for them, add labels to the buttons at the right position and also add buttons to the background
		for (int i = 0; i < 2; i++){
			buildermainbtn[i] = new JLabelIcon("generalbutton.png", 70, 70);
			buildermainbtn[i].setLocation(
					(int) (Screen.width - buildermainbtn[i].getSize().getWidth())/2,
					(int) (Screen.height + (i*3) *buildermainbtn[i].getSize().getWidth())/2);
			
			String lbl = new String("Build");
			if (i == 1){
				lbl = "Load";
			}
			buildermainlbl[i] = new JLabel("<html>" + lbl + "<br>" + "Level " + "</html>",
					SwingConstants.CENTER);
			buildermainlbl[i].setBounds(0,0,(int)(buildermainbtn[i].getSize().getWidth()),(int)(buildermainbtn[i].getSize().getHeight()));	
			buildermainlbl[i].setFont(new Font("Onyx", Font.BOLD, 18));
			buildermainbtn[i].add(buildermainlbl[i]);
			background.add(buildermainbtn[i]);
		}
		
		// Create a mouse listener for the build level button
		buildermainbtn[0].addMouseListener(new CreateNewLevelBuilderController(builder, app, buildermainbtn[0]));
		
		// Create a mouse listener for the load level button
		buildermainbtn[1].addMouseListener(new LoadLevelsBuilderController(builder, app, buildermainbtn[1]));
	}
	
}
