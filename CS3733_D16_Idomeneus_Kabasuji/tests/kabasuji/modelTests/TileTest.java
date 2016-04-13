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
		Tile[][] piece1 = {{testTile1, testTile2},{testTile2, testTile1}};
		Piece testPiece1 = new Piece(piece1);

		
		
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
