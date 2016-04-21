package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.SwingConstants;
import java.util.Random;

public class LevelSelectPanel extends JPanel {
	/** Entities and Boundaries associated **/
	Kabasuji kabasuji;
	TopLevelApplication app;

	/** Level Button GUI elements **/
	JLabelIcon[] levelselectbtn;
	JLabel[] buttonlbl;
	
	/** dimensions of level button array **/
	int row;
	int col;

	/**
	 * Create the LevelSelectPanel.
	 * @param kabasuji
	 * @param app
	 */
	public LevelSelectPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.levelselectbtn = new JLabelIcon[kabasuji.getLevels().size()];
		this.buttonlbl = new JLabel[kabasuji.getLevels().size()];

		// set layout to null
		setLayout(null);

		
		// temporary row and col setup ***********
		row = 5;
		col = 3;
		// 
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				int starNum = kabasuji.levels.get(i * 5 + j).getStars();
				boolean locked = kabasuji.levels.get(i * 5 + j).isLocked();
				
				// Decide locked picture or not
				if (locked) {
					levelselectbtn[i * 5 + j] = new JLabelIcon("generallockedbutton.png", 70, 70);
				} else {
					levelselectbtn[i * 5 + j] = new JLabelIcon("generalbutton.png", 70, 70);
				}

				// set location relative to background
				int lvlbtnw = (int) levelselectbtn[i * 5 + j].getSize().getWidth();
				int lvlbtnh = (int) levelselectbtn[i * 5 + j].getSize().getHeight();
				levelselectbtn[i * 5 + j].setLocation((int) (Screen.width / 6 * (j + 1) - lvlbtnw / 2),
						(int) (Screen.height / 12 * (i * 2 + 4) - lvlbtnh / 2));
				buttonlbl[i * 5 + j] = new JLabel("<html>Select<br>" + "Level " + (i * 5 + j + 1) + "</html>",
						SwingConstants.CENTER);
				buttonlbl[i * 5 + j].setBounds(0, 0, 70, 70);
				buttonlbl[i * 5 + j].setFont(new Font("Onyx", Font.BOLD, 18));
				levelselectbtn[i * 5 + j].add(buttonlbl[i * 5 + j]);
				levelselectbtn[i * 5 + j].addMouseListener(
						new SelectLevelController(kabasuji, app, levelselectbtn[i * 5 + j], i * 5 + j + 1));
				add(levelselectbtn[i * 5 + j]);
				/*** take this out when levels are good *******************************/
				Random rn = new Random();
				int n = rn.nextInt(3) + 1;
				// set # stars and location on gui
				for (int k = 0; k < n; k++) {
					JLabelIcon star = new JLabelIcon("star_score.png", 15, 15);
					star.setLocation(
							(int) (levelselectbtn[i * 5 + j].getLocation().getX() + lvlbtnw * (k + 1) / (n + 1)
									- star.getSize().getWidth() / 2),
							(int) (levelselectbtn[i * 5 + j].getLocation().getY() - star.getSize().getWidth()));
					add(star);
				}
			}
		}
		// return to main menu button created and set
		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(new GoToMainMenuController(kabasuji, app, mainmenubtn));
		add(mainmenubtn);
		
		// setup background canvas
		JLabelIcon background = new JLabelIcon("LevelSelectScreen.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

	}
	/**
	 * Getter for JLabelIcon[] of level select buttons.
	 * @return
	 */
	public JLabelIcon[] getLevelSelectButtons() {
		return levelselectbtn;
	}
}
