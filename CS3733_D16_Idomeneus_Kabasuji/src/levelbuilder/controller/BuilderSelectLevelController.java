package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderLevelSelect;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Moving Screens; Go To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class BuilderSelectLevelController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;
	JLabelIcon button;

	public BuilderSelectLevelController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPane();
		this.button = button;
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
		BuilderLevelSelect lsp = new BuilderLevelSelect(builder, app);
		app.changeContentPane(lsp);
	}
	
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg("generalbutton.png");
	}
}
