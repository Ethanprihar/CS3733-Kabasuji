package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class TileTest extends TestCase{

	protected void setUp()
	{
	}
	
	public void testTiles()
	{
		Tile testTile1 = new Tile(false, true, 0, 0);
		Tile testTile2 = new Tile(false, false, 0, 0);
		Tile testTile3 = new Tile(true, false, 0, 0);
		Tile testTile4 = new Tile(true, true, 0, 0);
		Tile testTile5 = new Tile(false, false, 1, 1);
		Tile testTile6 = new Tile(false, false, 2, 2);
		Tile testTile7 = new Tile(false, false, 3, 3);
		Tile testTile8 = new Tile(false, false, 1, 4);
		Tile testTile9 = new Tile(false, false, 2, 5);
		Tile testTile10 = new Tile(false, false, 3, 6);
		Tile testTile11 = new Tile(true, false, 1, 1);
		Tile testTile12 = new Tile(false, false, 1, 1);
		Tile testTile13 = new Tile(false, false, 1, 1);
		Tile testTile14 = new Tile(false, false, 2, 1);
		
		
		Tile[][] piece1 = {{testTile1, testTile2},{testTile2, testTile1}};
		Piece testPiece1 = new Piece(piece1);

		assertEquals (testTile3.equals(testTile3), true);
		assertEquals (testTile3.equals(testTile4), false);
		assertEquals (testTile3.equals(testTile3.copy()), true);
		assertEquals (testTile5.equals(testTile6), false);
		assertEquals (testTile7.equals(testTile8), false);
		assertEquals (testTile9.equals(testTile10), false);
		assertEquals(testTile11.isHint(), true);
		assertEquals(testTile12.isHint(), false);
		assertEquals (testTile11.equals(testTile12), false);
		assertEquals (testTile12.equals(testTile13), true);
		assertEquals (testTile13.equals(testTile14), false);

		
		
		assertEquals (testTile1.getNumber(), 0);
		assertEquals (testTile1.isHint(), false);

		testTile1.toggleHint();
		assertEquals(testTile1.isHint(), true);
		
		testTile1.toggleHint();
		assertEquals(testTile1.isHint(), false);
		
		assertEquals(testTile1.getColor(), 0);

		assertEquals(testTile1.getPiece(), testPiece1);
		assertEquals(testTile2.getPiece(), null);
		
		testTile2.setValid(true);
		
		assertEquals(testTile2.isValid(), true);

		testTile2.setHint(true);
		assertEquals(testTile2.isHint(), true);
		
		testTile2.setColor(3);
		testTile2.setNumber(6);
		assertEquals(testTile2.getColor(), 3);
		assertEquals(testTile2.getNumber(), 6);

		

	}
}
