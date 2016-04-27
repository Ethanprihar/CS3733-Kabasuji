package kabasuji.controllerTests;

import kabasuji.model.Builder;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.SplashWindow;
import levelbuilder.view.TopLevelApplicationBuilder;

public class TestBuilder extends TestCaseHelper
{
	TopLevelApplicationBuilder frame;
	Builder builder;
	
	protected void setup() throws Exception
	{
		builder = new Builder();
		frame = new TopLevelApplicationBuilder(builder);
		new SplashWindow();
		frame.setVisible(true); 
	}
	
	protected void tearDown() throws Exception
	{
		frame.setVisible(false);
		frame.dispose();
	}
	
	public void testBuilderBoard()
	{
		
	}
	
	public void testBuilderReleaseBoard()
	{
		
	}
	
	public void testCreateNewLevelBuilder()
	{
		
	}
	
	public void testDeleteLevel()
	{
		
	}
	
	public void testDeselectReleaseButtons()
	{
		
	}
	
	public void testEditNewLevelBuilder()
	{
		
	}
	
	public void testGoToMainMenuBuilder()
	{
		
	}
	
	public void testIncrementPieceBuilder()
	{
		
	}
	
	public void testLoadLevelsBuilder()
	{
		
	}
	
	public void testRedo()
	{
		
	}
	
	public void testSaveLevel()
	{
		
	}
	
	public void testSelectLevelBuilder()
	{
		
	}
	
	public void testSetColor()
	{
		
	}
	
	public void testSetNumber()
	{
		
	}
	
	public void testTestLevelBuilder()
	{
		
	}
	
	public void testUndo()
	{
		
	}
}
