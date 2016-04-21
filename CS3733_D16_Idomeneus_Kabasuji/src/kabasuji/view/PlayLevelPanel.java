package kabasuji.view;

import javax.swing.JPanel;

import kabasuji.controller.FlipSelectedPieceBullpenController;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.RotateSelectedPieceBullpenController;
import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PlayLevelPanel extends JPanel {
	/** Entities associated **/
	Kabasuji kabasuji;
	Board board;
	Bullpen bullpen;

	/** Boundaries assoiated **/
	TopLevelApplication app;
	BoardView boardview;
	BullpenView bullpenview;
	
	JLabelIcon zoompiece;
	JLabelIcon rotatelbtn;
	JLabelIcon rotaterbtn;
	JLabelIcon fliphbtn;
	JLabelIcon flipvbtn;

	/**
	 * Construct PlayLevelPanel.
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

	}
	/**
	 * Update the PlayLevelPanel with a new BoardView and BullpenView.
	 * @param bv
	 * @param bpv
	 */
	public void updatePlayLevelPanel(BoardView bv, BullpenView bpv){
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

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.84) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(new GoToMainMenuController(kabasuji, app, mainmenubtn));
		add(mainmenubtn);

		JLabelIcon nextlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		nextlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel nextlevellbl = new JLabel("<html>Next<br>Level</html>", SwingConstants.CENTER);
		nextlevellbl.setBounds(0, 0, 70, 70);
		nextlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		nextlevelbtn.add(nextlevellbl);
		add(nextlevelbtn);

		JLabelIcon resetlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		resetlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatelbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .73));
		JLabel resetlevellbl = new JLabel("<html>Reset<br>Level</html>", SwingConstants.CENTER);
		resetlevellbl.setBounds(0, 0, 70, 70);
		resetlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		resetlevelbtn.add(resetlevellbl);
		add(resetlevelbtn);
		
		
		/** Star JLabelIcon **/
		JLabelIcon[] stars = new JLabelIcon[3];
		for (int i = 0; i < stars.length; i++) {
			stars[i] = new JLabelIcon("star_score.png", 50, 50);
			stars[i].setLocation(
					(int) (nextlevelbtn.getX() + (mainmenubtn.getX() - nextlevelbtn.getX()) * (i + 1) / (stars.length)),
					(int) (nextlevelbtn.getY() - (((i + 1) % 2) + 1) * stars[i].getSize().getWidth()));
			add(stars[i]);
		}
		
		// add BoardView and BullpenView elements to PlayLevelPanel
		add(bv);
		add(bpv);
		setBoardView(bv);
		setBullpenView(bpv);
		
		// setup background canvas **
		JLabelIcon background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
	}
	/**
	 * Add controlers to PlayLevelPanel.
	 */
	public void addControllers(){
		rotaterbtn.addMouseListener(new RotateSelectedPieceBullpenController(kabasuji, this, rotaterbtn, true));
		rotatelbtn.addMouseListener(new RotateSelectedPieceBullpenController(kabasuji, this, rotatelbtn, false));
		flipvbtn.addMouseListener(new FlipSelectedPieceBullpenController(kabasuji, this, flipvbtn, true));
		fliphbtn.addMouseListener(new FlipSelectedPieceBullpenController(kabasuji, this, fliphbtn, false));
	}
	/**
	 * Getter for zoompiece.
	 * @return
	 */
	public JLabelIcon getZoomPiece() {
		return zoompiece;
	}
	/**
	 * Setter for BoardView.
	 * @param bv
	 */
	public void setBoardView(BoardView bv) {
		boardview = bv;
		boardview.setupBoard();
		repaint();
	}
	/**
	 * Getter for BoardView.
	 * @return
	 */
	public BoardView getBoardView() {
		return boardview;
	}
	/**
	 * Setter for BullpenView.
	 * @param bpv
	 */
	public void setBullpenView(BullpenView bpv) {
		bullpenview = bpv;
		bullpenview.setupBullpen();
		repaint();
	}
	/**
	 * Getter for BullpenView.
	 * @return
	 */
	public BullpenView getBullpenView() {
		return bullpenview;
	}
}
