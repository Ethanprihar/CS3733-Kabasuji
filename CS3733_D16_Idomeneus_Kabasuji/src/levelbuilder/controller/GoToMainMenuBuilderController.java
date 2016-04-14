package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.BuilderMainMenu;
import kabasuji.view.LevelSelect;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.TopLevelApplication;
import kabasuji.view.TopLevelApplicationBuilder;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;

/**
 * Controller for Moving Screens; Go To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class GoToMainMenuBuilderController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;

	public GoToMainMenuBuilderController(Builder builder, TopLevelApplicationBuilder app) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPane();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
		// Attempt to execute action on model
		gtsm.execute(builder);
		// Created JPanel screen object and update boundary to reflect changes
		BuilderMainMenu lsp = new BuilderMainMenu(builder, app);
		app.changeContentPane(lsp);
	}
}
