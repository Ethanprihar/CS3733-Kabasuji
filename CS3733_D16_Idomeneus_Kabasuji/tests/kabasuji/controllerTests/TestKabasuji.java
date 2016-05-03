package kabasuji.controllerTests;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import kabasuji.Main;
import kabasuji.controller.moves.SelectLevelMove;
import kabasuji.controller.moves.SelectPieceMove;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.PieceView;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.SplashWindow;
import kabasuji.view.TopLevelApplication;
import levelbuilder.view.BuilderLevelMode;
import levelbuilder.view.BuilderMainMenu;

public class TestKabasuji extends TestCaseHelper {
	Kabasuji kabasuji;
	TopLevelApplication frame;

	protected void setup() throws Exception {
		kabasuji = new Kabasuji();
		frame = new TopLevelApplication(kabasuji);
		new SplashWindow();
		frame.setVisible(true);
	}

	protected void tearDown() throws Exception {
		frame.setVisible(false);
		frame.dispose();
	}

	public void testGoToLevelSelect() {
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainMenu test = new MainMenu(kabasuji, frame);

		JLabelIcon testBtn = test.getLevelSelectButton();

		// This test case will take you to the level select screen in kabasuji
		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof LevelSelectPanel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	public void testGoToMainMenu() {
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LevelSelectPanel test = new LevelSelectPanel(kabasuji, frame);

		// This test case will take you back to the main menu
		JLabelIcon mainMenuBtn = test.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(mainMenuBtn, 0, 0);
			mainMenuBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof MainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testSecondLevel() {
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainMenu test = new MainMenu(kabasuji, frame);

		JLabelIcon testBtn = test.getLevelSelectButton();

		// This test case will take you to the level select screen in kabasuji
		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof LevelSelectPanel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LevelSelectPanel levSel = new LevelSelectPanel(kabasuji, frame);
		JLabelIcon firstLevBtn = levSel.getLevelSelectButtons()[0];
		try {
			MouseEvent cp = createPressed(firstLevBtn, 0, 0);
			firstLevBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof PlayLevelPanel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Create a select level move
		SelectLevelMove slm = new SelectLevelMove(1);
		boolean value = slm.valid(kabasuji);
		assertTrue(value);
		
		boolean value1 = slm.execute(kabasuji);
		System.out.println("I am executing kabasuji");
		assertTrue(value1);
		assertTrue(frame.getContentPane() instanceof PlayLevelPanel);
		
		PlayLevelPanel plp = (PlayLevelPanel) frame.getContentPane();
		BullpenView bp = plp.getBullpenView();
		System.out.println(bp.getImgPieces().length);
		
		// Get the boardview
		BoardView bv = plp.getBoardView();
		
		// Get all the image icons for the pieces
		JLabelIcon[] imgPieces = bp.getImgPieces();
		
		// Print the first img information
		System.out.println(imgPieces[0]);
		
		// Create a mouse pressed event on the piece
		MouseEvent cp1 = createPressed(imgPieces[0], 0, 0);
		imgPieces[0].dispatchEvent(cp1);
		
		// Get the first piece in the array of pieces
		Piece selPiece = kabasuji.getSelectedLevel().getBullpen().getPieces().get(0);
		
		// Print the information
		System.out.println(selPiece);
		
		// Print the information of the selected piece
		System.out.println(kabasuji.getSelectedLevel().getBullpen().getSelectedPiece());
		
		// See if the first piece is the same as the selected piece
		System.out.println("Seeing if the selected piece is equal");
		assertEquals(kabasuji.getSelectedLevel().getBullpen().getSelectedPiece(), selPiece);
		
		// Create the SelectPieceMove
		SelectPieceMove spm = new SelectPieceMove(selPiece);
		boolean valueSPM = spm.execute(kabasuji);
		System.out.println(valueSPM);
		
		// Create vertical flip
		JLabelIcon flipBtn = plp.getFlipVertButton();
		MouseEvent cpFlipV = createPressed(flipBtn, 0, 0);
		flipBtn.dispatchEvent(cpFlipV);
		
		// flip the piece horizontally
		JLabelIcon flipHBtn = plp.getFlipHorButton();
		MouseEvent cpFlipH = createPressed(flipHBtn, 0, 0);
		flipHBtn.dispatchEvent(cpFlipH);
		
		// Rotate the piece left
		JLabelIcon rotLBtn = plp.getRotateLeftButton();
		MouseEvent cpRotL = createPressed(rotLBtn, 0, 0);
		rotLBtn.dispatchEvent(cpRotL);
		
		// Rotate the piece right
		JLabelIcon rotRBtn = plp.getRotateRightButton();
		MouseEvent cpRotR = createPressed(rotRBtn, 0, 0);
		rotLBtn.dispatchEvent(cpRotR);
		
		// Reset the level
		JLabelIcon resetBtn = plp.getResetButton();
		MouseEvent cpReset = createPressed(resetBtn, 0, 0);
		resetBtn.dispatchEvent(cpReset);
		
		// Go to the next level
		JLabelIcon nextBtn = plp.getNextLevelButton();
		MouseEvent cpNext = createPressed(nextBtn, 0, 0);
		nextBtn.dispatchEvent(cpNext);
		
		// Go to the main menu
		JLabelIcon mainBtn = plp.getMainMenuButton();
		MouseEvent cpMain = createPressed(mainBtn, 0, 0);
		mainBtn.dispatchEvent(cpMain);
	}

	public void testSelectLevel() {
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LevelSelectPanel test = new LevelSelectPanel(kabasuji, frame);

		// If levels exist, then select the level
		if (kabasuji.getLevels().size() > 0) {
			// Get the level
			JLabelIcon levelSelect[] = test.getLevelSelectButtons();
			try {
				MouseEvent cp = createPressed(levelSelect[0], 0, 0);
				levelSelect[0].dispatchEvent(cp);
				assertTrue(frame.getContentPane() instanceof PlayLevelPanel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Select a piece from bullpen and test rotate and flips
		Bullpen testBullpen = kabasuji.getSelectedLevel().getBullpen();
		// Get a piece in the bullpen
		ArrayList<Piece> testPiece = testBullpen.getPieces();

	}
	
	public void testMain() {
		Main.main(new String[] {"arg1", "arg2", "arg3"});
		Main.makeLevelsForTesting();
		Main.makePieces();
	}
}