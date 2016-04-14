package kabasuji.modelTests;

import junit.framework.TestCase;
import kabasuji.model.Board;
import kabasuji.model.Piece;
import kabasuji.model.LightningBoard;
import kabasuji.model.Tile;

public class BoardLightningTest extends TestCase{
	protected void setup()
	{}

	public void testLightningBoard()
	{
		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, true, 0, 0);
		Tile testTile3 = new Tile(false, false, 0, 0);
		Tile testTile4 = new Tile(false, false, 0, 0);
		
		Tile testTile5 = new Tile(false, false, 0, 0);
		Tile testTile6 = new Tile(false, true, 0, 0);
		Tile testTile7 = new Tile(false, false, 0, 0);
		Tile testTile8 = new Tile(false, true, 0, 0);
		
		Tile boardTile0_0 = new Tile(false, true, 0, 0);
		Tile boardTile0_1 = new Tile(false, true, 0, 0);
		Tile boardTile0_2 = new Tile(false, true, 0, 0);
		Tile boardTile0_3 = new Tile(false, true, 0, 0);
		Tile boardTile0_4 = new Tile(false, true, 0, 0);
		Tile boardTile1_0 = new Tile(false, true, 0, 0);
		Tile boardTile1_1 = new Tile(false, true, 0, 0);
		Tile boardTile1_2 = new Tile(false, true, 0, 0);
		Tile boardTile1_3 = new Tile(false, true, 0, 0);
		Tile boardTile1_4 = new Tile(false, true, 0, 0);
		Tile boardTile2_0 = new Tile(false, true, 0, 0);
		Tile boardTile2_1 = new Tile(false, true, 0, 0);
		Tile boardTile2_2 = new Tile(false, true, 0, 0);
		Tile boardTile2_3 = new Tile(false, true, 0, 0);
		Tile boardTile2_4 = new Tile(false, true, 0, 0);
		Tile boardTile3_0 = new Tile(false, true, 0, 0);
		Tile boardTile3_1 = new Tile(false, true, 0, 0);
		Tile boardTile3_2 = new Tile(false, true, 0, 0);
		Tile boardTile3_3 = new Tile(false, true, 0, 0);
		Tile boardTile3_4 = new Tile(false, true, 0, 0);
		Tile boardTile4_0 = new Tile(false, false, 0, 0);
		Tile boardTile4_1 = new Tile(false, false, 0, 0);
		Tile boardTile4_2 = new Tile(false, false, 0, 0);
		Tile boardTile4_3 = new Tile(false, false, 0, 0);
		Tile boardTile4_4 = new Tile(false, false, 0, 0);
	
		
		Tile[][] piece1 = {{testTile1, testTile2},{testTile3, testTile4}};
		Tile[][] piece2 = {{testTile5, testTile6},{testTile7, testTile8}};
		Tile[][] board1 = 
			{{boardTile0_0,boardTile0_1,boardTile0_2,boardTile0_3,boardTile0_4},
			{boardTile1_0,boardTile1_1,boardTile1_2,boardTile1_3,boardTile1_4},
			{boardTile2_0,boardTile2_1,boardTile2_2,boardTile2_3,boardTile2_4},
			{boardTile3_0,boardTile3_1,boardTile3_2,boardTile3_3,boardTile3_4},
			{boardTile4_0,boardTile4_1,boardTile4_2,boardTile4_3,boardTile4_4}};
		
	
		/* 11
		 * 00
		 */
		Piece testPiece1 = new Piece(piece1);
											 
		/* 01
		 * 01
		 */
		Piece testPiece2 = new Piece(piece2);
		
		Board testBoard1 = new LightningBoard(board1);
		
		//Test if piece can be added to valid area of board
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		
		//test if piece cannot be added to a valid part of the board that would leave
		//some of the piece off the board
		assertEquals (testBoard1.canAddPiece(testPiece2, boardTile3_3), false);
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile3_3), true);
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile4_3), false);
	
	
		//Actually add a piece
		testBoard1.addPiece(testPiece1, boardTile0_0);
		
		//Test if pieces can be added on top of each other and such.
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_0), true);
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_1), true);
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		
		//test that pieces can not be removed.
		assertEquals(testBoard1.canRemovePiece(testPiece1), false);
		
		//Test if we can add the piece in the new state, ie, peiece removal worked.
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		
		//Add the second piece
		testBoard1.addPiece(testPiece2, boardTile0_0);
		
		//Make sure we can add the piece on top of the newly shifted piece.
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_1), true);
		
		//Make sure shifting removed the piece from it's old area.
		testBoard1.addPiece(testPiece1, boardTile0_0);
	}
}
