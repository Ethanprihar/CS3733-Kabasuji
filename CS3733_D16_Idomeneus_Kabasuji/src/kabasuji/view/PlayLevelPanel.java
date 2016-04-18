package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kabasuji.controller.GoToMainMenuController;
import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Screen;
import kabasuji.model.Tile;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PlayLevelPanel extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	Board board;
	Bullpen bullpen;

	BoardView boardview;
	BullpenView bullpenview;

	JLabelIcon zoompiece;

	/**
	 * Create the panel.
	 */
	public PlayLevelPanel(Kabasuji kabasuji, TopLevelApplication app) {
		super();
		this.kabasuji = kabasuji;
		this.app = app;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();

		// set layout null
		setLayout(null);
		setBounds(0, 0, Screen.width, Screen.height);

	}
	public void updatePlayLevelPanel(BoardView bv, BullpenView bpv){
		// test adding pieces to Bullpen

		zoompiece = new JLabelIcon("opaque_canvas.png", (int) (Screen.height * 0.25), (int) (Screen.height * 0.25));
		zoompiece.setLocation((int) (Screen.width * 0.35), (int) (Screen.height * 0.05));
		add(zoompiece);


		JLabelIcon fliphbtn = new JLabelIcon("generalbutton.png", 70, 70);
		fliphbtn.setLocation((int) (Screen.width * 0.52) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel fliphlbl = new JLabel("<html>Flip<br>Horizontal</html>", SwingConstants.CENTER);
		fliphlbl.setBounds(0, 0, 70, 70);
		fliphlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		fliphbtn.add(fliphlbl);

		add(fliphbtn);

		JLabelIcon flipvbtn = new JLabelIcon("generalbutton.png", 70, 70);
		flipvbtn.setLocation((int) (Screen.width * 0.62) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel flipvlbl = new JLabel("<html>Flip<br>Vertical</html>", SwingConstants.CENTER);
		flipvlbl.setBounds(0, 0, 70, 70);
		flipvlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		flipvbtn.add(flipvlbl);
		add(flipvbtn);

		JLabelIcon rotatehbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatehbtn.setLocation((int) (Screen.width * 0.52) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatehlbl = new JLabel("<html>Rotate<br>Horizontal</html>", SwingConstants.CENTER);
		rotatehlbl.setBounds(0, 0, 70, 70);
		rotatehlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatehbtn.add(rotatehlbl);
		add(rotatehbtn);

		JLabelIcon rotatevbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatevbtn.setLocation((int) (Screen.width * 0.62) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatevlbl = new JLabel("<html>Rotate<br>Vertical</html>", SwingConstants.CENTER);
		rotatevlbl.setBounds(0, 0, 70, 70);
		rotatevlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatevbtn.add(rotatevlbl);
		add(rotatevbtn);

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.84) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(new GoToMainMenuController(kabasuji, app, mainmenubtn));
		add(mainmenubtn);

		JLabelIcon nextlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		nextlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel nextlevellbl = new JLabel("<html>Next<br>Level</html>", SwingConstants.CENTER);
		nextlevellbl.setBounds(0, 0, 70, 70);
		nextlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		nextlevelbtn.add(nextlevellbl);
		add(nextlevelbtn);

		JLabelIcon resetlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		resetlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .73));
		JLabel resetlevellbl = new JLabel("<html>Reset<br>Level</html>", SwingConstants.CENTER);
		resetlevellbl.setBounds(0, 0, 70, 70);
		resetlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		resetlevelbtn.add(resetlevellbl);
		add(resetlevelbtn);

		JLabelIcon[] stars = new JLabelIcon[3];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new JLabelIcon("star_score.png", 50, 50);
			stars[i].setLocation(
					(int) (nextlevelbtn.getX() + (mainmenubtn.getX() - nextlevelbtn.getX()) * (i + 1) / (stars.length)),
					(int) (nextlevelbtn.getY() - (((i + 1) % 2) + 1) * stars[i].getSize().getWidth()));
			add(stars[i]);
		}
		
		add(bv);
		add(bpv);
		setBoardView(bv);
		setBullpenView(bpv);
		
		// set up background
		JLabelIcon background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
	}

	// getter for zoompiece
	public JLabelIcon getZoomPiece() {
		return zoompiece;
	}

	// setter for boardview
	public void setBoardView(BoardView bv) {
		boardview = bv;
		boardview.setupBoard();
		repaint();
	}
	
	// getter for boardview
	public BoardView getBoardView() {
		return boardview;
	}
	public void setBullpenView(BullpenView bpv) {
		bullpenview = bpv;
		bullpenview.setupBullpen();
		repaint();
	}

	// getter for bullpenview
	public BullpenView getBullpenView() {
		return bullpenview;
	}
}
