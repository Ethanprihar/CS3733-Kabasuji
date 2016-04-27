package kabasuji.testUtilities;

import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import junit.framework.TestCase;

/**
 * Defines useful helper methods for testing Kabasuji.
 * <p>
 * If you would like to use this capability, have your JUnit test case
 * extend from this class instead of {@link TestCase}.
 */

public abstract class TestCaseHelper extends TestCase {
	/** x and y are coordinates in the whole container */
	public MouseEvent createPressed (JComponent container, int x, int y) {
		MouseEvent me = new MouseEvent(container, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				x, y, 0, false);
		return me;
	}
	
	/** x and y are coordinates in the whole container */
	public MouseEvent createRightClick (JComponent container, int x, int y) {
		MouseEvent me = new MouseEvent(container, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				x, y, 0, true);
		return me;
	}
	
	/** x and y are coordinates in the whole container */
	public MouseEvent createReleased (JComponent container, int x, int y) {
		MouseEvent me = new MouseEvent(container, MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				x, y, 0, false);
		return me;
	}
	
	/** x and y are coordinates in the whole container */
	public MouseEvent createClicked (JComponent container, int x, int y) {
		MouseEvent me = new MouseEvent(container, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				x, y, 1, false);
		return me;
	}
	
	/** x and y are coordinates in the whole container */
	public MouseEvent createDoubleClicked (JComponent container, int x, int y) {
		MouseEvent me = new MouseEvent(container, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				x, y, 2, false);
		return me;
	}
}
