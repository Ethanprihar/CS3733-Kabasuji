package kabasuji.modelTests;

import kabasuji.model.*;
import junit.framework.TestCase;

public class LevelTest extends TestCase {

	protected void setUp() {
	}

	public void testLevels() {

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

		Tile[][] piece1 = { { testTile1, testTile2 }, { testTile3, testTile4 } };
		Tile[][] piece2 = { { testTile5, testTile6 }, { testTile7, testTile8 } };

		// all tiles are invalid
		Tile[][] board1 = { { boardTile0_0, boardTile0_1, boardTile0_2, boardTile0_3 },
				{ boardTile1_0, boardTile1_1, boardTile1_2, boardTile1_3 },
				{ boardTile2_0, boardTile2_1, boardTile2_2, boardTile2_3 },
				{ boardTile3_0, boardTile3_1, boardTile3_2, boardTile3_3 } };

		// all tiles are invalid
		Tile[][] board1v = { { boardTile0_0v, boardTile0_1v, boardTile0_2v, boardTile0_3v },
				{ boardTile1_0v, boardTile1_1v, boardTile1_2v, boardTile1_3v },
				{ boardTile2_0v, boardTile2_1v, boardTile2_2v, boardTile2_3v },
				{ boardTile3_0v, boardTile3_1v, boardTile3_2v, boardTile3_3v } };

		Piece testPiece2 = new Piece(piece2);

		PuzzleBoard puzzBoard1 = new PuzzleBoard(board1);
		PuzzleBoard puzzBoardv = new PuzzleBoard(board1v);

		// make a new bullpen
		Bullpen bullpen1 = new Bullpen();
		Tile[][] piece3 = { { testTile1, testTile2 }, { testTile2, testTile1 } };
		Piece testPiece1 = new Piece(piece1);
		bullpen1.addPiece(testPiece1);

		// make a new Puzzle Level Test
		PuzzleLevel puzzTest = new PuzzleLevel(puzzBoard1, bullpen1, 10);

		puzzTest.setBullpen(bullpen1);

		assertEquals(puzzTest.getBullpen(), bullpen1);

		assertEquals(puzzTest.getStars(), 3);
		assertEquals(puzzTest.getBoard().getNumStars(), 0);

		assertEquals(puzzTest.isLocked(), false);

		assertEquals(puzzTest.canGoNextLevel(), true);

		puzzTest.setLocked(true);

		puzzTest.getStars();
		assertEquals(puzzTest.canGoNextLevel(), true);

		assertEquals(puzzTest.getHighScore(), 0);

		puzzTest.setHighScore(3);

		puzzTest.setBoard(puzzBoard1);

		assertEquals(puzzTest.getBoard(), puzzBoard1);
		
		// have puzz test now use the board of valid tiles
		puzzTest.setBoard(puzzBoardv);
		assertEquals(puzzBoardv.getTile(0,0).isValid(), true);
		
		assertEquals(puzzTest.getBoard().getTile(0,0).getPiece(),null);
		assertEquals(puzzTest.getBoard(), puzzBoardv);
		
		// check that all of the tiles are valid and peices are null
		for(int i = 0; i < 4;i++) {
			for(int j = 0; j < 4; j++) {
				//assertEquals(puzzTest.getBoard().getTile(i,j).isValid(), true);
				assertEquals(puzzTest.getBoard().getTile(i,j).getPiece(), null);
				assertEquals(puzzBoardv.getTile(i,j).isValid(), true);
			}
		}
		
		assertEquals(puzzTest.getStars(), 0);
		assertEquals(puzzTest.canGoNextLevel(),false);

	}
}
