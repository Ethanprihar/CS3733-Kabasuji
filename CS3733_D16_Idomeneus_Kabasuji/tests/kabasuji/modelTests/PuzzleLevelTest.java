package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class PuzzleLevelTest extends TestCase{

	protected void setUp()
	{
	}
	
	public void testPuzzleLevel()
	{
		
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
		
		PuzzleBoard puzzBoardv = new PuzzleBoard(board1v);

		Tile[][] piece1 = {{testTile1, testTile2},{testTile3, testTile4}};
		Tile[][] piece2 = {{testTile5, testTile6},{testTile7, testTile8}};
		Tile[][] board1 = 
			{{boardTile0_0,boardTile0_1,boardTile0_2,boardTile0_3},
			{boardTile1_0,boardTile1_1,boardTile1_2,boardTile1_3},
			{boardTile2_0,boardTile2_1,boardTile2_2,boardTile2_3},
			{boardTile3_0,boardTile3_1,boardTile3_2,boardTile3_3}};
		Piece testPiece2 = new Piece(piece2);
		
		PuzzleBoard puzzBoard1 = new PuzzleBoard(board1);
		
		// make a new bullpen
		Bullpen bullpen1 = new Bullpen();
		Tile[][] piece3 = {{testTile1, testTile2},{testTile2, testTile1}};
		Piece testPiece1 = new Piece(piece1);
		bullpen1.addPiece(testPiece1);
		
		// make a new Puzzle Level Test
		PuzzleLevel puzzTest = new PuzzleLevel(puzzBoard1, bullpen1, 10);
		
		// check that moves used is initially zero
		assertEquals(puzzTest.getMovesUsed(), 0);
		// check that the moves left is 10
		assertEquals(puzzTest.getMovesLeft(), 10);	
		// check that the max moves was correctly set to 10
		assertEquals(puzzTest.getMaxMoves(), 10);	
		// make sure that the player has moves left
		assertEquals(puzzTest.hasMovesLeft(), true);
		
		puzzTest.setMovesUsed(4);
		
		// check that moves used was updated
		assertEquals(puzzTest.getMovesUsed(), 4);		
		// check that the moves left is 6
		assertEquals(puzzTest.getMovesLeft(), 6);		
		// check that the max moves was correctly set to 10
		assertEquals(puzzTest.getMaxMoves(), 10);		
		// make sure that the player has moves left
		assertEquals(puzzTest.hasMovesLeft(), true);
		
		puzzTest.setMovesUsed(10);
		
		// check that moves used was updated
		assertEquals(puzzTest.getMovesUsed(), 10);		
		// check that the moves left is 0
		assertEquals(puzzTest.getMovesLeft(), 0);		
		// check that the max moves was correctly set to 10
		assertEquals(puzzTest.getMaxMoves(), 10);		
		// make sure that the player has moves left
		assertEquals(puzzTest.hasMovesLeft(), false);
		
		puzzTest.setMaxMoves(15);
		
		// check that moves used was updated
		assertEquals(puzzTest.getMovesUsed(), 10);		
		// check that the moves left is 5
		assertEquals(puzzTest.getMovesLeft(), 5);		
		// check that the max moves was correctly set to 15
		assertEquals(puzzTest.getMaxMoves(), 15);		
		// make sure that the player has moves left
		assertEquals(puzzTest.hasMovesLeft(), true);
		
		// test moveBoardToBoard method
		// have puzz board select a piece
		Board puzzBoard2 = new PuzzleBoard(board1);
		puzzBoard2.selectPiece(testPiece1);
		
		PuzzleLevel puzzTest1 = new PuzzleLevel((PuzzleBoard)puzzBoard2, bullpen1, 10);
		assertEquals(puzzTest1.canMoveBoardToBullpen(),true);
		assertEquals(puzzTest1.hasMovesLeft(), true);
		//assertEquals(puzzTest1.canMoveBoardToBoard(boardTile3_3), true);
		
		//puzzTest1.moveBoardToBoard(boardTile3_1);
		
		puzzTest1.setMaxMoves(10);
		puzzTest1.setMovesUsed(10);
		
		assertEquals(puzzTest1.canMoveBoardToBullpen(),false);
		assertEquals(puzzTest1.canMoveBullpenToBoard(boardTile3_3), false);
		assertEquals(puzzTest1.hasMovesLeft(),false);
		//assertEquals(puzzTest.canMoveBoardToBoard(boardTile3_3), false);
		//assertEquals(puzzTest1.hasMovesLeft(),false);
		assertEquals(puzzTest1.canMoveBoardToBoard(boardTile3_3), false);
		
		puzzTest.setEndCondition(20);
		//assertEquals(puzzTest1.getEndCondition(),20);
		
	}
}