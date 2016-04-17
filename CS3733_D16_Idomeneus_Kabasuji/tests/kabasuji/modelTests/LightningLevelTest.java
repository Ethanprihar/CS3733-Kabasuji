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

		// make a new Puzzle Level Test
		LightningLevel lightTest = new LightningLevel(lightBoard1, bullpen1, 10);

		assertEquals(lightTest.getTimeLeft(), 10);

		assertEquals(lightTest.getTimeLimit(), 10);

		assertEquals(lightTest.getCurrentTime(), 0);

		assertEquals(lightTest.hasTimeLeft(), true);

		assertEquals(lightTest.canGoNextLevel(), false);

		assertEquals(lightTest.getStars(), 0);

		assertEquals(lightTest.canMoveBoardToBullpen(), false);

		assertEquals(lightTest.canMoveBoardToBoard(boardTile3_3), false);

		assertEquals(lightTest.canMoveBullpenToBoard(boardTile3_3), false);

		lightTest.setCurrentTime(5);

		lightTest.setTimeLimit(5);

		assertEquals(lightTest.hasTimeLeft(), false);

		assertEquals(lightTest.getTimeLeft(), 0);

		assertEquals(lightTest.canMoveBullpenToBoard(boardTile0_0), false);

	}

	public void testLightningMoveOptions() {

		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, true, 0, 0);
		Tile testTile3 = new Tile(false, false, 0, 0);
		Tile testTile4 = new Tile(false, false, 0, 0);

		Tile testTile5 = new Tile(false, false, 0, 0);
		Tile testTile6 = new Tile(false, true, 0, 0);
		Tile testTile7 = new Tile(false, false, 0, 0);
		Tile testTile8 = new Tile(false, true, 0, 0);

		Tile testTile9 = new Tile(false, false, 0, 0);
		Tile testTile10 = new Tile(false, false, 0, 0);
		Tile testTile11 = new Tile(false, true, 0, 0);
		Tile testTile12 = new Tile(false, true, 0, 0);

		Tile boardTile0_0 = new Tile(false, true, 0, 0);
		Tile boardTile0_1 = new Tile(false, true, 0, 0);
		Tile boardTile0_2 = new Tile(false, true, 0, 0);
		Tile boardTile0_3 = new Tile(false, true, 0, 0);
		Tile boardTile0_4 = new Tile(false, false, 0, 0);
		Tile boardTile1_0 = new Tile(false, true, 0, 0);
		Tile boardTile1_1 = new Tile(false, true, 0, 0);
		Tile boardTile1_2 = new Tile(false, true, 0, 0);
		Tile boardTile1_3 = new Tile(false, true, 0, 0);
		Tile boardTile1_4 = new Tile(false, false, 0, 0);
		Tile boardTile2_0 = new Tile(false, true, 0, 0);
		Tile boardTile2_1 = new Tile(false, true, 0, 0);
		Tile boardTile2_2 = new Tile(false, true, 0, 0);
		Tile boardTile2_3 = new Tile(false, true, 0, 0);
		Tile boardTile2_4 = new Tile(false, false, 0, 0);
		Tile boardTile3_0 = new Tile(false, true, 0, 0);
		Tile boardTile3_1 = new Tile(false, true, 0, 0);
		Tile boardTile3_2 = new Tile(false, true, 0, 0);
		Tile boardTile3_3 = new Tile(false, true, 0, 0);
		Tile boardTile3_4 = new Tile(false, false, 0, 0);
		Tile boardTile4_0 = new Tile(false, false, 0, 0);
		Tile boardTile4_1 = new Tile(false, false, 0, 0);
		Tile boardTile4_2 = new Tile(false, false, 0, 0);
		Tile boardTile4_3 = new Tile(false, false, 0, 0);
		Tile boardTile4_4 = new Tile(false, false, 0, 0);

		Tile[][] piece1 = { { testTile1, testTile2 }, { testTile3, testTile4 } };
		Tile[][] piece2 = { { testTile5, testTile6 }, { testTile7, testTile8 } };
		Tile[][] piece3 = { { testTile9, testTile10 }, { testTile11, testTile12 } };
		Tile[][] board1 = { { boardTile0_0, boardTile0_1, boardTile0_2, boardTile0_3, boardTile0_4 },
				{ boardTile1_0, boardTile1_1, boardTile1_2, boardTile1_3, boardTile1_4 },
				{ boardTile2_0, boardTile2_1, boardTile2_2, boardTile2_3, boardTile2_4 },
				{ boardTile3_0, boardTile3_1, boardTile3_2, boardTile3_3, boardTile3_4 },
				{ boardTile4_0, boardTile4_1, boardTile4_2, boardTile4_3, boardTile4_4 } };

		/*
		 * 11 00
		 */
		Piece testPiece1 = new Piece(piece1);

		/*
		 * 01 01
		 */
		Piece testPiece2 = new Piece(piece2);

		/*
		 * 00 11
		 */
		Piece testPiece3 = new Piece(piece3);

		Board testBoard1 = new PuzzleBoard(board1);
		
		LightningBoard lightBoard1 = new LightningBoard(board1);

		// make a new bullpen
		Bullpen bullpen1 = new Bullpen();
		//Tile[][] testPiece_3 = { { testTile1, testTile2 }, { testTile2, testTile1 } };
		Piece testPiece = new Piece(piece1);
		bullpen1.addPiece(testPiece);
		bullpen1.selectPiece(testPiece);

		// make a new Puzzle Level Test
		LightningLevel lightTest = new LightningLevel(lightBoard1, bullpen1, 10);
		
		assertEquals(lightTest.canMoveBullpenToBoard(boardTile2_2),true);
		
		assertEquals(lightTest.canMoveBullpenToBoard(boardTile4_4),false);
		
		lightTest.setCurrentTime(5);

		lightTest.setTimeLimit(5);
		
		assertEquals(lightTest.canMoveBullpenToBoard(boardTile4_4),false);
		assertEquals(lightTest.canMoveBullpenToBoard(boardTile2_2),false);
		
		
		
		
		
		
		
	}

}