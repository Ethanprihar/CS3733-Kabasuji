package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Screen;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.SwingConstants;
import java.util.Random;

@SuppressWarnings("serial")
/**
 * JPanel loading up levels to display and select.
 * 
 * @author jwu
 *
 */
public class LevelSelectPanel extends JPanel {
	/** Entities and Boundaries associated **/
	Kabasuji kabasuji;
	TopLevelApplication app;

	/** Level Button GUI elements **/
	JLabelIcon[] levelselectbtn;
	JLabel[] buttonlbl;
	JLabelIcon[] leveltypeicons;

	/** dimensions of level button array (row X col display) **/
	int row = 3;
	int col = 5;

	/** generic button size && star size && leveltypeicon(pixels) **/
	int btnsidelength = 70;
	int starsidelength = 15;
	int lvltypesidelength = 26;
	int lvltypeiconoffsetx = (int) ((btnsidelength - lvltypesidelength) / 2);
	int lvltypeiconoffsety = (int) (btnsidelength * 0.8);

	/**
	 * Create the LevelSelectPanel.
	 * 
	 * Note: We use a single large array so that even given 15+ levels, we will
	 * only display the first 15 levels (15 because row*col)
	 * 
	 * @param kabasuji
	 * @param app
	 */
	public LevelSelectPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.levelselectbtn = new JLabelIcon[kabasuji.getLevels().size()];
		this.buttonlbl = new JLabel[kabasuji.getLevels().size()];
		this.leveltypeicons = new JLabelIcon[kabasuji.getLevels().size()];

		// set layout to null
		setLayout(null);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				try {
					boolean locked = kabasuji.levels.get(i * col + j).isLocked();

					// Decide locked picture or not
					if (locked) {
						levelselectbtn[i * col + j] = new JLabelIcon("generallockedbutton.png", btnsidelength,
								btnsidelength);
					} else {
						levelselectbtn[i * col + j] = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength);
					}

					// set location relative to background
					String leveltypefn = "opaquetile.png";
					if (kabasuji.getLevels().get(i * col + j) instanceof PuzzleLevel) {
						leveltypefn = "puzzle.png";
					} else if (kabasuji.getLevels().get(i * col + j) instanceof LightningLevel) {
						leveltypefn = "lightningcloud.png";
					} else if (kabasuji.getLevels().get(i * col + j) instanceof ReleaseLevel) {
						leveltypefn = "overlapping.png";
					}
					leveltypeicons[i * col + j] = new JLabelIcon(leveltypefn, lvltypesidelength, lvltypesidelength);
					leveltypeicons[i * col + j].setLocation(
							(int) (Screen.width / 6 * (j + 1) - btnsidelength / 2 + lvltypeiconoffsetx),
							(int) (Screen.height / 12 * (i * 2 + 4) - btnsidelength / 2 + lvltypeiconoffsety));
					add(leveltypeicons[i * col + j]);
					levelselectbtn[i * col + j].setLocation((int) (Screen.width / 6 * (j + 1) - btnsidelength / 2),
							(int) (Screen.height / 12 * (i * 2 + 4) - btnsidelength / 2));
					buttonlbl[i * col + j] = new JLabel("<html>Select<br>" + "Level " + (i * col + j + 1) + "</html>",
							SwingConstants.CENTER);
					buttonlbl[i * col + j].setBounds(0, 0, btnsidelength, btnsidelength);
					buttonlbl[i * col + j].setFont(new Font("Onyx", Font.BOLD, 18));
					levelselectbtn[i * col + j].add(buttonlbl[i * col + j]);
					levelselectbtn[i * col + j].addMouseListener(
							new SelectLevelController(kabasuji, app, levelselectbtn[i * col + j], i * col + j + 1));
					add(levelselectbtn[i * col + j]);

					// get high score for particular level
					int numhighscore = kabasuji.getLevels().get(i * col + j).getHighScore();
					// set # stars and location on gui
					for (int k = 0; k < numhighscore; k++) {
						JLabelIcon star = new JLabelIcon("star_score.png", starsidelength, starsidelength);
						star.setLocation(
								(int) (levelselectbtn[i * col + j].getLocation().getX()
										+ btnsidelength * (k + 1) / (numhighscore + 1) - star.getSize().getWidth() / 2),
								(int) (levelselectbtn[i * col + j].getLocation().getY() - star.getSize().getWidth()));
						add(star);
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("LevelSelectPanel.java: Level Out of Bounds");
				}
			}
		}
		// return to main menu button created and set
		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength);
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, btnsidelength, btnsidelength);
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
	 * 
	 * @return
	 */
	public JLabelIcon[] getLevelSelectButtons() {
		return levelselectbtn;
	}
}
