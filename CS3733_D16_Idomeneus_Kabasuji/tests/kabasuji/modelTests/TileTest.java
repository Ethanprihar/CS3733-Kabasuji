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
		assertEquals (testTile1.getNumber(), 0);
	}
}
