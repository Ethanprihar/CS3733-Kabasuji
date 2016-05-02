package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.TopLevelApplication;
import misc.MusicPlayer;

/**
 * Controller for Moving Screens; Go To Level Select Screen (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class GoToLevelSelectController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Kabasuji kabasuji;

	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;
	String fn;

	public GoToLevelSelectController(Kabasuji kabasuji, TopLevelApplication app, JLabelIcon button) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
		this.fn = button.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// Created JPanel screen object and update boundary to reflect changes
		new MusicPlayer("select.wav").setVolume(-15);
		LevelSelectPanel lsp = new LevelSelectPanel(kabasuji, app);
		app.setContentPanel(lsp);
	}

	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		button.setImg("generalhoverbutton.png");
	}
	public void mouseExited(MouseEvent e) {
		// sets back to original image
		button.setImg(fn);
	}
}
