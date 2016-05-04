package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Screen;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import misc.MusicPlayer;

/**
 * Controller for Moving Screens; Go To Play numlevel Screen (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class SelectLevelController extends MouseAdapter {

	/* Top Level Model */
	Kabasuji kabasuji;
	/* Level Number */
	int numlevel;
	/* Top Level Boundary */
	TopLevelApplication app;
	/* Screen view */
	PlayLevelPanel plp;
	/* Button view */
	JLabelIcon button;
	/* Original filename */
	String fn;

	/**
	 * Constructor for SelectLevelController.
	 * 
	 * @param kabasuji
	 * @param app
	 * @param button
	 *            view object button associated
	 * @param numlevel
	 *            number associated to the level
	 */
	public SelectLevelController(Kabasuji kabasuji, TopLevelApplication app, JLabelIcon button, int numlevel) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.button = button;
		this.fn = button.getFileName();
		this.numlevel = numlevel;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		/*** MODEL CHANGES ***/
		// Created SelectLevelMove and input desired numlevel integer
		SelectLevelMove slm = new SelectLevelMove(numlevel);

		// Attempt to execute action on model
		if (slm.execute(kabasuji)) {
			new MusicPlayer("select.wav").setVolume(-15);
			// Create PlayLevelPanel screen object and update boundary to
			// reflect *** GUI CHANGES ***

			// reset moves, time, and stars
			kabasuji.loadLevel();

			// first make the foundation panel and pass model and container
			// panel
			plp = new PlayLevelPanel(kabasuji, app, 0);

			int row = 4;
			int col = (int) (kabasuji.selectedLevel.getBullpen().getPieces().size() + 3) / 4;
			if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
				row = 1;
				col = 5;
			}
			// create components of panel and pass model and container panel
			BullpenView bpv = new BullpenView(kabasuji, plp, row, col);
			BoardView bv = new BoardView(kabasuji, plp);

			// set location and size of components (**necessary**)
			bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
					(int) (Screen.height * 0.54));
			bpv.setBounds((int) (Screen.width * 0.05), (int) (Screen.height * 0.05), (int) (Screen.width * 0.25),
					(int) (Screen.height * 0.85));

			// remove all components from PLP -> update PLP -> add controllers
			plp.removeAll();
			plp.updatePlayLevelPanel(bv, bpv);
			plp.addControllers();
			if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
				plp.startTimeLimit();
			}

			// repaint the PlayLevelPanel
			plp.repaint();

			// set the content panel of container to contain PlayLevelPanel
			app.setContentPanel(plp);
		} else {
			new MusicPlayer("fail.wav").setVolume(-15);
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
	 * Mouse Exit unhighlights the button.
	 */
	public void mouseExited(MouseEvent e) {
		// sets image back to original
		button.setImg(fn);
	}
}
