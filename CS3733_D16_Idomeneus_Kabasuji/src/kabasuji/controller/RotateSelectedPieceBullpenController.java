package kabasuji.controller;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
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

	public RotateSelectedPieceBullpenController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon pieceicon,
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
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		if(kabasuji.getSelectedLevel().getBullpen().getSelectedPiece() == null){
			selectedPiece = kabasuji.getSelectedLevel().getBoard().getSelectedPiece();
		}
		RotatePieceMove rpm = new RotatePieceMove(selectedPiece, right);
		rpm.execute(kabasuji);
		zoompanel.removeAll();
		PieceView pieceview = new PieceView(selectedPiece);
		pieceview.setBounds(0, 0, (int) zoompanel.getSize().getWidth(), (int) zoompanel.getSize().getHeight());
		pieceview.setupPiece();
		zoompanel.add(pieceview);
		zoompanel.repaint();
	}

	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		pieceicon.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		// sets back to original image
		pieceicon.setImg(fnpiece);
	}

}
