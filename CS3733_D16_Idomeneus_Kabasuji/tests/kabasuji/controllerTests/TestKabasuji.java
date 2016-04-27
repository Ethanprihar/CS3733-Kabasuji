package kabasuji.controllerTests;

import kabasuji.model.Kabasuji;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.SplashWindow;
import kabasuji.view.TopLevelApplication;

public class TestKabasuji extends TestCaseHelper
{
	Kabasuji kabasuji;
	TopLevelApplication frame;
	
	protected void setup() throws Exception
	{
		kabasuji = new Kabasuji();
		frame = new TopLevelApplication(kabasuji);
		new SplashWindow();
		frame.setVisible(true); 
	}
	
	protected void tearDown() throws Exception
	{
		frame.setVisible(false);
		frame.dispose();
	}
	
	public void testBoard()
	{
		
	}
	
	public void testFlipSelectedPieceBullpen()
	{
		
	}
	
	public void testGoToLevelSelect()
	{
		
	}
	
	public void testGoToMainMenu()
	{
		
	}
	
	public void testNextLevel()
	{
		
	}
	
	public void testResetLevel()
	{
		
	}
	
	public void testRotateSelectedPieceBullpen()
	{
		
	}
	
	public void testSelectLevel()
	{
		
	}
	
	public void testSelectPieceBullpen()
	{
		
	}
	
	public void testTile()
	{
		
	}
}