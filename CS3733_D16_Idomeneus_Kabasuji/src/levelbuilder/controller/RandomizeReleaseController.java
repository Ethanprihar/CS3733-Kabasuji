package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.view.JLabelIcon;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author Odell Dotson
 *
 */
public class RandomizeReleaseController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	Board board;
	JLabelIcon tile;

	String fn;

	public RandomizeReleaseController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon tile) {
		this.app = app;
		this.builder = builder;
		this.tile = tile;
		this.fn = tile.getFileName();

	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		builder.addRandomRelease();
		app.repaint();
	}
	public void mouseEntered(MouseEvent e) {
			tile.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
			tile.setImg(fn);
	}
}
