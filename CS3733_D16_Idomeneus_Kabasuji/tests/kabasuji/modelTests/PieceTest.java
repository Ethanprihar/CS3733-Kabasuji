package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class PieceTest extends TestCase{

	protected void setUp()
	{
	}
	

	
	public void testPieces()
	{
		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, true, 0, 0);
		Tile testTile3 = new Tile(false, false, 0, 0);
		Tile testTile4 = new Tile(false, false, 0, 0);
		
		Tile testTile5 = new Tile(false, false, 0, 0);
		Tile testTile6 = new Tile(false, false, 0, 0);
		Tile testTile7 = new Tile(false, true, 0, 0);
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
		
		Tile[][] piece1 = {{testTile1, testTile2},{testTile3, testTile4}};
		Tile[][] piece2 = {{testTile4, testTile1},{testTile3, testTile2}};

		/* 11
		 * 00
		 */
		Piece testPiece1 = new Piece(piece1);
											 
		/* 01
		 * 01
		 */
		Piece testPiece2 = new Piece(piece2);
		
		//Test if basic dimension getter is working right.
		assertEquals (testPiece1.getDim(), 2);	
		
		//Rotate the first piece to the right.
		testPiece1.rotate(true);

		//Test that piece1 matches piece2 after being rotated to the right.
		for(int i = 0; i<testPiece1.getDim(); i++)
		{
			for(int j = 0; j<testPiece1.getDim(); j++)
			assertEquals (testPiece1.getTile(j, i).isValid(), testPiece2.getTile(j, i).isValid());
		}		
		
		testPiece1.rotate(false);
		testPiece1.rotate(false);
		testPiece2.rotate(false);
		testPiece2.rotate(false);
		
		//Test that piece1 matches piece2 after being rotated to the right.
		for(int i = 0; i<testPiece1.getDim(); i++)
		{
			for(int j = 0; j<testPiece1.getDim(); j++)
			assertEquals (testPiece1.getTile(j, i).isValid(), testPiece2.getTile(j, i).isValid());
		}		
	}
}
