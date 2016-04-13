package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenBuilderMove;
import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.BuilderLevelMode;
import kabasuji.view.BuilderMainMenu;
import kabasuji.view.BuilderPuzzleLevelPanel;
import kabasuji.view.LevelSelect;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.TopLevelApplication;
import kabasuji.view.TopLevelApplicationBuilder;

/**
 * Controller for Moving Screens; Go To Level Select Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class SelectLevelModeBuilderController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	int levelType;
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;

	public SelectLevelModeBuilderController(Builder builder, TopLevelApplicationBuilder app, int levelType) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPane();
		this.levelType = levelType;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {

		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.LevelSelect);
		gtsm.execute(builder);
		BuilderPuzzleLevelPanel lpm = new BuilderPuzzleLevelPanel(builder, app);
		app.changeContentPane(lpm);
	}
}
