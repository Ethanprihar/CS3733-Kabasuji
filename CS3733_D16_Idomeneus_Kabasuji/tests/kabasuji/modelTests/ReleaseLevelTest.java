package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class ReleaseLevelTest extends TestCase {

	protected void setUp() {
	}

	public void testBoards() {
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

		ReleaseBoard releaseBoard1 = new ReleaseBoard(board1);

		// make a new bullpen
		Bullpen bullpen1 = new Bullpen();
		Tile[][] piece3 = { { testTile1, testTile2 }, { testTile2, testTile1 } };
		Piece testPiece1 = new Piece(piece1);
		bullpen1.addPiece(testPiece1);

		// make a new Puzzle Level Test
		ReleaseLevel releaseTest = new ReleaseLevel(releaseBoard1, bullpen1, 10);

		// check that moves used is initially zero
		assertEquals(releaseTest.getMovesUsed(), 0);
		// check that the moves left is 10
		assertEquals(releaseTest.getMovesLeft(), 10);
		// check that the max moves was correctly set to 10
		assertEquals(releaseTest.getMaxMoves(), 10);
		// make sure that the player has moves left
		assertEquals(releaseTest.hasMovesLeft(), true);

		releaseTest.setMovesUsed(4);

		// check that moves used was updated
		assertEquals(releaseTest.getMovesUsed(), 4);
		// check that the moves left is 6
		assertEquals(releaseTest.getMovesLeft(), 6);
		// check that the max moves was correctly set to 10
		assertEquals(releaseTest.getMaxMoves(), 10);
		// make sure that the player has moves left
		assertEquals(releaseTest.hasMovesLeft(), true);

		releaseTest.setMovesUsed(10);

		// check that moves used was updated
		assertEquals(releaseTest.getMovesUsed(), 10);
		// check that the moves left is 0
		assertEquals(releaseTest.getMovesLeft(), 0);
		// check that the max moves was correctly set to 10
		assertEquals(releaseTest.getMaxMoves(), 10);
		// make sure that the player has moves left
		assertEquals(releaseTest.hasMovesLeft(), false);

		releaseTest.setMaxMoves(15);

		// check that moves used was updated
		assertEquals(releaseTest.getMovesUsed(), 10);
		// check that the moves left is 5
		assertEquals(releaseTest.getMovesLeft(), 5);
		// check that the max moves was correctly set to 15
		assertEquals(releaseTest.getMaxMoves(), 15);
		// make sure that the player has moves left
		assertEquals(releaseTest.hasMovesLeft(), true);
		
		releaseTest.setEndCondition(20);
		assertEquals(releaseTest.getEndCondition(),20);
		
		assertEquals(releaseTest.canMoveBoardToBoard(boardTile3_0),false);
		assertEquals(releaseTest.canMoveBoardToBullpen(),false);
		
	}
	
	public void testReleaseMoveOptions() {

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

		
		ReleaseBoard releaseBoard1 = new ReleaseBoard(board1);

		// make a new bullpen
		Bullpen bullpen1 = new Bullpen();
		//Tile[][] testPiece_3 = { { testTile1, testTile2 }, { testTile2, testTile1 } };
		Piece testPiece = new Piece(piece1);
		bullpen1.addPiece(testPiece);
		bullpen1.selectPiece(testPiece);

		// make a new Puzzle Level Test
		ReleaseLevel releaseTest = new ReleaseLevel(releaseBoard1, bullpen1, 10);
		
		assertEquals(releaseTest.canMoveBullpenToBoard(boardTile2_2),true);
		
		assertEquals(releaseTest.canMoveBullpenToBoard(boardTile4_4),false);
		
		releaseTest.setMaxMoves(5);

		releaseTest.setMovesUsed(2);
		
		assertEquals(releaseTest.canMoveBullpenToBoard(boardTile4_4),false);
		assertEquals(releaseTest.canMoveBullpenToBoard(boardTile2_2),false);
		
	}
}