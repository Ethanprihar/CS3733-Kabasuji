package kabasuji.controller;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Board;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import kabasuji.view.MainMenu;
import kabasuji.view.TopLevelApplication;

/**
 * Controller for Board gameplay; Modify BoardView;
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
		tile.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		tile.setImg(fn);
	}
}
