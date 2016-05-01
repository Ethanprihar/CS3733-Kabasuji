package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import kabasuji.controller.moves.SelectPieceMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PieceView;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.ZoomPanel;

/**
 * Controller for Selecting Piece in bullpen; Selects piece then displays it in zoom Panel.
 * 
 * When the button is pressed to attempt to select piece, the model
 * will update the selected piece and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class SelectPieceBullpenController extends MouseAdapter {

	/** Entities associated **/
	Kabasuji kabasuji;
	Bullpen bullpen;
	ArrayList<Piece> pieces;
	Piece selectedPiece;
	
	int numPiece;
	
	/** Boundaries associated **/
	
	PlayLevelPanel panel;
	BullpenView bullpenview;
	ZoomPanel zoompanel;
	JLabelIcon pieceicon;
	PieceView[] pieceviews;
	String fnzoom;
	String fnpiece;


	public SelectPieceBullpenController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon pieceicon, int numPiece) {
		this.kabasuji = kabasuji;
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.panel = panel;
		this.bullpenview = panel.getBullpenView();
		this.pieceviews = bullpenview.getPieceView();
		this.pieceicon = pieceicon;
		this.zoompanel = panel.getZoomPiece();
		this.fnzoom = zoompanel.getFileName();
		this.fnpiece = pieceicon.getFileName();
		this.numPiece = numPiece;
		this.selectedPiece = kabasuji.getSelectedLevel().getBullpen().getPieces().get(numPiece);
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// selecting piece toggle
		if (bullpen.getSelectedPiece() == null) {
			SelectPieceMove spm = new SelectPieceMove(selectedPiece);
			spm.execute(kabasuji);
			pieceicon.setImg("generalhoverbutton.png");
		} else if (bullpen.getSelectedPiece() == selectedPiece) {
			SelectPieceMove spm = new SelectPieceMove(null);
			spm.execute(kabasuji);
			pieceicon.setImg(fnpiece);
		}
	}

	public void mouseEntered(MouseEvent e) {
		// displays enlarged piece on zoom panel upon entering
		if (bullpen.getSelectedPiece() == null) {
			// update zoompanel to show selectedPiece
			zoompanel.displayPieceView(selectedPiece);
		}

	}

	public void mouseExited(MouseEvent e) {
		// sets the panel back to empty if no piece is selected before leaving image
		if (bullpen.getSelectedPiece() == null) {
			zoompanel.setImg("opaque_canvas.png");
		}
	}
}
