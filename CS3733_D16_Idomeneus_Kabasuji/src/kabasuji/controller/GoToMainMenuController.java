package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class GoToMainMenuController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Kabasuji kabasuji;

	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;
	String fn;

	/**
	 * Constructor for GoToMainMenuController.
	 * 
	 * @param kabasuji
	 * @param app
	 * @param button
	 *            the view object associated
	 */
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
		// try{
		// ((PlayLevelPanel) app.getContentPane()).getMP().getClip().stop();
		// }
		// catch(NullPointerException e){
		// System.out.println("MainMenuController: no mp");
		// }
		// int index =
		// kabasuji.getLevels().indexOf(kabasuji.getSelectedLevel());
		// stop the timer if in play level panel
		if (app.getContentPane() instanceof PlayLevelPanel) {
			System.out.println("Stop timer");
			((PlayLevelPanel) app.getContentPane()).stopTimer();
		}

		// Created ChangeScreenMove and input desired screen
		// ChangeScreenMove gtsm = new ChangeScreenMove(Screen.Opening);
		// Attempt to execute action on model
		// gtsm.execute(kabasuji);

		int index = -1;
		if (kabasuji.getSelectedLevel() != null) {
			index = kabasuji.getLevels().indexOf(kabasuji.getSelectedLevel());
		}

		kabasuji.saveLevels();
		if (index != -1)
			kabasuji.getLevels().get(index).setLocked(false);

		new MusicPlayer("select.wav").setVolume(-15);
		// Created JPanel screen object and update boundary to reflect changes
		MainMenu mm = new MainMenu(kabasuji, app);
		app.setContentPanel(mm);

	}

	/**
	 * Mouse Enter highlights the button.
	 */
	public void mouseEntered(MouseEvent e) {
		// sets to image indicating hover event
		button.setImg("generalhoverbutton.png");
	}

	/**
	 * Mouse Exit dehighlights the button.
	 */
	public void mouseExited(MouseEvent e) {
		// sets back to original image
		button.setImg(fn);
	}
}
