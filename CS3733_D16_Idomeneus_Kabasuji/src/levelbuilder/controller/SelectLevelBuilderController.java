package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.LightningBoard;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.ReleaseBoard;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderLightningLevelPanel;
import levelbuilder.view.BuilderPuzzleLevelPanel;
import levelbuilder.view.BuilderReleaseLevelPanel;
import levelbuilder.view.TopLevelApplicationBuilder;
import kabasuji.model.Builder;

/**
 * Controller for Moving Screens; Go To Play Level Screen (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author ocd
 *
 */
public class SelectLevelBuilderController extends MouseAdapter {

	/** Entities associated **/
	Builder builder;
	int level;
	/** Boundaries associated **/
	TopLevelApplicationBuilder app;
	JPanel contentPanel;
	JLabelIcon button;
	String fn;

	public SelectLevelBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, int level) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
		this.fn = button.getFileName();
		this.level = level;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		/*** MODEL CHANGES ***/
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.LevelSelect);
		
		
		builder.loadLevel(builder.levels.get(level-1));

		gtsm.execute(builder);

		//Determine the level type, 0 1 or 2. -1 if invalid type.
		int levelType;
		levelType = (builder.getSelectedLevel().getBoard() instanceof PuzzleBoard) ? 0 : 
						(builder.getSelectedLevel().getBoard() instanceof LightningBoard) ? 1 :
							(builder.getSelectedLevel().getBoard() instanceof ReleaseBoard) ? 2 : -1;
		
		JTextField nothing = new JTextField("6");//Created for compliation reasons, does nothing.
		
		if (levelType == 0){
			System.out.println("Editing a puzzle level");
			BuilderPuzzleLevelPanel lsp = new BuilderPuzzleLevelPanel(builder, app, nothing);
			app.setContentPanel(lsp);
		}
		
		// Create a lightning level panel if the level type is 1
		if (levelType == 1){
			System.out.println("Editing a Lightning level");
			BuilderLightningLevelPanel lsp = new BuilderLightningLevelPanel(builder, app, nothing);
			app.setContentPanel(lsp);
		}
		
		// Create a release level panel if the level type is 2
		if (levelType == 2){
			System.out.println("Editing a Release level");
			BuilderReleaseLevelPanel lsp = new BuilderReleaseLevelPanel(builder, app, nothing);
			app.setContentPanel(lsp);
		}	
	}

	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		// sets image back to original
		button.setImg(fn);
	}
}
