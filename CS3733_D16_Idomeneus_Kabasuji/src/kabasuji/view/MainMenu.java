package kabasuji.view;

import javax.swing.JPanel;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Main Menu navigation screen; offers navigation to SelectLevelPanel.
 * 
 * Is contained in JFrame
 * @author jwu
 *
 */

public class MainMenu extends JPanel {
	/** Entities and Boundaries associated **/
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the Main Menu Panel.
	 * @param kabasuji
	 * @param app
	 */
	public MainMenu(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		// set layout null first
		setLayout(null);
		
		// create a button image with specified dimension
		JLabelIcon levelselectbtn = new JLabelIcon("generalbutton.png",70,70);
		levelselectbtn.setLocation((int)(Screen.width-levelselectbtn.getSize().getWidth())/2,(int)(Screen.height-levelselectbtn.getSize().getHeight())/2);

		// create label within button image
		JLabel buttonlbl = new JLabel("<html>Select<br> Level</html>", SwingConstants.CENTER);
		buttonlbl.setBounds(0,0,(int)(levelselectbtn.getSize().getWidth()),(int)(levelselectbtn.getSize().getHeight()));	
		buttonlbl.setFont(new Font("Onyx", Font.BOLD, 18));

		// add label to button image
		levelselectbtn.add(buttonlbl);
		levelselectbtn.addMouseListener(new GoToLevelSelectController(kabasuji, app, levelselectbtn));
		
		// add button image to JPanel
		add(levelselectbtn);
		
		// create the background canvas ** important and add to JPanel
		JLabelIcon background = new JLabelIcon("KabasujiTitleScreen.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
	}
	
}
