package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.Screen;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import misc.MusicPlayer;

/**
 * Controller for Resetting Level; Update PlayLevelPanel (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class ResetLevelController extends MouseAdapter {

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
	 * Constructor for ResetLevelController.
	 * 
	 * @param kabasuji
	 * @param panel
	 * @param button
	 *            the button view object associated
	 */
	public ResetLevelController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon button) {
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
		try {
			plp.getMP().getClip().stop();
		} catch (NullPointerException e) {
			System.out.println("MainMenuController: no mp");
		}
		if (kabasuji.getLevels().size() - 1 == kabasuji.getLevels().indexOf(kabasuji.getSelectedLevel())) {
			kabasuji.getLevels().add(new PuzzleLevel(null, null, 0));
			kabasuji.saveLevels();
			kabasuji.resetLevel();
			kabasuji.getLevels().remove(kabasuji.getLevels().size() - 1);
		} else {
			kabasuji.saveLevels();
			kabasuji.resetLevel();
		}
		new MusicPlayer("select.wav").setVolume(-15);

		int row = 4;
		int col = (int) (kabasuji.selectedLevel.getBullpen().getPieces().size() + 3) / 4;
		if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
			row = 1;
			col = 5;
		}
		// Create PlayLevelPanel screen object and update boundary to
		// reflect *** GUI CHANGES ***

		// first make the foundation panel and pass model and container
		// panel
		// PlayLevelPanel plp = new PlayLevelPanel(kabasuji, app);

		// create components of panel and pass model and container panel
		BullpenView bpv = new BullpenView(kabasuji, plp, row, col);
		BoardView bv = new BoardView(kabasuji, plp);

		// set location and size of components (**necessary)
		bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
				(int) (Screen.height * 0.54));
		bpv.setBounds((int) (Screen.width * 0.05), (int) (Screen.height * 0.05), (int) (Screen.width * 0.25),
				(int) (Screen.height * 0.85));

		// remove all components from PLP -> update PLP -> add controllers
		plp.removeAll();
		plp.updatePlayLevelPanel(bv, bpv);

		// If the level is a lightning level then reset the timer
		if (kabasuji.selectedLevel instanceof LightningLevel) {
			plp.resetTimer();
		}
		plp.addControllers();

		// repaint the PlayLevelPanel
		plp.repaint();

	}

	/**
	 * Mouse Enter event highlights the button.
	 */
	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		button.setImg("generalhoverbutton.png");
	}

	/**
	 * Mouse Exit event dehighlights the button.
	 */
	public void mouseExited(MouseEvent e) {
		// sets image back to original
		button.setImg(fn);
	}
}
