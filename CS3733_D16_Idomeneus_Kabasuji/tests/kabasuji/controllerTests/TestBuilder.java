package kabasuji.controllerTests;

import javax.swing.JComponent;
import java.awt.event.MouseEvent;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.SplashWindow;
import levelbuilder.view.TopLevelApplicationBuilder;

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
		// mouse pressed to build new level (relies on size of button being 70 x
		// 70
		MouseEvent cp = createPressed(frame.contentPane, (int) (Screen.width - 70) / 2, (int) Screen.height / 2);

		// add in the size of the board
		
		// select puzzle mode to test first
		MouseEvent puzz = createPressed(frame.contentPane, (int) (Screen.width + ((0 - 70/5 - 2)*70)/2), (int) (Screen.height)/2);
		
		

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

		// mouse pressed to load level (relies on size of button being70x70
		MouseEvent cp = createPressed(frame.contentPane, (int) (Screen.width - 70) / 2,
				(int) (3 * 70 + Screen.height) / 2);

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
