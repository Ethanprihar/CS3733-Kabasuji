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
		frame.setVisible(true);
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


	}



}
