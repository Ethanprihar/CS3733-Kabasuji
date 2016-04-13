package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class TileTest extends TestCase{

	protected void setUp()
	{
	}
	
	public void testTiles()
	{
		Tile testTile1 = new Tile(false, false, 0, 0);
		Tile[][] piece1 = {{testTile1, testTile1},{testTile1, testTile1}};
		Piece testPiece1 = new Piece(piece1);

		
		
		assertEquals (testTile1.getNumber(), 0);
		assertEquals (testTile1.isHint(), false);

		testTile1.toggleHint();
		assertEquals(testTile1.isHint(), true);
		
		testTile1.toggleHint();
		assertEquals(testTile1.isHint(), false);
		
		assertEquals(testTile1.getColor(), 0);
		
		assertEquals(testTile1.getPiece(), testPiece1);
		
	}
}
