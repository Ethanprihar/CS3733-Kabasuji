package kabasuji.view;

import javax.swing.JPanel;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Screen;

@SuppressWarnings("serial")
/**
 * JPanel loading up levels to display and select.
 * 
 * @author jwu
 *
 */
public class LevelSelectPanel extends JPanel {
	/* Top Level Model */
	Kabasuji kabasuji;
	/* Top Level Boundary */
	TopLevelApplication app;

	/* Level Select Button Views */
	JLabelIcon[] levelselectbtn;
	/* Level Type Icons */
	JLabelIcon[] leveltypeicons;
	
	/** Main Menu Button **/
	JLabelIcon mainmenubtn;

	/* row */
	int row = 3;
	/* col */
	int col = 5;

	/* button side length pixels */
	int btnsidelength = 70;
	/* star side length pixels */
	int starsidelength = 15;
	/* level type icon side length */
	int lvltypesidelength = 26;
	/* level type icon offset x */
	int lvltypeiconoffsetx = (int) ((btnsidelength - lvltypesidelength) / 2);
	/* level type icon offset y */
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
		this.leveltypeicons = new JLabelIcon[kabasuji.getLevels().size()];

		// set layout to null
		setLayout(null);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				try {
					boolean locked = kabasuji.levels.get(i * col + j).isLocked();

					/******************* Level Icon Display *******************************************/
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
					/*********************** Configure Level Select Button ****************************/
					/****************** Determine Locked or Unlocked Button Display******************/
					String btnimg = "generalbutton.png";
					if (locked) {
						btnimg = "generallockedbutton.png";
					}
					levelselectbtn[i * col + j] = new JLabelIcon(btnimg, btnsidelength, btnsidelength,
							"Level" + "<br>" + (i * col + j + 1));
					levelselectbtn[i * col + j].setLocation((int) (Screen.width / 6 * (j + 1) - btnsidelength / 2),
							(int) (Screen.height / 12 * (i * 2 + 4) - btnsidelength / 2));
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
		mainmenubtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Main"+"<br>"+"Menu");
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
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
	
	/**
	 * Getter for JLabelIcon[] of main menu buttons
	 * 
	 * @return
	 */
	public JLabelIcon getMainMenuButton() {
		return mainmenubtn;
	}
}
