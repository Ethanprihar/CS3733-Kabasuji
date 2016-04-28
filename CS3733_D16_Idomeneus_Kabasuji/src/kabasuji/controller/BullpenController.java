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

	/** Entity and Boundaries Associated **/
	Kabasuji kabasuji;
	Board board;
	Bullpen bullpen;
	
	PlayLevelPanel panel;
	BullpenView bullpenview;
	Piece selectedPiece;
	JLabelIcon tile;
	String fn;
	JLabelIcon zoompiece;

	public BullpenController(Kabasuji kabasuji, PlayLevelPanel panel) {
		this.kabasuji = kabasuji;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.panel = panel;
		this.bullpenview = panel.getBullpenView();
		this.zoompiece = panel.getZoomPiece();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		selectedPiece = board.getSelectedPiece();
		if(board.getSelectedPiece() != null && (kabasuji.getSelectedLevel() instanceof PuzzleLevel)){
			board.removePiece(selectedPiece);
			bullpen.addPiece(selectedPiece);
			board.selectPiece(null);
			bullpenview.setupBullpen();
			zoompiece.removeAll();
			zoompiece.repaint();
			
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		
		
	}

	public void mouseExited(MouseEvent e) {
	}
}
