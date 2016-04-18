package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Screen;
import kabasuji.model.Tile;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;

/**
 * Controller for Moving Screens; Go To Play Level Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class SelectLevelController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	int level;
	Kabasuji kabasuji;
	TopLevelApplication app;
	JPanel contentPanel;
	JLabelIcon button;
	String fn;

	public SelectLevelController(Kabasuji kabasuji, TopLevelApplication app, JLabelIcon button, int level) {
		this.kabasuji = kabasuji;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.button = button;
		this.fn = button.getFileName();
		this.level = level;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// Created SelectLevelMove and input desired level integer
		SelectLevelMove slm = new SelectLevelMove(level);
		// Created ChangeScreenMove and input desired screen
		ChangeScreenMove gtsm = new ChangeScreenMove(Screen.PlayLevel);
		// kabasuji.selectedLevel = kabasuji.getLevels().get(0);
		
		// make a new Bullpen
		Bullpen bullpen = new Bullpen();

		// make pieces to add to Bullpen
		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, false, 0, 0);
		Tile[][] piece1 = { { testTile1, testTile2, testTile2, testTile2, testTile2, testTile2 },
				{ testTile1, testTile2, testTile2, testTile2, testTile2, testTile2 },
				{ testTile1, testTile2, testTile2, testTile2, testTile2, testTile2 },
				{ testTile1, testTile2, testTile2, testTile2, testTile2, testTile2 },
				{ testTile1, testTile2, testTile2, testTile2, testTile2, testTile2 },
				{ testTile1, testTile2, testTile2, testTile2, testTile2, testTile2 } };

		Piece[] testset = new Piece[40];
		for (int i = 0; i < testset.length; i++) {
			testset[i] = new Piece(piece1);
			bullpen.addPiece(testset[i]);
		}

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
		Tile[][] tiles = { { boardTile0_0, boardTile0_1, boardTile0_2, boardTile0_3, boardTile0_4 },
				{ boardTile1_0, boardTile1_1, boardTile1_2, boardTile1_3, boardTile1_4 },
				{ boardTile2_0, boardTile2_1, boardTile2_2, boardTile2_3, boardTile2_4 },
				{ boardTile3_0, boardTile3_1, boardTile3_2, boardTile3_3, boardTile3_4 },
				{ boardTile4_0, boardTile4_1, boardTile4_2, boardTile4_3, boardTile4_4 } };
		PuzzleBoard tboard = new PuzzleBoard(tiles);

		// Attempt to execute action on model
		if (slm.execute(kabasuji)) {
			gtsm.execute(kabasuji);
			// Created JPanel screen object and update boundary to reflect
			// changes
			BoardView bv = new BoardView(tboard);
			bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
					(int) (Screen.height * 0.54));
			
			BullpenView bpv = new BullpenView(bullpen, 4, 6);
			bpv.setSize((int) (Screen.width * 0.25), (int) (Screen.height * 0.85));
			bpv.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.05));
			
			PlayLevelPanel lsp = new PlayLevelPanel(kabasuji, app);
			lsp.add(bv);
			lsp.add(bpv);
			lsp.updatePlayLevelPanel(bv, bpv);
			
			lsp.repaint();
			

			app.setContentPanel(lsp);
		}
	}

	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
