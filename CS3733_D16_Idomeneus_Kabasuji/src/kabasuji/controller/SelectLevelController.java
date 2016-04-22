package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Screen;
import kabasuji.model.Tile;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
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

	/** Entity and Boundaries Associated **/
	int level;
	Kabasuji kabasuji;
	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;
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
		// Created SelectLevelMove and input desired level integer
		SelectLevelMove slm = new SelectLevelMove(level);
		// Created ChangeScreenMove and input desired screen
		ChangeScreenMove gtsm = new ChangeScreenMove(Screen.PlayLevel);
		// kabasuji.selectedLevel = kabasuji.getLevels().get(0);
		
		// Attempt to execute action on model
		if (slm.execute(kabasuji)) {
			gtsm.execute(kabasuji);
			// Created JPanel screen object and update boundary to reflect
			
			
			PlayLevelPanel lsp = new PlayLevelPanel(kabasuji, app);
			
			BullpenView bpv = new BullpenView(kabasuji, lsp, 3, 5);
			
			BoardView bv = new BoardView(kabasuji, lsp);
			bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
					(int) (Screen.height * 0.54));
			bpv.setSize((int) (Screen.width * 0.25), (int) (Screen.height * 0.85));
			bpv.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.05));
			
			lsp.removeAll();
			lsp.updatePlayLevelPanel(bv, bpv);
			lsp.addControllers();
			
			lsp.repaint();
			

			app.setContentPanel(lsp);
		}
	}

	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
