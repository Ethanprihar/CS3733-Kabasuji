package kabasuji.view;

import javax.swing.JPanel;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.model.Kabasuji;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Screen;
import kabasuji.model.Tile;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PlayLevelPanel extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the panel.
	 */
	public PlayLevelPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		JLabelIcon background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		JLabelIcon bullpen = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.7),
				(int) (Screen.height * 0.25));
		bullpen.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.05));
		background.add(bullpen);
		
		Tile boardTile0_0 = new Tile(false, true, 0, 0);
		Tile boardTile0_1 = new Tile(false, true, 0, 0);
		Tile boardTile0_2 = new Tile(false, true, 0, 0);
		Tile boardTile0_3 = new Tile(false, true, 0, 0);
		Tile boardTile0_4 = new Tile(false, false, 0, 0);
		Tile boardTile1_0 = new Tile(false, true, 0, 0);
		Tile boardTile1_1 = new Tile(false, false, 0, 0);
		Tile boardTile1_2 = new Tile(false, true, 0, 0);
		Tile boardTile1_3 = new Tile(false, true, 0, 0);
		Tile boardTile1_4 = new Tile(false, false, 0, 0);
		Tile boardTile2_0 = new Tile(false, true, 0, 0);
		Tile boardTile2_1 = new Tile(false, true, 0, 0);
		Tile boardTile2_2 = new Tile(false, true, 0, 0);
		Tile boardTile2_3 = new Tile(false, true, 0, 0);
		Tile boardTile2_4 = new Tile(false, false, 0, 0);
		Tile boardTile3_0 = new Tile(false, true, 0, 0);
		Tile boardTile3_1 = new Tile(false, true, 0, 0);
		Tile boardTile3_2 = new Tile(false, true, 0, 0);
		Tile boardTile3_3 = new Tile(false, true, 0, 0);
		Tile boardTile3_4 = new Tile(false, true, 0, 0);
		Tile boardTile4_0 = new Tile(false, true, 0, 0);
		Tile boardTile4_1 = new Tile(false, true, 0, 0);
		Tile boardTile4_2 = new Tile(false, false, 0, 0);
		Tile boardTile4_3 = new Tile(false, false, 0, 0);
		Tile boardTile4_4 = new Tile(false, false, 0, 0);
		Tile[][] tiles = 
			{{boardTile0_0,boardTile0_1,boardTile0_2,boardTile0_3,boardTile0_4},
			{boardTile1_0,boardTile1_1,boardTile1_2,boardTile1_3,boardTile1_4},
			{boardTile2_0,boardTile2_1,boardTile2_2,boardTile2_3,boardTile2_4},
			{boardTile3_0,boardTile3_1,boardTile3_2,boardTile3_3,boardTile3_4},
			{boardTile4_0,boardTile4_1,boardTile4_2,boardTile4_3,boardTile4_4}};
		PuzzleBoard tboard = new PuzzleBoard(tiles);
		JLabelIcon board = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 3/8),
				(int) (Screen.height *0.5));
		board.setLocation((int)(Screen.width * 0.25), (int) (Screen.height * 0.40));
		
		BoardView boardview = new BoardView(tboard, board);
		// ^ a little weird since we don't actually add the board view to the background
		
		background.add(board);

		JLabelIcon fliphbtn = new JLabelIcon("generalbutton.png", 70, 70);
		fliphbtn.setLocation((int) (Screen.width * 0.72) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel fliphlbl = new JLabel("<html>Flip<br>Horizontal</html>", SwingConstants.CENTER);
		fliphlbl.setBounds(0, 0, 70, 70);
		fliphlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		fliphbtn.add(fliphlbl);
		
		background.add(fliphbtn);

		JLabelIcon flipvbtn = new JLabelIcon("generalbutton.png", 70, 70);
		flipvbtn.setLocation((int) (Screen.width * 0.82) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel flipvlbl = new JLabel("<html>Flip<br>Vertical</html>", SwingConstants.CENTER);
		flipvlbl.setBounds(0, 0, 70, 70);
		flipvlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		flipvbtn.add(flipvlbl);
		background.add(flipvbtn);

		JLabelIcon rotatehbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatehbtn.setLocation((int) (Screen.width * 0.72) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatehlbl = new JLabel("<html>Rotate<br>Horizontal</html>", SwingConstants.CENTER);
		rotatehlbl.setBounds(0, 0, 70, 70);
		rotatehlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatehbtn.add(rotatehlbl);
		background.add(rotatehbtn);

		JLabelIcon rotatevbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatevbtn.setLocation((int) (Screen.width * 0.82) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatevlbl = new JLabel("<html>Rotate<br>Vertical</html>", SwingConstants.CENTER);
		rotatevlbl.setBounds(0, 0, 70, 70);
		rotatevlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatevbtn.add(rotatevlbl);
		background.add(rotatevbtn);

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.82) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(
				new GoToMainMenuController(kabasuji, app,mainmenubtn));
		background.add(mainmenubtn);

		JLabelIcon nextlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		nextlevelbtn.setLocation((int) (Screen.width * 0.72) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel nextlevellbl = new JLabel("<html>Next<br>Level</html>", SwingConstants.CENTER);
		nextlevellbl.setBounds(0, 0, 70, 70);
		nextlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		nextlevelbtn.add(nextlevellbl);
		background.add(nextlevelbtn);

		JLabelIcon resetlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		resetlevelbtn.setLocation((int) (Screen.width * 0.72) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .73));
		JLabel resetlevellbl = new JLabel("<html>Reset<br>Level</html>", SwingConstants.CENTER);
		resetlevellbl.setBounds(0, 0, 70, 70);
		resetlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		resetlevelbtn.add(resetlevellbl);
		background.add(resetlevelbtn);

		JLabelIcon[] stars = new JLabelIcon[3];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new JLabelIcon("star_score.png", 50, 50);
			stars[i].setLocation((int) (nextlevelbtn.getX() + (mainmenubtn.getX() - nextlevelbtn.getX())*(i+1)/(stars.length)),
					(int) (nextlevelbtn.getY() - (((i+1)% 2)+1) * stars[i].getSize().getWidth()));
			background.add(stars[i]);
		}

	}
}
