package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
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
public class SelectLevelController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	int level;
	Kabasuji kabasuji;
	TopLevelApplication app;
	JPanel contentPanel;

	public SelectLevelController(Kabasuji kabasuji, TopLevelApplication app, int level) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.contentPanel = app.getContentPane();
		this.level = level;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {

		SelectLevelMove slm = new SelectLevelMove(level);
		ChangeScreenMove gtsm = new ChangeScreenMove(Screen.Opening);
		if (slm.execute(kabasuji)) {
			gtsm.execute(kabasuji);
			MainMenu lsp = new MainMenu(kabasuji, app);
			app.changeContentPane(lsp);
		}
	}
}
