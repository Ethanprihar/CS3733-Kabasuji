package kabasuji.model;

@SuppressWarnings("serial")

/**
 * This class is the model class for the puzzzle board. It extends the abstract board class for all the shared logic
 * across the three different types of the boards. This class only has the logic specific to the puzzle board.
 * @author Ethan
 *
 */
public class PuzzleBoard extends Board {

	/**
	 * Constructor for the class
	 * @param t 2D array of tile
	 */
	public PuzzleBoard(Tile[][] t) {
		super(t);
	}
	
	/**
	 * This method determines if the given piece can be added to the puzzle board or not.
	 * It is same as the canAddPiece method except that a piece can shift to overlap itself.
	 * @param p The current piece which is being added
	 * @param start The start reference tile of the piece which is being added
	 * @return True if the piece can be added and false if the piece can not be added
	 */
	public boolean canShiftPiece(Piece p, Tile start) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] == start) {
					int xoffset = (int) p.findReferencePoint().getX();
					int yoffset = (int) p.findReferencePoint().getY();
					for (int y = -yoffset; y < p.getDim()-yoffset; y++) {
						for (int x = -xoffset; x < p.getDim()-xoffset; x++) {
							try { // If we're trying to place a piece out of
									// range of the board
								if (((p.getTile(y+yoffset, x+xoffset).isValid()) && !(tiles[i + y][j + x].isValid())))
									return false;
								else if (((p.getTile(y+yoffset, x+xoffset).isValid()) && !((tiles[i + y][j + x].getPiece() == null)
										|| (tiles[i + y][j + x].getPiece() == p))))
									return false;
							} catch (IndexOutOfBoundsException e) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * Shifts a piece on the board to another valid location on the board.
	 * @param p The piece to be shifted
	 * @param start The start reference tile of the piece which is being shifted
	 */
	public void shiftPiece(Piece p, Tile start) {
		removePiece(p);
		addPiece(p, start);
	}

	/**
	 * The method to copy the puzzle board.
	 * @return The copied puzzle board
	 */
	public PuzzleBoard copy() {
		Tile[][] t = new Tile[tiles.length][tiles.length];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				t[i][j] = tiles[i][j].copy();
			}
		}
		return new PuzzleBoard(t);
	}

	/**
	 * Method to determine if the piece can be removed from the board.
	 * Can always remove pieces from the puzzle boards.
	 * @return True as we can always remove pieces from the puzzle board
	 */
	@Override
	public boolean canRemovePiece(Piece p) {
		return true;
	}
}
