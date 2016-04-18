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
		this.kabasuji = kabasuji;
		this.app = app;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		
		//set up background
		JLabelIcon background = new JLabelIcon("starry_night.jpeg", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		// make a new Bullpen
		Bullpen bullpen1 = new Bullpen();
		
		// make pieces to add to Bullpen
		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, false, 0, 0);
		Tile[][] piece1 = {{testTile1, testTile2,testTile2, testTile2,testTile2, testTile2},
				{testTile1, testTile2,testTile2, testTile2,testTile2, testTile2},
				{testTile1, testTile2,testTile2, testTile2,testTile2, testTile2},
				{testTile1, testTile2,testTile2, testTile2,testTile2, testTile2},
				{testTile1, testTile2,testTile2, testTile2,testTile2, testTile2},
				{testTile1, testTile2,testTile2, testTile2,testTile2, testTile2}};

		Piece[] testset = new Piece[40];
		for (int i = 0; i < testset.length; i++){
			testset[i] = new Piece(piece1);
			bullpen1.addPiece(testset[i]);
		}
		
		// test adding pieces to Bullpen
		
		zoompiece = new JLabelIcon("opaque_canvas.png", (int) (Screen.height * 0.25),
				(int) (Screen.height * 0.25));
		zoompiece.setLocation((int) (Screen.width * 0.35), (int) (Screen.height * 0.05));
		background.add(zoompiece);

		JLabelIcon bullpen = new JLabelIcon("opaque_canvas.png", (int) (Screen.width * 0.25),
				(int) (Screen.height * 0.85));
		bullpen.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.05));
		
		
		this.bullpenview = new BullpenView(bullpen1, bullpen, 4, 10);
		
		background.add(bullpen);
		
		Tile boardTile0_0 = new Tile(false, true, 2, 0);
		Tile boardTile0_1 = new Tile(false, true, 0, 0);
		Tile boardTile0_2 = new Tile(false, true, 0, 0);
		Tile boardTile0_3 = new Tile(false, true, 0, 0);
		Tile boardTile0_4 = new Tile(false, false, 0, 0);
		Tile boardTile1_0 = new Tile(false, true, 0, 0);
		Tile boardTile1_1 = new Tile(false, false, 0, 0);
		Tile boardTile1_2 = new Tile(false, true, 0, 0);
		Tile boardTile1_3 = new Tile(false, true, 0, 0);
		Tile boardTile1_4 = new Tile(false, false, 0, 0);
		Tile boardTile2_0 = new Tile(false, true, 2, 0);
		Tile boardTile2_1 = new Tile(false, true, 0, 0);
		Tile boardTile2_2 = new Tile(false, true, 0, 0);
		Tile boardTile2_3 = new Tile(false, true, 0, 0);
		Tile boardTile2_4 = new Tile(false, false, 0, 0);
		Tile boardTile3_0 = new Tile(false, true, 1, 0);
		Tile boardTile3_1 = new Tile(false, true, 0, 0);
		Tile boardTile3_2 = new Tile(false, true, 3, 0);
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
		JLabelIcon playboard = new JLabelIcon("opaque_canvas.png", (int) (Screen.height *0.54),
				(int) (Screen.height *0.54));
		playboard.setLocation((int)(Screen.width * 0.35), (int) (Screen.height * 0.36));
		
		this.boardview = new BoardView(tboard, playboard);
		// ^ a little weird since we don't actually add the board view to the background
		
		background.add(playboard);

		JLabelIcon fliphbtn = new JLabelIcon("generalbutton.png", 70, 70);
		fliphbtn.setLocation((int) (Screen.width * 0.52) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel fliphlbl = new JLabel("<html>Flip<br>Horizontal</html>", SwingConstants.CENTER);
		fliphlbl.setBounds(0, 0, 70, 70);
		fliphlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		fliphbtn.add(fliphlbl);
		
		background.add(fliphbtn);

		JLabelIcon flipvbtn = new JLabelIcon("generalbutton.png", 70, 70);
		flipvbtn.setLocation((int) (Screen.width * 0.62) + (int) (fliphbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel flipvlbl = new JLabel("<html>Flip<br>Vertical</html>", SwingConstants.CENTER);
		flipvlbl.setBounds(0, 0, 70, 70);
		flipvlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		flipvbtn.add(flipvlbl);
		background.add(flipvbtn);

		JLabelIcon rotatehbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatehbtn.setLocation((int) (Screen.width * 0.52) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatehlbl = new JLabel("<html>Rotate<br>Horizontal</html>", SwingConstants.CENTER);
		rotatehlbl.setBounds(0, 0, 70, 70);
		rotatehlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatehbtn.add(rotatehlbl);
		background.add(rotatehbtn);

		JLabelIcon rotatevbtn = new JLabelIcon("generalbutton.png", 70, 70);
		rotatevbtn.setLocation((int) (Screen.width * 0.62) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel rotatevlbl = new JLabel("<html>Rotate<br>Vertical</html>", SwingConstants.CENTER);
		rotatevlbl.setBounds(0, 0, 70, 70);
		rotatevlbl.setFont(new Font("Onyx", Font.BOLD, 18));
		rotatevbtn.add(rotatevlbl);
		background.add(rotatevbtn);

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.84) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(
				new GoToMainMenuController(kabasuji, app,mainmenubtn));
		background.add(mainmenubtn);

		JLabelIcon nextlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		nextlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatehbtn.getSize().getWidth() / 2),
				(int) (Screen.height * .6));
		JLabel nextlevellbl = new JLabel("<html>Next<br>Level</html>", SwingConstants.CENTER);
		nextlevellbl.setBounds(0, 0, 70, 70);
		nextlevellbl.setFont(new Font("Onyx", Font.BOLD, 18));
		nextlevelbtn.add(nextlevellbl);
		background.add(nextlevelbtn);

		JLabelIcon resetlevelbtn = new JLabelIcon("generalbutton.png", 70, 70);
		resetlevelbtn.setLocation((int) (Screen.width * 0.74) + (int) (rotatehbtn.getSize().getWidth() / 2),
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
	// getter for zoompiece
	public JLabelIcon getZoomPiece(){
		return zoompiece;
	}
	// getter for boardview
	public BoardView getBoardView(){
		return boardview;
	}
	// getter for bullpenview
	public BullpenView getBullpenView(){
		return bullpenview;
	}
}
