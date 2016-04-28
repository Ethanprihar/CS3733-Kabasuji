package kabasuji.model;

@SuppressWarnings("serial")
public class PuzzleBoard extends Board {

	public PuzzleBoard(Tile[][] t) {
		super(t);
	}

	/**
	 * Same as canAddPiece function except that a piece can shift to overlap
	 * itself.
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
	 */
	public void shiftPiece(Piece p, Tile start) {
		removePiece(p);
		addPiece(p, start);
	}

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
	 * Can always remove pieces from the puzzle boards.
	 */
	@Override
	public boolean canRemovePiece(Piece p) {
		return true;
	}
}
