package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Main Menu navigation screen; offers navigation to SelectLevelPanel.
 * 
 * Is contained in JFrame.
 * 
 * @author jwu
 *
 */

public class MainMenu extends JPanel {
	/** Entities and Boundaries associated **/
	Kabasuji kabasuji;
	TopLevelApplication app;

	/** Button(s) **/
	JLabelIcon levelselectbtn;

	/** button parameters **/
	int btnsidelength = 70;

	/**
	 * Create the Main Menu Panel.
	 * 
	 * @param kabasuji
	 * @param app
	 */
	public MainMenu(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		// set layout null first
		setLayout(null);

		// create a button image with specified dimension
		levelselectbtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Select" + "<br>" + "Level");
		levelselectbtn.setLocation((int) (Screen.width - levelselectbtn.getSize().getWidth()) / 2,
				(int) (Screen.height - levelselectbtn.getSize().getHeight()) / 2);
		levelselectbtn.addMouseListener(new GoToLevelSelectController(kabasuji, app, levelselectbtn));

		// add button image to JPanel
		add(levelselectbtn);

		// create the background canvas ** important and add to JPanel
		JLabelIcon background = new JLabelIcon("KabasujiTitleScreen.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
	}

	/**
	 * Getter for LevelSelectButton
	 * 
	 * @return level select view.
	 */
	public JLabelIcon getLevelSelectButton() {
		return levelselectbtn;
	}

}
