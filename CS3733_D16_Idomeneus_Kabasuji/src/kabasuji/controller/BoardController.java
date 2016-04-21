package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.model.Board;
import kabasuji.view.JLabelIcon;

/**
 * Controller for Board gameplay; Modify BoardView.
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author jwu
 *
 */
public class BoardController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Board board;
	JLabelIcon tile;
	String fn;

	public BoardController(Board board, JLabelIcon tile) {
		this.board=  board;
		this.tile = tile;
		this.fn = tile.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {

	}
	
	public void mouseEntered(MouseEvent e) {
		
		
	}

	public void mouseExited(MouseEvent e) {
		tile.setImg(fn);
	}
}
