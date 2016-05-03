package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import kabasuji.model.Builder;
import kabasuji.view.JLabelIcon;
import levelbuilder.view.BuilderReleaseBoardView;
import levelbuilder.view.ErrorDialogBox;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When the randomize button is pressed, we randomize the release tiles throughout the level.
 * 
 * @author Odell Dotson
 *
 */
public class RandomizeReleaseController extends MouseAdapter {

	/** The builder entity class */
	Builder builder;
	
	/** The top level application */
	TopLevelApplicationBuilder app;
	
	/** The builder release boardview */
	BuilderReleaseBoardView releaseLevelPanel;
	
	/** The JLabelIcon for the tile */
	JLabelIcon tile;

	/** String image file name */
	String fn;

	/**
	 * Constructor for this class
	 * @param builder The builder entity class
	 * @param releaseLevelPanel The builder release board view
	 * @param app The top level application
	 * @param tile The JLabel icon for the tile to click on
	 */
	public RandomizeReleaseController(Builder builder, BuilderReleaseBoardView releaseLevelPanel, TopLevelApplicationBuilder app, JLabelIcon tile) {
		this.app = app;
		this.builder = builder;
		this.releaseLevelPanel = releaseLevelPanel;
		this.tile = tile;
		this.fn = tile.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to call the randomizer function.
	 * If it is unable, it returns false and we display a dialogue box.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		if(!builder.addRandomRelease())
		{
			// Add a dialog box to warn the user 
			ErrorDialogBox.infoBox("Not enough valid tiles to build a release level :(", "Can't do it :(");
		}
		app.repaint();
		releaseLevelPanel.updateBoard();
	}
	
	/**
	 * Whenever mouse is hovered over the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e) {
			tile.setImg("generalhoverbutton.png");
	}

	/**
	 * Whenever mouse is exited after hovering on the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {
			tile.setImg(fn);
	}
}
