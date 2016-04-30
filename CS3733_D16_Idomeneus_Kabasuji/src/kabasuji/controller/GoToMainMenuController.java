package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import kabasuji.view.MainMenu;
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
public class GoToMainMenuController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Kabasuji kabasuji;

	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;
	String fn;

	public GoToMainMenuController(Kabasuji kabasuji, TopLevelApplication app, JLabelIcon button) {
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
		int index = -1;
		if(kabasuji.getSelectedLevel() != null)
			index = kabasuji.getLevels().indexOf(kabasuji.getSelectedLevel());
		// Created ChangeScreenMove and input desired screen
		ChangeScreenMove gtsm = new ChangeScreenMove(Screen.Opening);
		// Attempt to execute action on model
		gtsm.execute(kabasuji);
		kabasuji.saveLevels();
		if (index != -1)
			kabasuji.getLevels().get(index).setLocked(false);
		new MusicPlayer("select.wav");
		// Created JPanel screen object and update boundary to reflect changes
		MainMenu mm = new MainMenu(kabasuji, app);
		app.setContentPanel(mm);
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
