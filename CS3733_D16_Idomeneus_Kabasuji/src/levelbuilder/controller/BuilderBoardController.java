package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.model.Board;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author vkr
 *
 */
public class BuilderBoardController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Board board;
	JLabelIcon tile;
	String fn;
	Tile currentTile;
	boolean selected;

	public BuilderBoardController(Board board, JLabelIcon tile, Tile currentTile) {
		this.board=  board;
		this.tile = tile;
		this.currentTile = currentTile;
		this.fn = tile.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		selected = true;
		if (selected){
			tile.setImg("generalhoverbutton.png");
			
			// Give the information to the model class about the valid tile
			currentTile.setValid(true);
		}
	}
	public void mouseEntered(MouseEvent e) {
		tile.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		if (!selected){
			tile.setImg(fn);
		}
	}
}
