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
		
		assertEquals (testPiece1.equals(testPiece2), false);
		assertEquals (testPiece1.equals(testPiece1), true);
		
		Piece testPiece3 = testPiece1.copy();
		
		assertEquals (testPiece1.equals(testPiece3), true);
		assertEquals (testPiece2.equals(testPiece3), false);

		testPiece3.rotate(true);
		assertEquals (testPiece2.equals(testPiece3), true);
		
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
