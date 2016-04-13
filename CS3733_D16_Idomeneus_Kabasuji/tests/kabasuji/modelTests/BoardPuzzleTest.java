package kabasuji.modelTests;

import junit.framework.TestCase;
import kabasuji.model.Board;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Tile;

public class BoardPuzzleTest extends TestCase{
	protected void setUp()
	{
	}
	
	public void testBoards()
	{
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
		Tile testTile11 = new Tile(false, false, 0, 0);
		Tile testTile12 = new Tile(false, false, 0, 0);
		Tile testTile13 = new Tile(false, false, 0, 0);
		Tile testTile14 = new Tile(false, false, 0, 0);
		Tile testTile15 = new Tile(false, false, 0, 0);
		Tile testTile16 = new Tile(false, false, 0, 0);
		Tile testTile17 = new Tile(false, false, 0, 0);
		Tile testTile18 = new Tile(false, false, 0, 0);
		Tile testTile19 = new Tile(false, false, 0, 0);
		Tile testTile20 = new Tile(false, false, 0, 0);
		Tile testTile21 = new Tile(false, false, 0, 0);
		Tile testTile22 = new Tile(false, false, 0, 0);
		Tile testTile23 = new Tile(false, false, 0, 0);
		Tile testTile24 = new Tile(false, false, 0, 0);
		Tile testTile25 = new Tile(false, false, 0, 0);
		Tile testTile26 = new Tile(false, false, 0, 0);
		Tile testTile27 = new Tile(false, false, 0, 0);
		Tile testTile28 = new Tile(false, false, 0, 0);
		Tile testTile29 = new Tile(false, false, 0, 0);
		Tile testTile30 = new Tile(false, false, 0, 0);
		Tile testTile31 = new Tile(false, false, 0, 0);
		Tile testTile32 = new Tile(false, false, 0, 0);
		Tile testTile33 = new Tile(false, false, 0, 0);
		Tile testTile34 = new Tile(false, false, 0, 0);
		Tile testTile35 = new Tile(false, false, 0, 0);
		Tile testTile36 = new Tile(false, false, 0, 0);
		
		Tile boardTile0_0 = new Tile(false, true, 0, 0);
		Tile boardTile0_1 = new Tile(false, true, 0, 0);
		Tile boardTile0_2 = new Tile(false, true, 0, 0);
		Tile boardTile0_3 = new Tile(false, true, 0, 0);
		Tile boardTile1_0 = new Tile(false, true, 0, 0);
		Tile boardTile1_1 = new Tile(false, true, 0, 0);
		Tile boardTile1_2 = new Tile(false, true, 0, 0);
		Tile boardTile1_3 = new Tile(false, true, 0, 0);
		Tile boardTile2_0 = new Tile(false, true, 0, 0);
		Tile boardTile2_1 = new Tile(false, true, 0, 0);
		Tile boardTile2_2 = new Tile(false, true, 0, 0);
		Tile boardTile2_3 = new Tile(false, true, 0, 0);
		Tile boardTile3_0 = new Tile(false, true, 0, 0);
		Tile boardTile3_1 = new Tile(false, true, 0, 0);
		Tile boardTile3_2 = new Tile(false, true, 0, 0);
		Tile boardTile3_3 = new Tile(false, true, 0, 0);

		
		Tile[][] piece1 = {{testTile1, testTile2},{testTile3, testTile4}};
		Tile[][] piece2 = {{testTile5, testTile6},{testTile7, testTile8}};
		Tile[][] board1 = 
			{{boardTile0_0,boardTile0_1,boardTile0_2,boardTile0_3},
			{boardTile1_0,boardTile1_1,boardTile1_2,boardTile1_3},
			{boardTile2_0,boardTile2_1,boardTile2_2,boardTile2_3},
			{boardTile3_0,boardTile3_1,boardTile3_2,boardTile3_3}};
		

		/* 11
		 * 00
		 */
		Piece testPiece1 = new Piece(piece1);
											 
		/* 01
		 * 01
		 */
		Piece testPiece2 = new Piece(piece2);
		
		Board testBoard1 = new PuzzleBoard(board1);
		
		
		
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile3_3), false);

		testBoard1.addPiece(testPiece1, boardTile0_0);
		//System.out.println(null);
		
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_0), false);
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_1), true);
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), false);
		
		assertEquals(testBoard1.canRemovePiece(testPiece1), true);
		testBoard1.removePiece(testPiece1);
		
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		testBoard1.addPiece(testPiece2, boardTile0_0);
		
		assertEquals(testBoard1.canShiftPiece(testPiece1, boardTile0_2), true);
		assertEquals(testBoard1.canShiftPiece(testPiece1, boardTile1_0), true);

	}
}
