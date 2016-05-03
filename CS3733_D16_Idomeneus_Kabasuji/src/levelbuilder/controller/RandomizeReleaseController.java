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

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	BuilderReleaseBoardView releaseLevelPanel;
	JLabelIcon tile;

	String fn;

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
	 */
	public void mousePressed(MouseEvent me) {
		if(!builder.addRandomRelease())
		{
			// Add a dialog box to warn the user 
			ErrorDialogBox.infoBox("Not enough valid tiles to build a release level :(", "Invalid Input");
		}
		app.repaint();
		releaseLevelPanel.updateBoard();
	}
	public void mouseEntered(MouseEvent e) {
			tile.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
			tile.setImg(fn);
	}
}
