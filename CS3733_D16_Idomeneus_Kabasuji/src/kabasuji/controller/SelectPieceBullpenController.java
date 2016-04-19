package kabasuji.controller;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
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
 * Controller for Moving Screens; Go To Play Level Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class SelectPieceBullpenController extends MouseAdapter {

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

	int numPiece;

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
		if (bullpen.getSelectedPiece() == null) {
			SelectPieceMove spm = new SelectPieceMove(selectedPiece);
			spm.execute(kabasuji);
			pieceicon.setImg("generalhoverbutton.png");
		} else {
			SelectPieceMove spm = new SelectPieceMove(null);
			spm.execute(kabasuji);
			pieceicon.setImg(fnpiece);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (bullpen.getSelectedPiece() == null) {
			zoompanel.removeAll();
			PieceView pieceview = new PieceView(selectedPiece);
			pieceview.setBounds(0, 0, (int) zoompanel.getSize().getWidth(), (int) zoompanel.getSize().getHeight());
			pieceview.setupPiece();
			zoompanel.add(pieceview);
			zoompanel.repaint();
		}

	}

	public void mouseExited(MouseEvent e) {
		if (bullpen.getSelectedPiece() == null) {
			zoompanel.removeAll();
			zoompanel.setImg("opaque_canvas.png");
		}
	}
}
