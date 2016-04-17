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
import levelbuilder.view.BuilderPuzzleLevelPanel;
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
		this.contentPanel = app.getContentPane();
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
			if (levelType == 0){
				BuilderPuzzleLevelPanel lsp = new BuilderPuzzleLevelPanel(builder, app);
				app.changeContentPane(lsp);
			}
			
			//TODO: Create panels for the lightning and release screen
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg("generalbutton.png");
	}
}
