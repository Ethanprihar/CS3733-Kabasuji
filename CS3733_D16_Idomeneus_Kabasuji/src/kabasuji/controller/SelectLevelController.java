package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.PuzzleLevelPanel;
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
public class SelectLevelController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	int level;
	Kabasuji kabasuji;
	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;

	public SelectLevelController(Kabasuji kabasuji, TopLevelApplication app, JLabelIcon button, int level) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.contentPanel = app.getContentPane();
		this.button = button;
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
		// Attempt to execute action on model
		if (slm.execute(kabasuji)) {
			gtsm.execute(kabasuji);
			// Created JPanel screen object and update boundary to reflect changes
			PuzzleLevelPanel lsp = new PuzzleLevelPanel(kabasuji, app);
			app.changeContentPane(lsp);
		}
	}
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg("generalbutton.png");
	}
}
