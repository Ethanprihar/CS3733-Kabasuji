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
 * Controller for Rotating Piece in bullpen; rotates piece then displays it in
 * zoom Panel.
 * 
 * When the button is pressed to attempt to rotate piece, the model will update
 * the selected piece and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class RotateSelectedPieceBullpenController extends MouseAdapter {

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

	boolean vertical;

	/**
	 * Constructor for RotateSelectedPieceBullpenController.
	 * @param kabasuji
	 * @param panel
	 * @param pieceicon button view object associated
	 * @param vertical flip direction
	 */
	public RotateSelectedPieceBullpenController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon pieceicon,
			boolean vertical) {
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
		this.vertical = vertical;
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
		RotatePieceMove fpm = new RotatePieceMove(selectedPiece, vertical);
		fpm.execute(kabasuji);
		zoompanel.removeAll();
		zoompanel.displayPieceView(selectedPiece);
	}
	/**
	 * Mouse Enter highlights button.
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
