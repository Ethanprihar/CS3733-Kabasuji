package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Screen;
import kabasuji.model.Tile;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.controller.moves.LevelModeBuilderMove;
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
 * @author jwu
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
		// Created SelectLevelMove and input desired level integer
		//Tile[][] tile = builder.levels.get(level-1).getBoard().getTiles();
		//LevelModeBuilderMove slm = new LevelModeBuilderMove(level%3, tile.length);
		// Created ChangeScreenMove and input desired screen
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.LevelSelect);
		
		
		builder.loadLevel(builder.levels.get(level-1));
		System.out.println("Worked!");
		
		//builder.setSelectedLevel(kabasuji.levels.get(level-1));
		// Attempt to execute action on model
		
		gtsm.execute(builder);

		int levelType = (level-1)%3;
		
		JTextField nothing = new JTextField("6");
		
		if (levelType == 0){
			System.out.println("Editing a puzzle level");
			// Create the new level
			//String boardDimensionstext = boardDimensions.getText();
			//int dimensions = Integer.parseInt(boardDimensionstext);
			//builder.addNewLevel(0, dimensions);
			
			BuilderPuzzleLevelPanel lsp = new BuilderPuzzleLevelPanel(builder, app, nothing);
			//builder.getSelectedLevel();
			app.setContentPanel(lsp);
			//builder.getSelectedLevel().getBoard();
		}
		
		// Create a lightning level panel if the level type is 1
		if (levelType == 1){
			
			BuilderLightningLevelPanel lsp = new BuilderLightningLevelPanel(builder, app, nothing);
			//builder.getSelectedLevel();
			app.setContentPanel(lsp);
			// Create the new level
			//String boardDimensionstext = boardDimensions.getText();
			//int dimensions = Integer.parseInt(boardDimensionstext);
			//builder.addNewLevel(1, dimensions);
			
			//BuilderLightningLevelPanel lsp = new BuilderLightningLevelPanel(builder, app, boardDimensions);
			//app.setContentPanel(lsp);
		}
		
		// Create a release level panel if the level type is 2
		if (levelType == 2){
			
			BuilderReleaseLevelPanel lsp = new BuilderReleaseLevelPanel(builder, app);
			//builder.getSelectedLevel();
			app.setContentPanel(lsp);
		}
			//gtsm.execute(builder);
			
			// Create PlayLevelPanel screen object and update boundary to
			// reflect *** GUI CHANGES ***

			// first make the foundation panel and pass model and container
			// panel
//			PlayLevelPanel plp = new PlayLevelPanel(builder, app);
//
//			// create components of panel and pass model and container panel
//			BullpenView bpv = new BullpenView(builder, plp, 3, 5);
//			BoardView bv = new BoardView(builder, plp);
//
//			// set location and size of components (**necessary)
//			bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
//					(int) (Screen.height * 0.54));
//			bpv.setBounds((int) (Screen.width * 0.05), (int) (Screen.height * 0.05), (int) (Screen.width * 0.25),
//					(int) (Screen.height * 0.85));
//
//			// remove all components from PLP -> update PLP -> add controllers
//			plp.removeAll();
//			plp.updatePlayLevelPanel(bv, bpv);
//			plp.addControllers();
//
//			// repaint the PlayLevelPanel
//			plp.repaint();

			// set the contentpanel of container to contain PlayLevelPanel
			//app.setContentPanel(plp);
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
