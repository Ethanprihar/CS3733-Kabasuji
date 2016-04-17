package kabasuji.view;

import javax.swing.JPanel;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.Random;

public class LevelSelectPanel extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the panel.
	 */
	public LevelSelectPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		JLabelIcon[] levelselectbtn = new JLabelIcon[15];
		JLabel[] buttonlbl = new JLabel[15];

		JLabelIcon background = new JLabelIcon("LevelSelectScreen.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				int starNum = kabasuji.levels.get(i * 5 + j).getStars();
				boolean locked = kabasuji.levels.get(i * 5 + j).getLocked();
				// Decide locked picture or not
				if (locked) {
					levelselectbtn[i * 5 + j] = new JLabelIcon("generallockedbutton.png", 70, 70);
				} else {
					levelselectbtn[i * 5 + j] = new JLabelIcon("generalbutton.png", 70, 70);
				}

				// set location relative to background
				int lvlbtnw = (int) levelselectbtn[i * 5 + j].getSize().getWidth();
				int lvlbtnh = (int) levelselectbtn[i * 5 + j].getSize().getHeight();
				levelselectbtn[i * 5 + j].setLocation((int) (Screen.width / 6 * (j + 1) - lvlbtnw/2),
						(int) (Screen.height / 12 * (i * 2 + 4) - lvlbtnh/2));
				buttonlbl[i * 5 + j] = new JLabel("<html>Select<br>" + "Level " + (i * 5 + j + 1) + "</html>",
						SwingConstants.CENTER);
				buttonlbl[i * 5 + j].setBounds(0, 0, 70, 70);
				buttonlbl[i * 5 + j].setFont(new Font("Onyx", Font.BOLD, 18));
				levelselectbtn[i * 5 + j].add(buttonlbl[i * 5 + j]);
				levelselectbtn[i * 5 + j].addMouseListener(
						new SelectLevelController(kabasuji, app, levelselectbtn[i * 5 + j], i * 5 + j + 1));
				background.add(levelselectbtn[i * 5 + j]);
				Random rn = new Random();
				int n = rn.nextInt(3)+1;
				System.out.println(n);
				for (int k = 0; k < n; k++) {
					JLabelIcon star = new JLabelIcon("star_score.png", 15, 15);
					star.setLocation((int) (levelselectbtn[i * 5 + j].getLocation().getX() + lvlbtnw*(k+1) / (n+1) - star.getSize().getWidth() / 2),
							(int) (levelselectbtn[i * 5 + j].getLocation().getY() - star.getSize().getWidth()));
					background.add(star);
				}
			}
		}

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) ((Screen.width - mainmenubtn.getSize().getWidth()) / 2),
				(int) (Screen.height * .8));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(
				new GoToMainMenuController(kabasuji, app,mainmenubtn));
		background.add(mainmenubtn);

	}
}
