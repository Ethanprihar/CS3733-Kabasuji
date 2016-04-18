package kabasuji.controller;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
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
	Bullpen bullpen;
	JPanel panel;	
	BullpenView bullpenview;
	JLabelIcon pieceicon;
	
	JLabelIcon zoompanel;
	String fn;
	
	int numPiece;

	public SelectPieceBullpenController(Bullpen bullpen, JPanel panel, JLabelIcon pieceicon, int numPiece) {
		this.bullpen = bullpen;
//		this.panel = (PlayLevelPanel)(panel);
//		this.bullpenview = ((PlayLevelPanel) panel).getBullpenView();
		this.pieceicon = pieceicon;
//		this.zoompanel = ((PlayLevelPanel) panel).getZoomPiece();
//		this.fn = zoompanel.getFileName();
		this.numPiece = numPiece;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		
	}
	public void mouseEntered(MouseEvent e) {
//		zoompanel.setImg(bullpenview.getImgPieces()[numPiece].getFileName());
	}

	public void mouseExited(MouseEvent e) {
//		zoompanel.setImg(fn);
	}
}
