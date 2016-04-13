package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.LevelSelect;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.TopLevelApplication;

/**
 * Controller for Moving Screens; Go To Level Select Screen (Panel)
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

	public GoToLevelSelectController(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.contentPanel = app.getContentPane();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {

		ChangeScreenMove gtsm = new ChangeScreenMove(Screen.LevelSelect);
		gtsm.execute(kabasuji);
		LevelSelect lsp = new LevelSelect(kabasuji, app);
		app.changeContentPane(lsp);
	}
}
