package kabasuji.controllerTests;

import javax.swing.JComponent;
import java.awt.event.MouseEvent;

import kabasuji.model.Builder;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.Screen;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.JLabelIcon;
import kabasuji.view.SplashWindow;
import levelbuilder.view.TopLevelApplicationBuilder;
import levelbuilder.view.BuilderLevelMode;
import levelbuilder.view.BuilderMainMenu;

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

	public void testBuilderBoard() {

		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BuilderMainMenu test = new BuilderMainMenu(builder, frame);
		
		JLabelIcon testBtn = test.getBuildButton();
		
		System.out.println(testBtn.getSize().getWidth());
		System.out.println(testBtn.getSize().getHeight());
		
		try {
			MouseEvent cp = createPressed(testBtn, 0, 0);
			testBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof BuilderLevelMode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add in the size of the board

		// select puzzle mode to test first
//		try {
//			MouseEvent puzz = createPressed(frame.contentPane, (int) (Screen.width + ((0 - 70 / 5 - 2) * 70) / 2),
//					(int) (Screen.height) / 2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	public void testBuilderReleaseBoard() {

	}

	public void testCreateNewLevelBuilder() {

	}

	public void testDeleteLevel() {

	}

	public void testDeselectReleaseButtons() {

	}

	public void testEditNewLevelBuilder() {

	}

	public void testGoToMainMenuBuilder() {

	}

	public void testIncrementPieceBuilder() {

	}

	public void testLoadLevelsBuilder() {

//		// mouse pressed to load level (relies on size of button being70x70
//		MouseEvent cp = createPressed(frame.contentPane, (int) (Screen.width - 70) / 2,
//				(int) (3 * 70 + Screen.height) / 2);

	}

	public void testRedo() {

	}

	public void testSaveLevel() {

	}

	public void testSelectLevelBuilder() {

	}

	public void testSetColor() {

	}

	public void testSetNumber() {

	}

	public void testTestLevelBuilder() {

	}

	public void testUndo() {

	}
}
