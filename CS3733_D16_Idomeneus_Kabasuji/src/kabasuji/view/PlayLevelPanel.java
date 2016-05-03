package kabasuji.view;

import javax.swing.JPanel;
import kabasuji.controller.BullpenController;
import kabasuji.controller.ExitTestLevelWindowController;
import kabasuji.controller.FlipSelectedPieceBullpenController;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.NextLevelController;
import kabasuji.controller.ResetLevelController;
import kabasuji.controller.RotateSelectedPieceBullpenController;
import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Level;
import kabasuji.model.LightningLevel;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Screen;
import misc.MusicPlayer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * Main Gameplay window; all games happen here regardless of type.
 * 
 * @author jwu
 *
 */
public class PlayLevelPanel extends JPanel {
	/** Entities associated **/
	Kabasuji kabasuji;
	Board board;
	Bullpen bullpen;
	int type;

	PlayLevelPanel panel;

	Timer timer; // Timer used for Lightning Mode
	int delay = 1000; // milliseconds

	MusicPlayer mp;

	/** Boundaries associated **/
	TopLevelApplication app;
	BoardView boardview;
	BullpenView bullpenview;

	ZoomPanel zoompanel;
	JLabelIcon rotatelbtn;
	JLabelIcon rotaterbtn;
	JLabelIcon fliphbtn;
	JLabelIcon flipvbtn;

	JLabelIcon resetlevelbtn;
	JLabelIcon nextlevelbtn;
	JLabelIcon mainmenubtn;

	JLabel movesLeft;
	JLabel movesLeftNum;
	JLabel timeLeft;
	JLabel timeLeftNum;

	JLabelIcon background;

	/** button parameters **/
	int btnsidelength = 70;

	/**
	 * Construct PlayLevelPanel.
	 * 
	 * @param kabasuji
	 * @param app
	 */
	public PlayLevelPanel(Kabasuji kabasuji, TopLevelApplication app, int type) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.type = type;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();

		// set layout null
		setLayout(null);
		setBounds(0, 0, Screen.width, Screen.height);

		// setup timer
		setupTimer();

		// setup background
		background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);

	}

	/**
	 * Update the PlayLevelPanel with a new BoardView and BullpenView.
	 * 
	 * @param bv
	 *            boardview
	 * @param bpv
	 *            bullpenview
	 */
	public void updatePlayLevelPanel(BoardView bv, BullpenView bpv) {
		/** adding all buttons/images needed **/
		zoompanel = new ZoomPanel("opaque_canvas.png", (int) (Screen.height * 0.25), (int) (Screen.height * 0.25));
		zoompanel.setLocation((int) (Screen.width * 0.35), (int) (Screen.height * 0.05));
		add(zoompanel);

		// create a flip horizontal button
		fliphbtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Flip" + "<br>" + "Horizontal");
		fliphbtn.setLocation((int) (Screen.width * 0.52) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		add(fliphbtn);

		// create a flip vertical button
		flipvbtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Flip" + "<br>" + "Vertical");
		flipvbtn.setLocation((int) (Screen.width * 0.62) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		add(flipvbtn);

		// create a rotate left button
		rotatelbtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Rotate" + "<br>" + "Left");
		rotatelbtn.setLocation((int) (Screen.width * 0.52) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		add(rotatelbtn);

		// create a rotate right button
		rotaterbtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Rotate" + "<br>" + "Right");
		rotaterbtn.setLocation((int) (Screen.width * 0.62) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		add(rotaterbtn);

		if (type == 0) {
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

				movesLeftNum = new JLabel(kabasuji.getSelectedLevel().getEndCondition().toString(),
						SwingConstants.CENTER);
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
				timeLeftNum = new JLabel(kabasuji.getSelectedLevel().getEndCondition().toString(),
						SwingConstants.CENTER);
				timeLeftNum.setBounds(0, 0, 120, 50);
				timeLeftNum.setFont(new Font("Onyx", Font.BOLD, 40));
				timeLeftNum.setLocation((int) (Screen.width * 0.715) + (int) (timeLeft.getSize().getWidth() / 2),
						(int) (Screen.height * 0.12));
				timeLeftNum.setForeground(Color.white);
				add(timeLeftNum);
			}
		}

		if (type == 0) {
			nextlevelbtn = new JLabelIcon("generallockedbutton.png", btnsidelength, btnsidelength,
					"Next" + "<br>" + "Level");
			nextlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
					(int) (Screen.height * .6));
			add(nextlevelbtn);

			resetlevelbtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength,
					"Reset" + "<br>" + "Level");
			resetlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
					(int) (Screen.height * .73));
			add(resetlevelbtn);

			mainmenubtn = new JLabelIcon("generalbutton.png", btnsidelength, btnsidelength, "Main" + "<br>" + "Menu");
			mainmenubtn.setLocation((int) (Screen.width * 0.84) + (int) (rotatelbtn.getSize().getWidth() / 2),
					(int) (Screen.height * .6));
			mainmenubtn.addMouseListener(new GoToMainMenuController(kabasuji, app, mainmenubtn));
			add(mainmenubtn);
		}

		add(bv);
		add(bpv);
		setBoardView(bv);
		setBullpenView(bpv);

		// setup background canvas **
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
		if (type == 0) {
			resetlevelbtn.addMouseListener(new ResetLevelController(kabasuji, this, resetlevelbtn));
		}
		bullpenview.addMouseListener(new BullpenController(kabasuji, this));
	}

	/**
	 * Getter for zoom piece.
	 * 
	 * @return zoompanel
	 */
	public ZoomPanel getZoomPanel() {
		return zoompanel;
	}

	/**
	 * Removes all components from zoompanel and updates.
	 */
	public void clearZoomPanel() {
		zoompanel.removeAll();
		zoompanel.repaint();
	}

	/**
	 * Display lose screen when player has lost.
	 */
	public void displayLoseScreen() {
		// Only if it is loaded in the player mode not the test level builder
		if (type == 0) {
			if ((kabasuji.getSelectedLevel().getStars()) == 0) {
				this.losingScreen();
			}
		}
	}

	/********************* TIMER *************************/
	/**
	 * Setup Global Panel Timer object.
	 */
	public void setupTimer() {
		// create repeated task for timer
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				// If the player is out of time stop the timer
				if (!((LightningLevel) kabasuji.getSelectedLevel()).hasTimeLeft()) {
					// stop the timer
					timer.stop();
					displayLoseScreen();
				} else { // otherwise increment the current time and
							// refresh the gui
					((LightningLevel) kabasuji.getSelectedLevel()).incrementCurrentTime();
					setTimeLeftNum((Integer) ((LightningLevel) kabasuji.getSelectedLevel()).getTimeLeft());
				}
			}
		};
		// create timer object
		timer = new Timer(delay, taskPerformer);
	}

	/**
	 * Starts the timer used in lightning mode.
	 */
	public void timerStart() {
		// start the timer
		timer.start();

	}

	/*
	 * Stops timer.
	 */
	public void stopTimer() {
		// check if the timer is null
		if (timer != null) {
			timer.stop();
		}
	}

	/**
	 * Reset timer.
	 */
	public void resetTimer() {

		// check if the level is a lightning level
		if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
			timer.stop(); // stop the old timer
			timer.restart();
		}
	}

	/**
	 * Start timer for LightningLevel.
	 */
	public void startTimeLimit() {
		// if in lightning mode make a new timer object
		if (type == 0) {
			if (kabasuji.getSelectedLevel() instanceof LightningLevel) {
				timerStart();
			}
		}
	}

	/*********************** END OF TIMER ********************/
	/**
	 * Getter for JLabel timeLeftNum
	 * 
	 * @return time left
	 */
	public JLabel getTimeLeftNum() {
		return timeLeftNum;
	}

	/**
	 * Setter for Timer.
	 * 
	 * @param timeLeft
	 */
	public void setTimeLeftNum(Integer timeLeft) {
		if (type == 0) {
			int numStars = kabasuji.getSelectedLevel().getBoard().getStars();
			if (timeLeft == 10 && numStars < 3) {
				mp = new MusicPlayer("timebomb10s.wav");
				mp.setVolume(-10);
			}
			if (timeLeft <= 10) {
				timeLeftNum.setForeground(Color.YELLOW);
			}
			if (timeLeft <= 5) {
				timeLeftNum.setForeground(Color.RED);
			}
			timeLeftNum.setText(timeLeft.toString());
		}
	}

	/**
	 * Getter for JLabel movesLeftNum
	 * 
	 * @return moves left
	 */
	public JLabel getMovesLeftNum() {
		return movesLeftNum;
	}

	/**
	 * Setter for Moves left.
	 * 
	 * @param movesLeft
	 */
	public void setMovesLeftNum(Integer movesLeft) {
		if (type == 0) {
			int numStars = kabasuji.getSelectedLevel().getBoard().getStars();
			if (movesLeft == 10 && numStars < 3) {
				movesLeftNum.setForeground(Color.YELLOW);
			}
			if (movesLeft <= 5) {
				movesLeftNum.setForeground(Color.RED);
			}
			movesLeftNum.setText(movesLeft.toString());
		}
	}

	/**
	 * Setter for BoardView.
	 * 
	 * @param bv boardview
	 */
	public void setBoardView(BoardView bv) {
		boardview = bv;
		boardview.setupBoard();
		repaint();
	}

	/**
	 * Getter for BoardView.
	 * 
	 * @return boardview
	 */
	public BoardView getBoardView() {
		return boardview;
	}

	/**
	 * Setter for BullpenView.
	 * 
	 * @param bpv bullpenview
	 */
	public void setBullpenView(BullpenView bpv) {
		bullpenview = bpv;
		bullpenview.setupBullpen();
		repaint();
	}

	/**
	 * Getter for BullpenView.
	 * 
	 * @return bullpenview
	 */
	public BullpenView getBullpenView() {
		return bullpenview;
	}

	/**
	 * Updates the display to show the correct number of stars.
	 */
	public void updateStars() {

		int numStars = kabasuji.getSelectedLevel().getBoard().getStars();
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

		// Remove the background and then add it later so that the button can be
		// added to the background
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

	/**
	 * Getter for timer.
	 * 
	 * @return timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Display win screen when player has fully completed level.
	 */
	public void winningScreen() {

		// Only execute if it is in the player mode
		if (type == 0) {
			removeAll();
			// setup background canvas
			JLabelIcon background = new JLabelIcon("winningScreen.jpg", Screen.width, Screen.height);
			background.setBounds(0, 0, Screen.width, Screen.height);
			add(background);

			// create a main menu button
			remove(background);
			JLabelIcon mainMenuButton = new JLabelIcon("general3button.png", btnsidelength, btnsidelength,
					"Main" + "<br>" + "Menu");
			mainMenuButton.setLocation((int) (Screen.width * 0.80) + (int) (mainMenuButton.getSize().getWidth() / 2),
					(int) (Screen.height * 0.18));
			mainMenuButton.addMouseListener(new GoToMainMenuController(kabasuji, app, mainMenuButton));
			add(mainMenuButton);

			// create a next level button
			JLabelIcon nextLevelButton = new JLabelIcon("general3button.png", btnsidelength, btnsidelength,
					"Next" + "<br>" + "Level");
			nextLevelButton.setLocation((int) (Screen.width * 0.80) + (int) (nextLevelButton.getSize().getWidth() / 2),
					(int) (Screen.height * 0.40));
			nextLevelButton.addMouseListener(new NextLevelController(kabasuji, this, nextLevelButton));
			add(nextLevelButton);

			repaint();
			add(background);
		} else {
			// setup background canvas
			JLabelIcon background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
			background.setBounds(0, 0, Screen.width, Screen.height);
			add(background);
		}
	}

	/**
	 * Display lose screen when player has lost.
	 */
	public void losingScreen() {

		// Only execute if it is in the player mode
		if (type == 0) {
			removeAll();
			// setup background canvas
			JLabelIcon background = new JLabelIcon("LosingScreen.jpg", Screen.width, Screen.height);
			background.setBounds(0, 0, Screen.width, Screen.height);
			add(background);

			// create a main menu button
			remove(background);
			JLabelIcon mainMenuButton = new JLabelIcon("general3button.png", btnsidelength, btnsidelength,
					"Main" + "<br>" + "Menu");
			mainMenuButton.setLocation((int) (Screen.width * 0.85) + (int) (mainMenuButton.getSize().getWidth() / 2),
					(int) (Screen.height * 0.18));
			mainMenuButton.addMouseListener(new GoToMainMenuController(kabasuji, app, mainMenuButton));
			add(mainMenuButton);

			repaint();
			add(background);
			new MusicPlayer("gameover.wav");
		} else {
			// setup background canvas
			JLabelIcon background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
			background.setBounds(0, 0, Screen.width, Screen.height);
			add(background);
		}
	}

	// Add an exit button
	public void exitScreen(JFrame frame) {

		if (type == 1) {
			remove(background);
			JLabelIcon returnBtn = new JLabelIcon("generalbutton.png", 70, 70);
			returnBtn.setLocation((int) (Screen.width * 0.80) + (int) (rotatelbtn.getSize().getWidth() / 2),
					(int) (Screen.height * .6));
			JLabel returnLbl = new JLabel("<html>Exit</html>", SwingConstants.CENTER);
			returnLbl.setBounds(0, 0, 70, 70);
			returnLbl.setFont(new Font("Onyx", Font.BOLD, 18));
			returnBtn.add(returnLbl);
			returnBtn.addMouseListener(new ExitTestLevelWindowController(frame, returnBtn));
			add(returnBtn);
			repaint();
			add(background);
		}
	}

	/**
	 * Getter for musicplayer.
	 * 
	 * @return musicplayer
	 */
	public MusicPlayer getMP() {
		return mp;
	}

	/**
	 * Getter for Rotate Left Button.
	 * 
	 * @return rotate button view
	 */
	public JLabelIcon getRotateLeftButton() {
		return rotatelbtn;
	}

	/**
	 * Getter for Rotate Right Button.
	 * 
	 * @return rotate button view
	 */
	public JLabelIcon getRotateRightButton() {
		return rotaterbtn;
	}

	/**
	 * Getter for Flip Horizontal Button.
	 * 
	 * @return flip button view
	 */
	public JLabelIcon getFlipHorButton() {
		return fliphbtn;
	}

	/**
	 * Getter for Flip Vertical Button.
	 * 
	 * @return flip button view
	 */
	public JLabelIcon getFlipVertButton() {
		return flipvbtn;
	}

	/**
	 * Get Reset Level Button.
	 * 
	 * @return reset button view
	 */
	public JLabelIcon getResetButton() {
		return resetlevelbtn;
	}

	/**
	 * Get Next Level Button.
	 * 
	 * @return next level button view
	 */
	public JLabelIcon getNextLevelButton() {
		return nextlevelbtn;
	}

	/**
	 * Get Main Menu Button.
	 * 
	 * @return main menu button view
	 */
	public JLabelIcon getMainMenuButton() {
		return mainmenubtn;
	}
}
