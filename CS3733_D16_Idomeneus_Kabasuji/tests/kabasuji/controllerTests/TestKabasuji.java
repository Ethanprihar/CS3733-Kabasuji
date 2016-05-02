package kabasuji.controllerTests;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.testUtilities.TestCaseHelper;
import kabasuji.view.JLabelIcon;
import kabasuji.view.LevelSelectPanel;
import kabasuji.view.MainMenu;
import kabasuji.view.PieceView;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.SplashWindow;
import kabasuji.view.TopLevelApplication;
import levelbuilder.view.BuilderLevelMode;
import levelbuilder.view.BuilderMainMenu;

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
	
//	public void testBoard()
//	{
//		
//	}
//	
//	public void testFlipSelectedPieceBullpen()
//	{
//		
//	}
//	
	public void testGoToLevelSelect()
	{
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
	public void testGoToMainMenu()
	{
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LevelSelectPanel test = new LevelSelectPanel(kabasuji, frame);
		
		// This test case will take you back to the main menu
		JLabelIcon mainMenuBtn =  test.getMainMenuButton();
		
		try {
			MouseEvent cp = createPressed(mainMenuBtn, 0, 0);
			mainMenuBtn.dispatchEvent(cp);
			assertTrue(frame.getContentPane() instanceof MainMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//	
//	public void testNextLevel()
//	{
//		
//	}
//	
//	public void testResetLevel()
//	{
//		
//	}
//	
//	public void testRotateSelectedPieceBullpen()
//	{
//		
//	}
//	
	public void testSelectLevel()
	{
		try {
			setup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LevelSelectPanel test = new LevelSelectPanel(kabasuji, frame);
		
		// If levels exist, then select the level
		if (kabasuji.getLevels().size() > 0){
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
		// Get the first piece in the arraylist
		Piece piece = testPiece.get(0);
		
		// Select the piece
		testBullpen.selectPiece(piece);
		
		// Get the pieceview
		PieceView getPieceView = new PieceView(piece);
				
		// Click on this piece in the bullpen
		try {
			MouseEvent cp = createPressed(getPieceView, 0, 0);
			getPieceView.dispatchEvent(cp);
			assertEquals(piece, testBullpen.getSelectedPiece());
		} catch (Exception e) {
			e.printStackTrace();
	}
//	
//	public void testSelectPieceBullpen()
//	{
//		
//	}
//	
//	public void testTile()
//	{
//		
//	}
}
}