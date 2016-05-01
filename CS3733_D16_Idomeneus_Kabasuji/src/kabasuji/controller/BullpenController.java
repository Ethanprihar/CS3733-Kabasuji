package kabasuji.controller;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleLevel;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PlayLevelPanel;

/**
 * Controller for Bullpen gameplay; Modify BullpenView.
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author jwu
 *
 */
public class BullpenController extends MouseAdapter {

	/** Entity associated **/
	Kabasuji kabasuji;
	Board board;
	Bullpen bullpen;
	Piece selectedPiece;
	
	/** Boundaries associated **/
	PlayLevelPanel plp;
	BullpenView bullpenview;

	public BullpenController(Kabasuji kabasuji, PlayLevelPanel plp) {
		this.kabasuji = kabasuji;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.plp = plp;
		this.bullpenview = plp.getBullpenView();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// get piece from board
		selectedPiece = board.getSelectedPiece();
		// board must have a piece and must be puzzle level
		if(board.getSelectedPiece() != null && (kabasuji.getSelectedLevel() instanceof PuzzleLevel)){
			// move selectedPiece from board to bullpen
			board.removePiece(selectedPiece);
			bullpen.addPiece(selectedPiece);
			// update board to have no piece
			board.selectPiece(null);
			// update bullpen to show the selectedPiece and remove from zoompanel
			bullpenview.setupBullpen();
			plp.clearZoomPiece();
		}
	}
	public void mouseEntered(MouseEvent e) {	
	}

	public void mouseExited(MouseEvent e) {
	}
}
