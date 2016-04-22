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

	/** Entity and Boundaries Associated **/
	Kabasuji kabasuji;
	Bullpen bullpen;
	BullpenView bullpenview;
	JLabelIcon pieceicon;
	PlayLevelPanel panel;
	PieceView[] pieceviews;
	ArrayList<Piece> pieces;

	JLabelIcon zoompanel;
	String fnzoom;
	String fnpiece;
	Piece selectedPiece;

	boolean right;

	public FlipSelectedPieceBullpenController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon pieceicon,
			boolean right) {
		this.kabasuji = kabasuji;
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.selectedPiece = bullpen.getSelectedPiece();
		this.panel = panel;
		this.right = right;
		this.bullpenview = panel.getBullpenView();
		this.pieceviews = bullpenview.getPieceView();
		this.pieceicon = pieceicon;
		this.zoompanel = panel.getZoomPiece();
		this.pieceicon = pieceicon;
		this.fnpiece = pieceicon.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		if (selectedPiece != null) {
			FlipPieceMove fpm = new FlipPieceMove(selectedPiece, right);
			fpm.execute(kabasuji);
			zoompanel.removeAll();
			selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
			PieceView pieceview = new PieceView(selectedPiece);
			pieceview.setBounds(0, 0, (int) zoompanel.getSize().getWidth(), (int) zoompanel.getSize().getHeight());
			pieceview.setupPiece();
			zoompanel.add(pieceview);
			zoompanel.repaint();
		}
	}

	public void mouseEntered(MouseEvent e) {
		pieceicon.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		pieceicon.setImg(fnpiece);
	}

}
