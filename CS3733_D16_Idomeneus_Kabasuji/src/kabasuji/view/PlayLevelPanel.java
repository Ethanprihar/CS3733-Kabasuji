package kabasuji.view;

import javax.swing.JPanel;

import kabasuji.controller.FlipSelectedPieceBullpenController;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.NextLevelController;
import kabasuji.controller.ResetLevelController;
import kabasuji.controller.RotateSelectedPieceBullpenController;
import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Screen;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PlayLevelPanel extends JPanel {
	/** Entities associated **/
	Kabasuji kabasuji;
	Board board;
	Bullpen bullpen;

	Timer timer; // Timer used for Lightning Mode

	/** Boundaries associated **/
	TopLevelApplication app;
	BoardView boardview;
	BullpenView bullpenview;

	JLabelIcon zoompiece;
	JLabelIcon rotatelbtn;
	JLabelIcon rotaterbtn;
	JLabelIcon fliphbtn;
	JLabelIcon flipvbtn;

	JLabelIcon resetlevelbtn;
	JLabelIcon nextlevelbtn;

	JLabel movesLeft;
	JLabel movesLeftNum;
	JLabel timeLeft;
	JLabel timeLeftNum;
	
	JLabelIcon background;

	/**
	 * Construct PlayLevelPanel.
	 * 
	 * @param kabasuji
	 * @param app
	 */
	public PlayLevelPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();

		// set layout null
		setLayout(null);
		setBounds(0, 0, Screen.width, Screen.height);

		// if in lightning mode make a new timer object
		if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
			timerStart();
		}

	}

	/**
	 * Starts the timer used in lightning mode
	 */
	public void timerStart() {

		int delay = 1000; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				// If the player is out of time stop the timer
				if (!((LightningLevel) kabasuji.getSelectedLevel()).hasTimeLeft()) {
					// stop the timer
					timer.stop();
				} else { // otherwise increment the current time and
							// refresh the gui
					((LightningLevel) kabasuji.getSelectedLevel()).incrementCurrentTime();
					setTimeLeftNum((Integer) ((LightningLevel) kabasuji.getSelectedLevel()).getTimeLeft());
				}
			}
		};
		timer = new Timer(delay, taskPerformer);
		timer.start();

	}

	public void resetTimer() {

		// check if the level is a lightning level
		if (kabasuji.getSelectedLevel() instanceof LightningLevel) {

			if (!((LightningLevel) kabasuji.getSelectedLevel()).hasTimeLeft()) {
				// reset the timer
				// timerStart();
				System.out.println("no time left");
				timer.restart();
			}
		}
	}

	/**
	 * Update the PlayLevelPanel with a new BoardView and BullpenView.
	 * 
	 * @param bv
	 * @param bpv
	 */
	public void updatePlayLevelPanel(BoardView bv, BullpenView bpv) {
		/** adding all buttons/images needed **/
		zoompiece = new JLabelIcon("opaque_canvas.png", (int) (Screen.height * 0.25), (int) (Screen.height * 0.25));
		zoompiece.setLocation((int) (Screen.width * 0.35), (int) (Screen.height * 0.05));
		add(zoompiece);

		fliphbtn = new JLabelIcon("generalbutton.png", 70, 70);
		fliphbtn.setLocation((int) (Screen.width * 0.52) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel fliphlbl = new JLabel("<html>Flip<br>Horizontal</html>", SwingConstants.CENTER);
		fliphlbl.setBounds(0, 0, 70, 70);
		fliphlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		fliphbtn.add(fliphlbl);
		add(fliphbtn);

		flipvbtn = new JLabelIcon("generalbutton.png", 70, 70);
		flipvbtn.setLocation((int) (Screen.width * 0.62) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel flipvlbl = new JLabel("<html>Flip<br>Vertical</html>", SwingConstants.CENTER);
		flipvlbl.setBounds(0, 0, 70, 70);
		flipvlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		flipvbtn.add(flipvlbl);
		add(flipvbtn);

		rotatelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatelbtn.setLocation((int) (Screen.width * 0.52) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatellbl = new JLabel("<html>Rotate<br>Left</html>", SwingConstants.CENTER);
		rotatellbl.setBounds(0, 0, 70, 70);
		rotatellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatelbtn.add(rotatellbl);
		add(rotatelbtn);

		rotaterbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotaterbtn.setLocation((int) (Screen.width * 0.62) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotaterlbl = new JLabel("<html>Rotate<br>Right</html>", SwingConstants.CENTER);
		rotaterlbl.setBounds(0, 0, 70, 70);
		rotaterlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotaterbtn.add(rotaterlbl);
		add(rotaterbtn);

		// display moves left if in puzzle or release mode
		if ((kabasuji.getSelectedLevel() instanceof PuzzleLevel)
				|| (kabasuji.getSelectedLevel() instanceof ReleaseLevel)) {

			// movesLeft Icon
			movesLeft = new JLabel("<html>Moves Left</html>", SwingConstants.CENTER);
			movesLeft.setBounds(0, 0, 150, 50);
			movesLeft.setFont(new Font("Onyx", Font.BOLD, 25));
			movesLeft.setLocation((int) (Screen.width * 0.67) + (int) (movesLeft.getSize().getWidth() / 2),
					(int) (Screen.height * 0.05));
			movesLeft.setForeground(Color.WHITE);
			add(movesLeft);

			System.out.println("end condidition: " + kabasuji.getSelectedLevel().getEndCondition().toString());

			movesLeftNum = new JLabel(kabasuji.getSelectedLevel().getEndCondition().toString(), SwingConstants.CENTER);
			movesLeftNum.setBounds(0, 0, 120, 50);
			movesLeftNum.setFont(new Font("Onyx", Font.BOLD, 40));
			movesLeftNum.setLocation((int) (Screen.width * 0.715) + (int) (movesLeft.getSize().getWidth() / 2),
					(int) (Screen.height * 0.12));
			movesLeftNum.setForeground(Color.WHITE);
			add(movesLeftNum);

		}

		// display time left if in lightning mode
		else if (kabasuji.getSelectedLevel() instanceof LightningLevel) {

			// timeLeft Icon
			timeLeft = new JLabel("<html>Time Left</html>", SwingConstants.CENTER);
			timeLeft.setBounds(0, 0, 150, 50);
			timeLeft.setFont(new Font("Onyx", Font.BOLD, 30));
			timeLeft.setLocation((int) (Screen.width * 0.67) + (int) (timeLeft.getSize().getWidth() / 2),
					(int) (Screen.height * 0.05));
			timeLeft.setForeground(Color.white);
			add(timeLeft);

			// time left amount j label
			timeLeftNum = new JLabel(kabasuji.getSelectedLevel().getEndCondition().toString(), SwingConstants.CENTER);
			timeLeftNum.setBounds(0, 0, 120, 50);
			timeLeftNum.setFont(new Font("Onyx", Font.BOLD, 40));
			timeLeftNum.setLocation((int) (Screen.width * 0.715) + (int) (timeLeft.getSize().getWidth() / 2),
					(int) (Screen.height * 0.12));
			timeLeftNum.setForeground(Color.white);
			add(timeLeftNum);

		}

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.84) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(new GoToMainMenuController(kabasuji, app, mainmenubtn));
		add(mainmenubtn);

		nextlevelbtn = new JLabelIcon("generallockedbutton.png", 70, 70);
		nextlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel nextlevellbl = new JLabel("<html>Next<br>Level</html>", SwingConstants.CENTER);
		nextlevellbl.setBounds(0, 0, 70, 70);
		nextlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		nextlevelbtn.add(nextlevellbl);
		add(nextlevelbtn);

		resetlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		resetlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .73));
		JLabel resetlevellbl = new JLabel("<html>Reset<br>Level</html>", SwingConstants.CENTER);
		resetlevellbl.setBounds(0, 0, 70, 70);
		resetlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		resetlevelbtn.add(resetlevellbl);
		add(resetlevelbtn);

		/** Star JLabelIcon (Initially display no stars ) **/

		// add BoardView and BullpenView elements to PlayLevelPanel
		add(bv);
		add(bpv);
		setBoardView(bv);
		setBullpenView(bpv);

		// setup background canvas **
		background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
	}

	/**
	 * Add controllers to PlayLevelPanel.
	 */
	public void addControllers() {
		rotaterbtn.addMouseListener(new RotateSelectedPieceBullpenController(kabasuji, this, rotaterbtn, true));
		rotatelbtn.addMouseListener(new RotateSelectedPieceBullpenController(kabasuji, this, rotatelbtn, false));
		flipvbtn.addMouseListener(new FlipSelectedPieceBullpenController(kabasuji, this, flipvbtn, true));
		fliphbtn.addMouseListener(new FlipSelectedPieceBullpenController(kabasuji, this, fliphbtn, false));
		resetlevelbtn.addMouseListener(new ResetLevelController(kabasuji, this, resetlevelbtn));
		
		// Don't attach the nextlevelbtn mouse listener yet
		//nextlevelbtn.addMouseListener(new NextLevelController(kabasuji, this, nextlevelbtn));
	}

	/**
	 * Getter for zoom piece.
	 * 
	 * @return
	 */
	public JLabelIcon getZoomPiece() {
		return zoompiece;
	}

	/**
	 * Getter for JLabel movesLeftNum
	 * 
	 * @return
	 */
	public JLabel getMovesLeftNum() {
		return movesLeftNum;
	}

	/**
	 * Setter for JLabel movesLeftNum
	 * 
	 * @return
	 */
	public void setMovesLeftNum(Integer movesLeft) {
		movesLeftNum.setText(movesLeft.toString());
	}

	/**
	 * Getter for JLabel timeLeftNum
	 * 
	 * @return
	 */
	public JLabel getTimeLeftNum() {
		return timeLeftNum;
	}

	/**
	 * Setter for JLabel timeLeftNum
	 * 
	 * @return
	 */
	public void setTimeLeftNum(Integer timeLeft) {
		timeLeftNum.setText(timeLeft.toString());
	}

	/**
	 * Setter for BoardView.
	 * 
	 * @param bv
	 */
	public void setBoardView(BoardView bv) {
		boardview = bv;
		boardview.setupBoard();
		repaint();
	}

	/**
	 * Getter for BoardView.
	 * 
	 * @return
	 */
	public BoardView getBoardView() {
		return boardview;
	}

	/**
	 * Setter for BullpenView.
	 * 
	 * @param bpv
	 */
	public void setBullpenView(BullpenView bpv) {
		bullpenview = bpv;
		bullpenview.setupBullpen();
		repaint();
	}

	/**
	 * Getter for BullpenView.
	 * 
	 * @return
	 */
	public BullpenView getBullpenView() {
		return bullpenview;
	}

	/**
	 * Updates the display to show the correct number of stars
	 */
	public void updateStars() {

		int numStars = board.getStars();
		System.out.println("in star func");

		// draw the correct number of stars
		JLabelIcon[] stars = new JLabelIcon[3];
		for (int i = 0; i < numStars; i++) {
			remove(background);
			stars[i] = new JLabelIcon("star_score.png", 50, 50);
			stars[i].setLocation(
					(int) (nextlevelbtn.getX()
							+ ((int) (Screen.width * 0.84) + (int) (rotatelbtn.getSize().getWidth() / 2)
									- nextlevelbtn.getX()) * (i + 1) / (stars.length)),
					(int) (nextlevelbtn.getY() - (((i + 1) % 2) + 1) * stars[i].getSize().getWidth()));
			add(stars[i]);
			repaint();
		}
		add(background);
	}

	/**
	 * Updates the display to show that the player can now move to the next
	 * level by illuminating the next level button
	 */
	public void updateNextLevel() {

		// Remove the background and then add it later so that the button can be added to the background
		remove(background);
		// Remove the old nextlevelbtn to display the new one
		remove(nextlevelbtn);
		JLabelIcon nextlevelbtn2 = new JLabelIcon("generalbutton.png", 70, 70);
		nextlevelbtn2.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel nextlevellbl2 = new JLabel("<html>Next<br>Level</html>", SwingConstants.CENTER);
		nextlevellbl2.setBounds(0, 0, 70, 70);
		nextlevellbl2.setFont(new Font("Onyx", Font.BOLD, 18));
		nextlevelbtn2.add(nextlevellbl2);
		add(nextlevelbtn2);
		nextlevelbtn2.addMouseListener(new NextLevelController(kabasuji, this, nextlevelbtn2));
		repaint();
		add(background);
	}
}
