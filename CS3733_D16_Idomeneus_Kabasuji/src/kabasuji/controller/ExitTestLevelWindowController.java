package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import kabasuji.view.MainMenu;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import misc.MusicPlayer;

/**
 * Controller for Moving Screens; Go To MainMenu Screen (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class ExitTestLevelWindowController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	JLabelIcon button;
	String fn;
	JFrame frame;

	public ExitTestLevelWindowController(JFrame frame, JLabelIcon button) {
		this.button = button;
		this.frame = frame;
		this.fn = button.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		frame.dispose();
	}

	public void mouseEntered(MouseEvent e) {
		// sets to image indicating hover event
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		// sets back to original image
		button.setImg(fn);
	}
}
