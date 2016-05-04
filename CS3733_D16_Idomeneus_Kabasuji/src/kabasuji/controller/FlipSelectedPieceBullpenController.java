package kabasuji.controller;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.FlipPieceMove;
import kabasuji.controller.moves.RotatePieceMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.controller.moves.SelectPieceMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.Screen;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.PieceView;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import kabasuji.view.ZoomPanel;

/**
 * Controller for Flipping Piece in bullpen; flips piece then displays it in
 * zoom Panel.
 * 
 * When the button is pressed to attempt to flip piece, the model will update
 * the selected piece and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class FlipSelectedPieceBullpenController extends MouseAdapter {

	/* Top Level Model */
	Kabasuji kabasuji;
	/* Bullpen */
	Bullpen bullpen;
	/* Pieces Array in Bullpen */
	ArrayList<Piece> pieces;
	/* Select piece */
	Piece selectedPiece;
	/* Screen view */
	PlayLevelPanel panel;
	/* Bullpen view */
	BullpenView bullpenview;
	/* Piece view in bullpen */
	JLabelIcon pieceicon;
	/* Piece View Array */
	PieceView[] pieceviews;
	/* Zoom Panel */
	ZoomPanel zoompanel;
	/* file name of zoomPanel */
	String fnzoompiece;

	boolean right;

	/**
	 * Constructor for FlipSelectedPieceBullpenController.
	 * 
	 * @param kabasuji
	 * @param panel
	 * @param pieceicon
	 *            the piece view object associated
	 * @param right
	 *            the direction of flip
	 */
	public FlipSelectedPieceBullpenController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon pieceicon,
			boolean right) {
		this.kabasuji = kabasuji;
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.selectedPiece = bullpen.getSelectedPiece();
		this.panel = panel;
		this.bullpenview = panel.getBullpenView();
		this.pieceviews = bullpenview.getPieceView();
		this.zoompanel = panel.getZoomPanel();
		// handles the original image details
		this.pieceicon = pieceicon;
		this.fnzoompiece = pieceicon.getFileName();
		// turning direction
		this.right = right;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		if (kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() == null) {
			selectedPiece = kabasuji.getSelectedLevel().getBoard().getSelectedPiece();
		}
		FlipPieceMove fpm = new FlipPieceMove(selectedPiece, right);
		fpm.execute(kabasuji);
		zoompanel.removeAll();
		zoompanel.displayPieceView(selectedPiece);
	}

	/**
	 * Mouse Enter highlights the button.
	 */
	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		pieceicon.setImg("generalhoverbutton.png");
	}

	/**
	 * Mouse Exit dehighlights the button.
	 */
	public void mouseExited(MouseEvent e) {
		// sets image back to original
		pieceicon.setImg(fnzoompiece);
	}

}
