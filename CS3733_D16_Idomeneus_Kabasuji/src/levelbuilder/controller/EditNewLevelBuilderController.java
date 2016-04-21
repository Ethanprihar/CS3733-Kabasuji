package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.controller.moves.LevelModeBuilderMove;
import levelbuilder.view.BuilderLightningLevelPanel;
import levelbuilder.view.BuilderPuzzleLevelPanel;
import levelbuilder.view.BuilderReleaseLevelPanel;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Creating a New Level; Go To Level Mode Select Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author vkr
 *
 */
public class EditNewLevelBuilderController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;
	JLabelIcon button;
	int levelType;
	JTextField boardDimensions;

	public EditNewLevelBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, int levelType, JTextField boardDimensions) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
		this.levelType = levelType;
		this.boardDimensions = boardDimensions;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		LevelModeBuilderMove slm = new LevelModeBuilderMove(levelType, boardDimensions);
		// Created ChangeScreenBuilderMove and input desired screen
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.LevelSelect);
		
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
				BuilderLightningLevelPanel lsp = new BuilderLightningLevelPanel(builder, app);
				app.setContentPanel(lsp);
			}
			
			// Create a release level panel if the level type is 2
			if (levelType == 2){
				BuilderReleaseLevelPanel lsp = new BuilderReleaseLevelPanel(builder, app);
				app.setContentPanel(lsp);
			}
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg("generalbutton.png");
	}
}
