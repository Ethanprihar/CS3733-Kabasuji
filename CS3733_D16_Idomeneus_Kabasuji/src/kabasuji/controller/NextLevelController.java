package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Level;
import kabasuji.model.LightningLevel;
import kabasuji.model.Screen;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import kabasuji.view.ErrorDialogBox;

/**
 * Controller for Reseting Level; Update PlayLevelPanel (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class NextLevelController extends MouseAdapter {

	/* Top Level Model */
	Kabasuji kabasuji;
	/* Level number */
	int level;
	/* Top Level Boundary */
	PlayLevelPanel plp;
	/* Button view */
	JLabelIcon button;
	/* Original filename */
	String fn;

	/**
	 * Constructor for NextLevelController.
	 * 
	 * @param kabasuji
	 * @param panel
	 * @param button
	 *            the view object associated to the button
	 */
	public NextLevelController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon button) {
		this.kabasuji = kabasuji;
		this.plp = panel;
		this.button = button;
		this.fn = button.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		/*** MODEL CHANGES ***/
		// Created SelectLevelMove and input desired level integer
		// SelectLevelMove slm = new SelectLevelMove(level);
		try {
			plp.getMP().getClip().stop();
		} catch (NullPointerException e) {
			System.out.println("MainMenuController: no mp");
		}

		// Get the array list of levels
		ArrayList<Level> numLevels = kabasuji.getLevels();
		// Get the selected level
		Level getSelected = kabasuji.getSelectedLevel();
		// Get the index of the current level (not 0 based)
		int numCurrentLevel = numLevels.indexOf(getSelected) + 1;
		// Get the size of the array list (not 0 based)
		int numTotalLevels = numLevels.size();

		// Throw an error if no more levels exist i.e. index of last level
		// equals index of current level
		if (numTotalLevels == numCurrentLevel) {
			ErrorDialogBox.infoBox("No more levels exist :( Go ahead and build one!", "Message");
		}

		else {
			// ensure that the player is able to move on the next level
			if (kabasuji.getSelectedLevel().getStars() > 0) {

				// update the timer
				if (plp.getTimer() != null) {
					plp.stopTimer();
				}
				// save level state and advance model to next level
				kabasuji.saveLevels();
				kabasuji.nextLevel();

				int row = 4;
				int col =(int) (kabasuji.selectedLevel.getBullpen().getPieces().size() + 3) / 4;
				if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
					row = 1;
					col = 5;
					plp.startTimeLimit();
				}
				// Create PlayLevelPanel screen object and update boundary to
				// reflect *** GUI CHANGES ***

				// first make the foundation panel and pass model and container
				// panel

				// create components of panel and pass model and container panel
				BullpenView bpv = new BullpenView(kabasuji, plp, row,
						col);
				BoardView bv = new BoardView(kabasuji, plp);

				// set location and size of components (**necessary)
				bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
						(int) (Screen.height * 0.54));
				bpv.setBounds((int) (Screen.width * 0.05), (int) (Screen.height * 0.05), (int) (Screen.width * 0.25),
						(int) (Screen.height * 0.85));

				// remove all components from PLP -> update PLP -> add
				// controllers
				plp.removeAll();
				plp.updatePlayLevelPanel(bv, bpv);
				plp.addControllers();

				// repaint the PlayLevelPanel
				plp.repaint();

				// set the content panel of container to contain PlayLevelPanel
				// app.setContentPanel(plp);
			}

		}

	}

	/**
	 * Mouse Enter highlights the button.
	 */
	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		button.setImg("generalhoverbutton.png");
	}

	/**
	 * Mouse Exit dehighlights the button.
	 */
	public void mouseExited(MouseEvent e) {
		// sets image back to original
		button.setImg(fn);
	}
}
