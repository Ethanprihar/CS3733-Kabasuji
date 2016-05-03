package kabasuji.controllerTests;

import javax.swing.JComponent;
import javax.swing.JTextField;

import java.awt.event.MouseEvent;

import kabasuji.model.Builder;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.Screen;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.JLabelIcon;
import kabasuji.view.SplashWindow;
import levelbuilder.view.TopLevelApplicationBuilder;
import levelbuilder.view.BuilderLevelMode;
import levelbuilder.view.BuilderLevelSelect;
import levelbuilder.view.BuilderLightningLevelPanel;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.BuilderPuzzleLevelPanel;
import levelbuilder.view.BuilderReleaseLevelPanel;

public class TestBuilder extends TestCaseHelper {
	TopLevelApplicationBuilder frame;
	Builder builder;

	protected void setup() throws Exception {
		builder = new Builder();
		frame = new TopLevelApplicationBuilder(builder);
		new SplashWindow();
		// frame.setVisible(true);
	}

	protected void tearDown() throws Exception {
		frame.setVisible(false);
		frame.dispose();
	}

	/**
	 * Tests returning to the main menu from each of the screens
	 */
	public void testReturnToMainMenu() {

		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuilderMainMenu test = new BuilderMainMenu(builder, frame);

		JLabelIcon testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BuilderLevelMode testbm = new BuilderLevelMode(builder, frame);

		// return to the main menu
		JLabelIcon returnMainBtn = testbm.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(returnMainBtn, 0, 0);
			returnMainBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon puzzTest = testbm.getPuzzleButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(puzzTest, 0, 0);
			puzzTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderPuzzleLevelPanel);

		// return to the main menu
		BuilderPuzzleLevelPanel testPuzzLev = new BuilderPuzzleLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		JLabelIcon mainMenuBtn = testPuzzLev.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(mainMenuBtn, 0, 0);
			mainMenuBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are now back at the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		testbm = new BuilderLevelMode(builder, frame);

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon lightTest = testbm.getLightningButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(lightTest, 0, 0);
			lightTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderLightningLevelPanel);

		// return to the main menu
		BuilderLightningLevelPanel testlightLev = new BuilderLightningLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		mainMenuBtn = testlightLev.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(mainMenuBtn, 0, 0);
			mainMenuBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are now back at the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		/*
		 * Make a release level and then return to the main menu
		 */

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		testbm = new BuilderLevelMode(builder, frame);

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon releaseTest = testbm.getReleaseButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(releaseTest, 0, 0);
			releaseTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderReleaseLevelPanel);

		// return to the main menu
		BuilderReleaseLevelPanel testReleaseLev = new BuilderReleaseLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		mainMenuBtn = testReleaseLev.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(mainMenuBtn, 0, 0);
			mainMenuBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are now back at the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

	}

	public void testDeleteLevel() {

		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuilderMainMenu test = new BuilderMainMenu(builder, frame);

		JLabelIcon testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BuilderLevelMode testbm = new BuilderLevelMode(builder, frame);

		// return to the main menu
		JLabelIcon returnMainBtn = testbm.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(returnMainBtn, 0, 0);
			returnMainBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon puzzTest = testbm.getPuzzleButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(puzzTest, 0, 0);
			puzzTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderPuzzleLevelPanel);

		// return to the main menu
		BuilderPuzzleLevelPanel testPuzzLev = new BuilderPuzzleLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		JLabelIcon deleteBtn = testPuzzLev.getDeleteButton();

		try {
			MouseEvent cp = createPressed(deleteBtn, 0, 0);
			deleteBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are now back at the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		testbm = new BuilderLevelMode(builder, frame);

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon lightTest = testbm.getLightningButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(lightTest, 0, 0);
			lightTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderLightningLevelPanel);

		// return to the main menu
		BuilderLightningLevelPanel testlightLev = new BuilderLightningLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		deleteBtn = testlightLev.getDeleteButton();

		try {
			MouseEvent cp = createPressed(deleteBtn, 0, 0);
			deleteBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are now back at the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		/*
		 * Make a release level and then return to the main menu
		 */

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		testbm = new BuilderLevelMode(builder, frame);

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon releaseTest = testbm.getReleaseButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(releaseTest, 0, 0);
			releaseTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderReleaseLevelPanel);

		// return to the main menu
		BuilderReleaseLevelPanel testReleaseLev = new BuilderReleaseLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		deleteBtn = testReleaseLev.getDeleteButton();

		try {
			MouseEvent cp = createPressed(deleteBtn, 0, 0);
			deleteBtn.dispatchEvent(cp);
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

	public void testSavePuzzLevel() {

		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuilderMainMenu test = new BuilderMainMenu(builder, frame);

		JLabelIcon testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BuilderLevelMode testbm = new BuilderLevelMode(builder, frame);

		// return to the main menu
		JLabelIcon returnMainBtn = testbm.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(returnMainBtn, 0, 0);
			returnMainBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon puzzTest = testbm.getPuzzleButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(puzzTest, 0, 0);
			puzzTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderPuzzleLevelPanel);

		BuilderPuzzleLevelPanel testPuzzLev = new BuilderPuzzleLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		// set the number of moves to 6
		testPuzzLev.setNumMoves("6");

		// check that there are no straight pieces currently
		assertEquals(testPuzzLev.getNumStrightPieces(), "0");

		// add a straight piece
		// JLabelIcon pieceBtn = testPuzzLev.getStraightPiece();
		JLabelIcon pieceBtn = testPuzzLev.getFirstRowPieces()[6];

		// try adding the new piece
		try {
			MouseEvent cp = createPressed(pieceBtn, 0, 0);
			pieceBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece was added
		System.out.println("num straight pieces: ");
		System.out.println(testPuzzLev.getNumStrightPieces());
		assertEquals(testPuzzLev.getNumStrightPieces(), "1");
		assertEquals(testPuzzLev.getNumPieces(5), "0");
		assertEquals(testPuzzLev.getNumPieces(4), "0");
		assertEquals(testPuzzLev.getNumPieces(3), "0");
		assertEquals(testPuzzLev.getNumPieces(2), "0");
		assertEquals(testPuzzLev.getNumPieces(6), "1");
		assertEquals(testPuzzLev.getNumPieces(7), "0");

		assertEquals(builder.getNum(6), 1);

		// try undoing the last move
		JLabelIcon undoBtn = testPuzzLev.getUndoButton();
		try {
			MouseEvent cp = createPressed(undoBtn, 0, 0);
			undoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece count is back at 0
		assertEquals(testPuzzLev.getNumPieces(6), "0");
		assertEquals(testPuzzLev.getNumStrightPieces(), "0");

		// try redoing the add piece
		JLabelIcon redoBtn = testPuzzLev.getRedoButton();
		try {
			MouseEvent cp = createPressed(redoBtn, 0, 0);
			redoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece count is back at 1
		assertEquals(testPuzzLev.getNumPieces(6), "1");
		assertEquals(testPuzzLev.getNumStrightPieces(), "1");

		// add 5 more of the pieces
		for (int i = 0; i < 5; i++) {
			// try adding the new piece
			try {
				MouseEvent cp = createPressed(pieceBtn, 0, 0);
				pieceBtn.dispatchEvent(cp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// add a tile hint
		builder.getSelectedLevel().getBoard().getTile(0, 0).setHint(true);

		// check that it is a hint tile
		assertTrue(builder.getSelectedLevel().getBoard().getTile(0, 0).isHint());

		// trying making a tile invalid
		builder.getSelectedLevel().getBoard().getTile(0, 1).setValid(false);

		// check that the tile is not valid
		assertFalse(builder.getSelectedLevel().getBoard().getTile(0, 1).isValid());

		// check that there are now 6 straight pieces in the bullpen
		assertEquals(testPuzzLev.getNumPieces(6), "6");
		assertEquals(testPuzzLev.getNumStrightPieces(), "6");

		// try testing the level
		JLabelIcon testBtn1 = testPuzzLev.getTestButton();
		try {
			MouseEvent cp = createPressed(testBtn1, 0, 0);
			testBtn1.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try saving the level
		JLabelIcon saveBtn = testPuzzLev.getSaveButton();
		try {
			MouseEvent cp = createPressed(saveBtn, 0, 0);
			saveBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are returned to the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		test = new BuilderMainMenu(builder, frame);

		JLabelIcon loadBtn = test.getLoadButton();

		try {
			MouseEvent cp = createPressed(loadBtn, 0, 0);
			loadBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// load the first level
		BuilderLevelSelect levSelect = new BuilderLevelSelect(builder, frame);

		// try returning to the main menu
		JLabelIcon gotomain = levSelect.getMainMenuButton();
		try {
			MouseEvent cp = createPressed(gotomain, 0, 0);
			gotomain.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		loadBtn = test.getLoadButton();

		try {
			MouseEvent cp = createPressed(loadBtn, 0, 0);
			loadBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// load the first level
		levSelect = new BuilderLevelSelect(builder, frame);

		JLabelIcon firstLev = levSelect.getLevelSelectButton(0);
		try {
			MouseEvent cp = createPressed(firstLev, 0, 0);
			firstLev.dispatchEvent(cp);
			// assertTrue(frame.getContentPane() instanceof
			// BuilderPuzzleLevelPanel);
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

	/**
	 * Tests saving a lightning level
	 */
	public void testSaveLightLevel() {

		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuilderMainMenu test = new BuilderMainMenu(builder, frame);

		JLabelIcon testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BuilderLevelMode testbm = new BuilderLevelMode(builder, frame);

		// return to the main menu
		JLabelIcon returnMainBtn = testbm.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(returnMainBtn, 0, 0);
			returnMainBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon lightTest = testbm.getLightningButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(lightTest, 0, 0);
			lightTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderLightningLevelPanel);

		BuilderLightningLevelPanel testLightLev = new BuilderLightningLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		// set the number of moves to 6
		testLightLev.setTime("20");

		// add a straight piece
		// JLabelIcon pieceBtn = testPuzzLev.getStraightPiece();
		JLabelIcon pieceBtn = testLightLev.getFirstRowPieces()[6];

		// try adding the new piece
		try {
			MouseEvent cp = createPressed(pieceBtn, 0, 0);
			pieceBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece was added
		assertEquals(testLightLev.getNumPieces(5), "0");
		assertEquals(testLightLev.getNumPieces(4), "0");
		assertEquals(testLightLev.getNumPieces(3), "0");
		assertEquals(testLightLev.getNumPieces(2), "0");
		assertEquals(testLightLev.getNumPieces(6), "1");
		assertEquals(testLightLev.getNumPieces(7), "0");

		assertEquals(builder.getNum(6), 1);

		// try undoing the last move
		JLabelIcon undoBtn = testLightLev.getUndoButton();
		try {
			MouseEvent cp = createPressed(undoBtn, 0, 0);
			undoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece count is back at 0
		assertEquals(testLightLev.getNumPieces(6), "0");

		// try redoing the add piece
		JLabelIcon redoBtn = testLightLev.getRedoButton();
		try {
			MouseEvent cp = createPressed(redoBtn, 0, 0);
			redoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece count is back at 1
		assertEquals(testLightLev.getNumPieces(6), "1");

		// add 5 more of the pieces
		for (int i = 0; i < 5; i++) {
			// try adding the new piece
			try {
				MouseEvent cp = createPressed(pieceBtn, 0, 0);
				pieceBtn.dispatchEvent(cp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// check that there are now 6 straight pieces in the bullpen
		assertEquals(testLightLev.getNumPieces(6), "6");

		// try testing the level
		JLabelIcon testBtn1 = testLightLev.getTestButton();
		try {
			MouseEvent cp = createPressed(testBtn1, 0, 0);
			testBtn1.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try saving the level
		JLabelIcon saveBtn = testLightLev.getSaveButton();
		try {
			MouseEvent cp = createPressed(saveBtn, 0, 0);
			saveBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are returned to the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		test = new BuilderMainMenu(builder, frame);

		JLabelIcon loadBtn = test.getLoadButton();

		try {
			MouseEvent cp = createPressed(loadBtn, 0, 0);
			loadBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// load the first level
		BuilderLevelSelect levSelect = new BuilderLevelSelect(builder, frame);

		// try returning to the main menu
		JLabelIcon gotomain = levSelect.getMainMenuButton();
		try {
			MouseEvent cp = createPressed(gotomain, 0, 0);
			gotomain.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		loadBtn = test.getLoadButton();

		try {
			MouseEvent cp = createPressed(loadBtn, 0, 0);
			loadBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// load the first level
		levSelect = new BuilderLevelSelect(builder, frame);

		JLabelIcon firstLev = levSelect.getLevelSelectButton(0);
		try {
			MouseEvent cp = createPressed(firstLev, 0, 0);
			firstLev.dispatchEvent(cp);
			// assertTrue(frame.getContentPane() instanceof
			// BuilderLightningLevelPanel);
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

	/**
	 * Tests making a release level
	 * 
	 */

	/**
	 * Tests saving a Release level
	 */
	public void testSaveReleaseLevel() {

		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BuilderMainMenu test = new BuilderMainMenu(builder, frame);

		JLabelIcon testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BuilderLevelMode testbm = new BuilderLevelMode(builder, frame);

		// return to the main menu
		JLabelIcon returnMainBtn = testbm.getMainMenuButton();

		try {
			MouseEvent cp = createPressed(returnMainBtn, 0, 0);
			returnMainBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		testBtn = test.getBuildButton();

		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add in the size of the board
		try {
			testbm.setBoardDimensionsTextBox("6");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// test that the text has been updated
		assertEquals(testbm.getBoardDimensionsTextBox().getText(), "6");

		JLabelIcon releaseTest = testbm.getReleaseButton();

		// try making a puzzle level
		try {
			MouseEvent cp = createPressed(releaseTest, 0, 0);
			releaseTest.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(frame.getContentPane() instanceof BuilderReleaseLevelPanel);

		BuilderReleaseLevelPanel testReleaseLev = new BuilderReleaseLevelPanel(builder, frame,
				testbm.getBoardDimensionsTextBox());

		// add a straight piece
		// JLabelIcon pieceBtn = testPuzzLev.getStraightPiece();
		JLabelIcon pieceBtn = testReleaseLev.getFirstRowPieces()[6];

		// try adding the new piece
		try {
			MouseEvent cp = createPressed(pieceBtn, 0, 0);
			pieceBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece was added
		assertEquals(testReleaseLev.getNumPieces(5), "0");
		assertEquals(testReleaseLev.getNumPieces(4), "0");
		assertEquals(testReleaseLev.getNumPieces(3), "0");
		assertEquals(testReleaseLev.getNumPieces(2), "0");
		assertEquals(testReleaseLev.getNumPieces(6), "1");
		assertEquals(testReleaseLev.getNumPieces(7), "0");

		assertEquals(builder.getNum(6), 1);

		// try undoing the last move
		JLabelIcon undoBtn = testReleaseLev.getUndoButton();
		try {
			MouseEvent cp = createPressed(undoBtn, 0, 0);
			undoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece count is back at 0
		assertEquals(testReleaseLev.getNumPieces(6), "0");

		// try redoing the add piece
		JLabelIcon redoBtn = testReleaseLev.getRedoButton();
		try {
			MouseEvent cp = createPressed(redoBtn, 0, 0);
			redoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that the piece count is back at 1
		assertEquals(testReleaseLev.getNumPieces(6), "1");

		// add 5 more of the pieces
		for (int i = 0; i < 5; i++) {
			// try adding the new piece
			try {
				MouseEvent cp = createPressed(pieceBtn, 0, 0);
				pieceBtn.dispatchEvent(cp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// check that there are now 6 straight pieces in the bullpen
		assertEquals(testReleaseLev.getNumPieces(6), "6");

		// try testing the level
		JLabelIcon testBtn1 = testReleaseLev.getTestButton();
		try {
			MouseEvent cp = createPressed(testBtn1, 0, 0);
			testBtn1.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// set the number of moves
		testReleaseLev.setNumMoves("6");
		
		// try adding a hint tile
		JLabelIcon tile10 = testReleaseLev.getBoardview().getTiles()[0];
		try {
			MouseEvent cp = createRightClick(tile10, 0, 0);
			tile10.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(builder.getSelectedLevel().getBoard().getTile(0, 0).isHint());
		
		// make the tile invalid now
		try {
			MouseEvent cp = createRightClick(tile10, 0, 0);
			tile10.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			MouseEvent cp = createLeftClick(tile10, 0, 0);
			tile10.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add a red 1 onto tile[0][0]
		JLabelIcon tile00 = testReleaseLev.getBoardview().getTiles()[0];
		try {
			MouseEvent cp = createPressed(tile00, 0, 0);
			tile00.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		// add a blue 2 onto tile1
		JLabelIcon blueBtn = testReleaseLev.getColorButton2();
		try {
			MouseEvent cp = createPressed(blueBtn, 0, 0);
			blueBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabelIcon twoBtn = testReleaseLev.getNumButton(2);
		try {
			MouseEvent cp = createPressed(twoBtn, 0, 0);
			twoBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabelIcon tile1 = testReleaseLev.getBoardview().getTiles()[1];
		try {
			MouseEvent cp = createPressed(tile1, 0, 0);
			tile1.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// deselect a color
		JLabelIcon clearButton = testReleaseLev.getClearColorButton();
		try {
			MouseEvent cp = createPressed(clearButton, 0, 0);
			clearButton.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add a yellow 3 onto tile1
		JLabelIcon yellowBtn = testReleaseLev.getColorButton3();
		try {
			MouseEvent cp = createPressed(yellowBtn, 0, 0);
			yellowBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabelIcon threeBtn = testReleaseLev.getNumButton(3);
		try {
			MouseEvent cp = createPressed(threeBtn, 0, 0);
			threeBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabelIcon tile2 = testReleaseLev.getBoardview().getTiles()[2];
		try {
			MouseEvent cp = createPressed(tile2, 0, 0);
			tile2.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabelIcon tile3 = testReleaseLev.getBoardview().getTiles()[3];
//		try {
			MouseEvent cp1 = createRightClick(tile3, 0, 0);
			tile3.dispatchEvent(cp1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// try saving the level
		JLabelIcon saveBtn = testReleaseLev.getSaveButton();
		try {
			MouseEvent cp = createPressed(saveBtn, 0, 0);
			saveBtn.dispatchEvent(cp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// check that we are returned to the main menu
		assertTrue(frame.getContentPane() instanceof BuilderMainMenu);

		test = new BuilderMainMenu(builder, frame);

		JLabelIcon loadBtn = test.getLoadButton();

		try {
			MouseEvent cp = createPressed(loadBtn, 0, 0);
			loadBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// load the first level
		BuilderLevelSelect levSelect = new BuilderLevelSelect(builder, frame);

		// try returning to the main menu
		JLabelIcon gotomain = levSelect.getMainMenuButton();
		try {
			MouseEvent cp = createPressed(gotomain, 0, 0);
			gotomain.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderMainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test = new BuilderMainMenu(builder, frame);

		loadBtn = test.getLoadButton();

		try {
			MouseEvent cp = createPressed(loadBtn, 0, 0);
			loadBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// load the first level
		levSelect = new BuilderLevelSelect(builder, frame);

		JLabelIcon firstLev = levSelect.getLevelSelectButton(0);
		try {
			MouseEvent cp = createPressed(firstLev, 0, 0);
			firstLev.dispatchEvent(cp);
			// assertTrue(frame.getContentPane() instanceof
			// BuilderLightningLevelPanel);
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

}
