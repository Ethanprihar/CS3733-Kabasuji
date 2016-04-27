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

/**
 * Controller for Moving Screens; Go To Play Level Screen (Panel).
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class SelectLevelController extends MouseAdapter {

	/** Entities associated **/
	Kabasuji kabasuji;
	int level; // 0 = Puzzle, 1 = Lightning, 2 = Release
	/** Boundaries associated **/
	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;
	PlayLevelPanel plp;
	String fn;

	public SelectLevelController(Kabasuji kabasuji, TopLevelApplication app, JLabelIcon button, int level) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
		this.fn = button.getFileName();
		this.level = level;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		/*** MODEL CHANGES ***/
		// Created SelectLevelMove and input desired level integer
		SelectLevelMove slm = new SelectLevelMove(level);
		// Created ChangeScreenMove and input desired screen
		ChangeScreenMove gtsm = new ChangeScreenMove(Screen.PlayLevel);

		// Attempt to execute action on model
		if (slm.execute(kabasuji)) {
			gtsm.execute(kabasuji);

			// Create PlayLevelPanel screen object and update boundary to
			// reflect *** GUI CHANGES ***
			
			// reset moves, time, and stars
			kabasuji.loadLevel();

			// first make the foundation panel and pass model and container
			// panel
			plp = new PlayLevelPanel(kabasuji, app);

			// create components of panel and pass model and container panel
			BullpenView bpv = new BullpenView(kabasuji, plp, 4,
					(int) (kabasuji.selectedLevel.getBullpen().getPieces().size() + 3) / 4);
			BoardView bv = new BoardView(kabasuji, plp);

			// set location and size of components (**necessary)
			bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
					(int) (Screen.height * 0.54));
			bpv.setBounds((int) (Screen.width * 0.05), (int) (Screen.height * 0.05), (int) (Screen.width * 0.25),
					(int) (Screen.height * 0.85));

			// remove all components from PLP -> update PLP -> add controllers
			plp.removeAll();
			plp.updatePlayLevelPanel(bv, bpv);
			plp.addControllers();

			// repaint the PlayLevelPanel
			plp.repaint();

			// set the content panel of container to contain PlayLevelPanel
			app.setContentPanel(plp);
		}
	}

	public void mouseEntered(MouseEvent e) {
		// sets image to indicate hover event
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		// sets image back to original
		button.setImg(fn);
	}
}
