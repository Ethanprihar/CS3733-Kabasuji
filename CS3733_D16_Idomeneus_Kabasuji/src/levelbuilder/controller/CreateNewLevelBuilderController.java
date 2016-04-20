package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.TopLevelApplication;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderLevelMode;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Creating a New Level; Go To Level Mode Select Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class CreateNewLevelBuilderController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;
	JLabelIcon button;

	public CreateNewLevelBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.LevelSelect);
		// Attempt to execute action on model
		gtsm.execute(builder);
		// Created JPanel screen object and update boundary to reflect changes
		BuilderLevelMode lsp = new BuilderLevelMode(builder, app);
		app.setContentPanel(lsp);
	}
	
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg("generalbutton.png");
	}
}
