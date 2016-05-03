package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.controller.moves.LevelModeBuilderMove;
import levelbuilder.view.BuilderLightningLevelPanel;
import levelbuilder.view.BuilderPuzzleLevelPanel;
import levelbuilder.view.BuilderReleaseLevelPanel;
import levelbuilder.view.ErrorDialogBox;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for going to the specific type of level for building. You need to enter the board dimensions and 
 * select the level type (puzzle, lightning, release). Also, you can go back to the main menu.
 * 
 * When the button is pressed to attempt to buid the level and go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author Vishal Rathi
 *
 */
public class EditNewLevelBuilderController extends MouseAdapter {

	/** The builder entity class */
	Builder builder;
	
	/** The top level boundary class */
	TopLevelApplicationBuilder app;
	
	/** The JPanel for the boundary class */
	JPanel contentPanel;
	
	/** The button to go to the level building screen */
	JLabelIcon button;
	
	/** Flag for the level type; 0 for puzzle, 1 for lightning and 2 for the release level */
	int levelType;
	
	/** The textfield to get the board dimensions specified */
	JTextField boardDimensions;

	/**
	 * The constructor for the controller
	 * @param builder The builder entity class
	 * @param app The top level application boundary class
	 * @param button The button to go the level building screen
	 * @param levelType The level type
	 * @param boardDimensions The board dimensions the player wants
	 */
	public EditNewLevelBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, int levelType, JTextField boardDimensions) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
		this.levelType = levelType;
		this.boardDimensions = boardDimensions;
	}

	/**
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		LevelModeBuilderMove slm = new LevelModeBuilderMove(levelType, boardDimensions);
		// Created ChangeScreenBuilderMove and input desired screen
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.LevelSelect);
		
		// If the move was valid, execute this loop
		if (slm.execute(builder)) {
			gtsm.execute(builder);
			// Created JPanel screen object and update boundary to reflect changes
			
			// Create a release level panel if the level type is 0
			if (levelType == 0){
				// Create the new level
				String boardDimensionstext = boardDimensions.getText();
				int dimensions = Integer.parseInt(boardDimensionstext);
				builder.addNewLevel(0, dimensions);
				BuilderPuzzleLevelPanel lsp = new BuilderPuzzleLevelPanel(builder, app, boardDimensions);
				app.setContentPanel(lsp);
			}
			
			// Create a lightning level panel if the level type is 1
			if (levelType == 1){
				// Create the new level
				String boardDimensionstext = boardDimensions.getText();
				int dimensions = Integer.parseInt(boardDimensionstext);
				builder.addNewLevel(1, dimensions);
				BuilderLightningLevelPanel lsp = new BuilderLightningLevelPanel(builder, app, boardDimensions);
				app.setContentPanel(lsp);
			}
			
			// Create a release level panel if the level type is 2
			if (levelType == 2){
				//Create the new level
				String boardDimensionstext = boardDimensions.getText();
				int dimensions = Integer.parseInt(boardDimensionstext);
				builder.addNewLevel(2, dimensions);
				BuilderReleaseLevelPanel lsp = new BuilderReleaseLevelPanel(builder, app, boardDimensions);
				app.setContentPanel(lsp);
			}
		}
		
		// If the move was not valid, open a dialog box to display the message
		else {
			ErrorDialogBox.infoBox("The dimension entered must be between 3 and 12 inclusive", "Invalid Input");
		}
	}
	
	/**
	 * Whenever mouse is hovered over the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	/**
	 * Whenever mouse is exited after hovering on the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {
		button.setImg("generalbutton.png");
	}
}
