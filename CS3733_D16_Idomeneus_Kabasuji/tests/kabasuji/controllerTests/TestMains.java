package kabasuji.controllerTests;

import kabasuji.Main;
import kabasuji.testUtilities.TestCaseHelper;
import levelbuilder.LBMain;

public class TestMains extends TestCaseHelper {


	protected void setup() throws Exception {}

	protected void tearDown() throws Exception {}
	
	
	public void testMain() {

		Main.main(new String[] { "arg1", "arg2", "arg3" });
		Main.makePieces();
	}
	
	public void testLBMain() {
		LBMain.main(new String[] { "arg1", "arg2", "arg3" });
	}
	
}