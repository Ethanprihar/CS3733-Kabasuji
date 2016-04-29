package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class LightningLevelTest extends TestCase {

	protected void setUp() {
	}

	public void testLightningLevel() {
		// Tile testTile1 = new Tile(false, false, 0, 0);
		// assertEquals (testTile1.getNumber(), 0);

		// make a new board
		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, true, 0, 0);
		Tile testTile3 = new Tile(false, false, 0, 0);
		Tile testTile4 = new Tile(false, false, 0, 0);
		Tile testTile5 = new Tile(false, false, 0, 0);
		Tile testTile6 = new Tile(false, false, 0, 0);
		Tile testTile7 = new Tile(false, true, 0, 0);
		Tile testTile8 = new Tile(false, true, 0, 0);

		Tile boardTile0_0 = new Tile(false, false, 0, 0);
		Tile boardTile0_1 = new Tile(false, false, 0, 0);
		Tile boardTile0_2 = new Tile(false, false, 0, 0);
		Tile boardTile0_3 = new Tile(false, false, 0, 0);
		Tile boardTile1_0 = new Tile(false, false, 0, 0);
		Tile boardTile1_1 = new Tile(false, false, 0, 0);
		Tile boardTile1_2 = new Tile(false, false, 0, 0);
		Tile boardTile1_3 = new Tile(false, false, 0, 0);
		Tile boardTile2_0 = new Tile(false, false, 0, 0);
		Tile boardTile2_1 = new Tile(false, false, 0, 0);
		Tile boardTile2_2 = new Tile(false, false, 0, 0);
		Tile boardTile2_3 = new Tile(false, false, 0, 0);
		Tile boardTile3_0 = new Tile(false, false, 0, 0);
		Tile boardTile3_1 = new Tile(false, false, 0, 0);
		Tile boardTile3_2 = new Tile(false, false, 0, 0);
		Tile boardTile3_3 = new Tile(false, false, 0, 0);
		
		Tile boardTile0_0v = new Tile(false, true, 0, 0);
		Tile boardTile0_1v = new Tile(false, true, 0, 0);
		Tile boardTile0_2v = new Tile(false, true, 0, 0);
		Tile boardTile0_3v = new Tile(false, true, 0, 0);
		Tile boardTile1_0v = new Tile(false, true, 0, 0);
		Tile boardTile1_1v = new Tile(false, true, 0, 0);
		Tile boardTile1_2v = new Tile(false, true, 0, 0);
		Tile boardTile1_3v = new Tile(false, true, 0, 0);
		Tile boardTile2_0v = new Tile(false, true, 0, 0);
		Tile boardTile2_1v = new Tile(false, true, 0, 0);
		Tile boardTile2_2v = new Tile(false, true, 0, 0);
		Tile boardTile2_3v = new Tile(false, true, 0, 0);
		Tile boardTile3_0v = new Tile(false, true, 0, 0);
		Tile boardTile3_1v = new Tile(false, true, 0, 0);
		Tile boardTile3_2v = new Tile(false, true, 0, 0);
		Tile boardTile3_3v = new Tile(false, true, 0, 0);
		
		Tile[][] board1v = { { boardTile0_0v, boardTile0_1v, boardTile0_2v, boardTile0_3v },
				{ boardTile1_0v, boardTile1_1v, boardTile1_2v, boardTile1_3v },
				{ boardTile2_0v, boardTile2_1v, boardTile2_2v, boardTile2_3v },
				{ boardTile3_0v, boardTile3_1v, boardTile3_2v, boardTile3_3v } };
		
		LightningBoard lightBoardv = new LightningBoard(board1v);

		Tile[][] piece1 = { { testTile1, testTile2 }, { testTile3, testTile4 } };
		Tile[][] piece2 = { { testTile5, testTile6 }, { testTile7, testTile8 } };
		Tile[][] board1 = { { boardTile0_0, boardTile0_1, boardTile0_2, boardTile0_3 },
				{ boardTile1_0, boardTile1_1, boardTile1_2, boardTile1_3 },
				{ boardTile2_0, boardTile2_1, boardTile2_2, boardTile2_3 },
				{ boardTile3_0, boardTile3_1, boardTile3_2, boardTile3_3 } };
		Piece testPiece2 = new Piece(piece2);

		LightningBoard lightBoard1 = new LightningBoard(board1);

		// make a new bullpen
		Bullpen bullpen1 = new Bullpen();
		Tile[][] piece3 = { { testTile1, testTile2 }, { testTile2, testTile1 } };
		Piece testPiece1 = new Piece(piece1);
		bullpen1.addPiece(testPiece1);
		bullpen1.selectPiece(testPiece1);

		// make a new Lightning Level Test
		LightningLevel lightTest = new LightningLevel(lightBoard1, bullpen1, 10);
		
		// make a new Lightning Level Test
		LightningLevel lightTestv = new LightningLevel(lightBoard1, bullpen1, 10);

		assertEquals(lightTest.getTimeLeft(), 10);

		assertEquals(lightTest.getTimeLimit(), 10);

		assertEquals(lightTest.getCurrentTime(), 0);

		assertEquals(lightTest.hasTimeLeft(), true);
		
		assertEquals(lightTest.canGoNextLevel(),true);
		assertEquals(lightTest.getStars(),3); // no uncovered tiles
		assertEquals(lightTest.getBoard().getNumStars(),0);// stars not yet updated

		assertEquals(lightTest.canMoveBoardToBullpen(), false);

		assertEquals(lightTest.canMoveBoardToBoard(boardTile3_3), false);

		lightTest.setCurrentTime(4);
		
		lightTest.incrementCurrentTime();

		lightTest.setTimeLimit(5);

		assertEquals(lightTest.hasTimeLeft(), false);

		assertEquals(lightTest.getTimeLeft(), 0);

		assertEquals(lightTest.canMoveBullpenToBoard(boardTile0_0), false);
		
		lightTest.setEndCondition(20);
		
		assertEquals(lightTest.getEndCondition(),(Integer)20);

	}

}