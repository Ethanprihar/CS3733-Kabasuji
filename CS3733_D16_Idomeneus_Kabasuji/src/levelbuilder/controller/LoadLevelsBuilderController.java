package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderLevelSelect;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for loading the level select panel. By clicking on the load level button
 * the level select screen appears where you can edit the levels.
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author Vishal Rathi
 *
 */
public class LoadLevelsBuilderController extends MouseAdapter {

	/** Builder entity class */
	Builder builder;
	
	/** Top level application boundary class */
	TopLevelApplicationBuilder app;
	
	/** Current JPanel for the boaundary class */
	JPanel contentPanel;
	
	/** JButton for the load levels */
	JLabelIcon button;

	/**
	 * Constructor for the class
	 * @param builder The builder entity class
	 * @param app The top level application boundary class
	 * @param button The button to click for loading levels
	 */
	public LoadLevelsBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
	}

	/**
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
		// Attempt to execute action on model
		gtsm.execute(builder);
		// Created JPanel screen object and update boundary to reflect changes
		BuilderLevelSelect lsp = new BuilderLevelSelect(builder, app);
		app.setContentPanel(lsp);
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



