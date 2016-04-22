package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for saving a level; saves level then goes To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to save the level and go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 *
 */
public class SaveLevelController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;	
	JLabelIcon button;	
	String fn;


	public SaveLevelController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.button = button;
		this.fn = button.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		builder.saveLevel();
		builder.saveToDisc();
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
		// Attempt to execute action on model
		gtsm.execute(builder);
		// Created JPanel screen object and update boundary to reflect changes
		BuilderMainMenu lsp = new BuilderMainMenu(builder, app);
		app.setContentPanel(lsp);
	}
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
