package kabasuji.modelTests;

import junit.framework.TestCase;
import kabasuji.model.Board;
import kabasuji.model.Piece;
import kabasuji.model.ReleaseBoard;
import kabasuji.model.Tile;

public class BoardReleaseTest extends TestCase{
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
		
		Tile boardTile0_0 = new Tile(false, true, 1, 1);
		Tile boardTile0_1 = new Tile(false, true, 1, 2);
		Tile boardTile0_2 = new Tile(false, true, 1, 3);
		Tile boardTile0_3 = new Tile(false, true, 1, 4);
		Tile boardTile0_4 = new Tile(false, true, 1, 5);
		Tile boardTile0_5 = new Tile(false, true, 1, 6);
		Tile boardTile1_0 = new Tile(false, true, 2, 1);
		Tile boardTile1_1 = new Tile(false, true, 2, 2);
		Tile boardTile1_2 = new Tile(false, true, 2, 3);
		Tile boardTile1_3 = new Tile(false, true, 2, 4);
		Tile boardTile1_4 = new Tile(false, true, 2, 5);
		Tile boardTile1_5 = new Tile(false, true, 2, 6);
		Tile boardTile2_0 = new Tile(false, true, 3, 1);
		Tile boardTile2_1 = new Tile(false, true, 3, 2);
		Tile boardTile2_2 = new Tile(false, true, 3, 3);
		Tile boardTile2_3 = new Tile(false, true, 3, 4);
		Tile boardTile2_4 = new Tile(false, true, 3, 5);
		Tile boardTile2_5 = new Tile(false, true, 3, 6);
		Tile boardTile3_0 = new Tile(false, true, 0, 0);
		Tile boardTile3_1 = new Tile(false, true, 0, 0);
		Tile boardTile3_2 = new Tile(false, true, 0, 0);
		Tile boardTile3_3 = new Tile(false, true, 0, 0);
		Tile boardTile3_4 = new Tile(false, false, 0, 0);
		Tile boardTile3_5 = new Tile(false, false, 0, 0);
		Tile boardTile4_0 = new Tile(false, false, 0, 0);
		Tile boardTile4_1 = new Tile(false, false, 0, 0);
		Tile boardTile4_2 = new Tile(false, false, 0, 0);
		Tile boardTile4_3 = new Tile(false, false, 0, 0);
		Tile boardTile4_4 = new Tile(false, false, 0, 0);
		Tile boardTile4_5 = new Tile(false, false, 0, 0);		
		Tile boardTile5_0 = new Tile(false, true, 0, 0);
		Tile boardTile5_1 = new Tile(false, true, 0, 0);
		Tile boardTile5_2 = new Tile(false, true, 0, 0);
		Tile boardTile5_3 = new Tile(false, true, 0, 0);
		Tile boardTile5_4 = new Tile(false, true, 0, 0);
		Tile boardTile5_5 = new Tile(false, true, 0, 0);
		
		
		Tile board3Tile0_0 = new Tile(false, true, 1, 1);
		Tile board3Tile0_1 = new Tile(false, true, 1, 2);
		Tile board3Tile0_2 = new Tile(false, true, 1, 3);
		Tile board3Tile0_3 = new Tile(false, true, 1, 4);
		Tile board3Tile0_4 = new Tile(false, true, 1, 5);
		Tile board3Tile0_5 = new Tile(false, true, 1, 6);
		Tile board3Tile1_0 = new Tile(false, true, 2, 1);
		Tile board3Tile1_1 = new Tile(false, true, 2, 2);
		Tile board3Tile1_2 = new Tile(false, true, 2, 3);
		Tile board3Tile1_3 = new Tile(false, true, 2, 4);
		Tile board3Tile1_4 = new Tile(false, true, 2, 5);
		Tile board3Tile1_5 = new Tile(false, true, 2, 6);
		Tile board3Tile2_0 = new Tile(false, true, 3, 1);
		Tile board3Tile2_1 = new Tile(false, true, 3, 2);
		Tile board3Tile2_2 = new Tile(false, true, 3, 3);
		Tile board3Tile2_3 = new Tile(false, true, 3, 4);
		Tile board3Tile2_4 = new Tile(false, true, 3, 5);
		Tile board3Tile2_5 = new Tile(false, true, 3, 6);
		Tile board3Tile3_0 = new Tile(false, true, 0, 0);
		Tile board3Tile3_1 = new Tile(false, true, 0, 0);
		Tile board3Tile3_2 = new Tile(false, true, 0, 0);
		Tile board3Tile3_3 = new Tile(false, true, 0, 0);
		Tile board3Tile3_4 = new Tile(false, false, 1, 1);
		Tile board3Tile3_5 = new Tile(false, false, 1, 2);
		Tile board3Tile4_0 = new Tile(false, false, 0, 0);
		Tile board3Tile4_1 = new Tile(false, false, 0, 0);
		Tile board3Tile4_2 = new Tile(false, false, 2, 3);
		Tile board3Tile4_3 = new Tile(false, false, 2, 6);
		Tile board3Tile4_4 = new Tile(false, false, 3, 1);
		Tile board3Tile4_5 = new Tile(false, false, 3, 2);		
		Tile board3Tile5_0 = new Tile(false, true, 3, 3);
		Tile board3Tile5_1 = new Tile(false, true, 3, 4);
		Tile board3Tile5_2 = new Tile(false, true, 3, 5);
		Tile board3Tile5_3 = new Tile(false, true, 3, 6);
		Tile board3Tile5_4 = new Tile(false, true, 0, 0);
		Tile board3Tile5_5 = new Tile(false, true, 0, 0);

		Tile boardTileCopyTest = new Tile(true, false, 1, 3);
	
		
		Tile[][] piece1 = {{testTile1, testTile2},{testTile3, testTile4}};
		Tile[][] piece2 = {{testTile5, testTile6},{testTile7, testTile8}};
		Tile[][] board1 = 
			{{boardTile0_0,boardTile0_1,boardTile0_2,boardTile0_3,boardTile0_4,boardTile0_5},
			{boardTile1_0,boardTile1_1,boardTile1_2,boardTile1_3,boardTile1_4,boardTile1_5},
			{boardTile2_0,boardTile2_1,boardTile2_2,boardTile2_3,boardTile2_4,boardTile2_5},
			{boardTile3_0,boardTile3_1,boardTile3_2,boardTile3_3,boardTile3_4,boardTile3_5},
			{boardTile4_0,boardTile4_1,boardTile4_2,boardTile4_3,boardTile4_4,boardTile4_5},
			{boardTile5_0,boardTile5_1,boardTile5_2,boardTile5_3,boardTile5_4,boardTile5_5}};
		Tile[][] board2 = 
			{{boardTile0_0,boardTile0_1,boardTile0_2,boardTile0_3,boardTile0_4,boardTile0_5},
			{boardTile1_0,boardTile1_1,boardTile1_2,boardTile1_3,boardTile1_4,boardTile1_5},
			{boardTile2_0,boardTile2_1,boardTile2_2,boardTile2_3,boardTile2_4,boardTile2_5},
			{boardTile3_0,boardTile3_1,boardTile3_2,boardTile3_3,boardTile3_4,boardTile3_5},
			{boardTile4_0,boardTile4_1,boardTile4_2,boardTile4_3,boardTile4_4,boardTile4_5},
			{boardTile5_0,boardTile5_1,boardTile5_2,boardTile5_3,boardTile5_4,boardTileCopyTest}};
		Tile[][] board3 = 
			{{board3Tile0_0,board3Tile0_1,board3Tile0_2,board3Tile0_3,board3Tile0_4,board3Tile0_5},
			{board3Tile1_0,board3Tile1_1,board3Tile1_2,board3Tile1_3,board3Tile1_4,board3Tile1_5},
			{board3Tile2_0,board3Tile2_1,board3Tile2_2,board3Tile2_3,board3Tile2_4,board3Tile2_5},
			{board3Tile3_0,board3Tile3_1,board3Tile3_2,board3Tile3_3,board3Tile3_4,board3Tile3_5},
			{board3Tile4_0,board3Tile4_1,board3Tile4_2,board3Tile4_3,board3Tile4_4,board3Tile4_5},
			{board3Tile5_0,board3Tile5_1,board3Tile5_2,board3Tile5_3,board3Tile5_4,board3Tile5_5}};
		
	
		/* 11
		 * 00
		 */
		Piece testPiece1 = new Piece(piece1);
											 
		/* 01
		 * 01
		 */
		Piece testPiece2 = new Piece(piece2);
		
		Board testBoard1 = new ReleaseBoard(board1);
		Board testBoard2 = new ReleaseBoard(board2);
		Board testBoard3 = new ReleaseBoard(board3);
		
		
		assertEquals(testBoard1.equals(testBoard1), true);
		assertEquals(testBoard1.equals(testBoard1.copy()), true);
		assertEquals(testBoard1.equals(testBoard2), false);
		
		//Test if piece can be added to valid area of board
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		
		//test if piece cannot be added to a valid part of the board that would leave
		//some of the piece off the board
		assertEquals (testBoard1.canAddPiece(testPiece2, boardTile3_4), false);
		assertEquals (testBoard1.canAddPiece(testPiece2, boardTile4_3), false);
		assertEquals (testBoard1.canAddPiece(testPiece1, boardTile4_4), false);
	
	
		//Actually add a piece
		testBoard1.addPiece(testPiece1, boardTile0_0);
		
		//Test if pieces can be added on top of each other and such.
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_0), false);
		assertEquals(testBoard1.canAddPiece(testPiece2, boardTile0_1), true);
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), false);
		
		//test that pieces can be correctly removed.
		assertEquals(testBoard1.canRemovePiece(testPiece1), false);
		testBoard1.removePiece(testPiece1);
		
		//Test if we can add the piece in the new state, ie, peiece removal worked.
		assertEquals(testBoard1.canAddPiece(testPiece1, boardTile0_0), true);
		
		assertEquals(testBoard1.getStars(), 0);
		

		//Cover all color 1 pieces.
		testBoard1.addPiece(testPiece1, boardTile0_0);
		testBoard1.addPiece(testPiece1, boardTile0_2);
		assertEquals(testBoard1.getStars(), 0);
		testBoard1.addPiece(testPiece1, boardTile0_4);
		assertEquals(testBoard1.getStars(), 1);

		//Cover all color 2 pieces.
		testBoard1.addPiece(testPiece1, boardTile1_0);
		testBoard1.addPiece(testPiece1, boardTile1_2);
		assertEquals(testBoard1.getStars(), 1);
		testBoard1.addPiece(testPiece1, boardTile1_4);
		assertEquals(testBoard1.getStars(), 2);

		//Cover all color 3 pieces.
		testBoard1.addPiece(testPiece1, boardTile2_0);
		testBoard1.addPiece(testPiece1, boardTile2_2);
		assertEquals(testBoard1.getStars(), 2);
		testBoard1.addPiece(testPiece1, boardTile2_4);
		assertEquals(testBoard1.getStars(), 3);
		
		assertEquals(testBoard1.isComplete(), true);
		
		
		
		assertEquals(testBoard3.getStars(), 0);
		

		//Cover all color 1 pieces in first row, leaving 2  extras.
		testBoard3.addPiece(testPiece1, board3Tile0_0);
		testBoard3.addPiece(testPiece1, board3Tile0_2);
		assertEquals(testBoard3.getStars(), 0);
		testBoard3.addPiece(testPiece1, board3Tile0_4);
		assertEquals(testBoard3.getStars(), 1);

		//Cover all color 2 pieces in 2nd row, leaving 2 extras
		testBoard3.addPiece(testPiece1, board3Tile1_0);
		testBoard3.addPiece(testPiece1, board3Tile1_2);
		assertEquals(testBoard3.getStars(), 1);
		testBoard3.addPiece(testPiece1, board3Tile1_4);
		assertEquals(testBoard3.getStars(), 2);

		//Cover all color 3 pieces in 3rd row, but the full set of color3's exists elsewhere in board.
		testBoard3.addPiece(testPiece1, board3Tile2_0);
		testBoard3.addPiece(testPiece1, board3Tile2_2);
		assertEquals(testBoard3.getStars(), 2);
		testBoard3.addPiece(testPiece1, board3Tile2_4);
		assertEquals(testBoard3.getStars(), 3);
		
		assertEquals(testBoard3.isComplete(), true);
	}
}
