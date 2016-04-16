package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BuilderLevelMode extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;

	/**
	 * Create the Main Menu Panel.
	 */

	public BuilderLevelMode(Builder builder, TopLevelApplicationBuilder app) {
		
		this.builder = builder;
		this.app = app;

		// Create the background canvas ** important
		JLabelIcon background = new JLabelIcon("BuilderLevelMode_New.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		// Create an array of JLabelIcon for the buttons
		JLabelIcon[] buildermainbtn = new JLabelIcon[3];
		
		// Create an array of JLabels for the buttons
		JLabel[] buildermainlbl = new JLabel[3];
				
		// This loop will position buttons, create labels for them, add labels to the buttons at the right position and also add buttons to the background
		for (int i = 0; i < 3; i++){
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
			background.add(buildermainbtn[i]);
		}
		
		// Create a text field for the board dimensions
		JTextField boardDimensions = new JTextField();
		boardDimensions.setBounds((int)(Screen.width - boardDimensions.getSize().getWidth())/2 - 70, (int)(Screen.height/2 + boardDimensions.getSize().getWidth() - 20), 70, 20);
		background.add(boardDimensions);
		
		// Create a mouse listener for the build level button
		//buildermainbtn[0].addMouseListener(new CreateNewLevelBuilderController(builder, app, buildermainbtn[0]));
	}
	
}
