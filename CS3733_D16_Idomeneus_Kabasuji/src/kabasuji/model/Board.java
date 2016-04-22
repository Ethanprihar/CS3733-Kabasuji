package kabasuji.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author odell
 *
 */

@SuppressWarnings("serial")
public abstract class Board implements Serializable {
	Tile[][] tiles;
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	Piece selectedPiece; // The selected piece. May be null.
	int[][] paintLocs = new int[6][2];

	Board(Tile[][] t) {
		this.tiles = t;
	}

	/**
	 * 
	 * This method adds a piece to the board using a tile on the board as the
	 * anchor point for the overlapping of the piece's matrix of tiles onto the
	 * board's matrix of tiles. Only tiles in the piece's matrix that contain a
	 * piece will be copied to the board's matrix.
	 */
	public void addPiece(Piece p, Tile start) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] == start) {
					for (int y = 0; y < p.getDim(); y++) {
						for (int x = 0; x < p.getDim(); x++) {

							if (p.getTile(y, x).isValid()) {
								tiles[i + y][j + x].setPiece(p);
								tiles[i + y][j + x].setValid(true);
							}
						}
					}
					return;
				}
			}
		}
		pieces.add(p);
	}

	/**
	 * Removes a piece from the board.
	 */
	public void removePiece(Piece p) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j].getPiece() == p) {
					tiles[i][j].setPiece(null);
				}
			}
		}
		pieces.remove(p);
	}

	/**
	 * Can piece be added to the board, given target tile as anchor
	 * 
	 */
	public boolean canAddPiece(Piece p, Tile start) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] == start) {
					System.out.print("Start found at ");
					System.out.print(i);
					System.out.print(",");
					System.out.println(j);
					int validcount = 0;
					int xoffset = (int) p.findReferencePoint().getX();
					int yoffset = (int) p.findReferencePoint().getY();
					for (int y = -yoffset; y < p.getDim() - yoffset; y++) {
						for (int x = -xoffset; x < p.getDim() - xoffset; x++) {
							try { // If we're trying to place a piece out of
									// range of the board
								if ((p.getTile(y + yoffset, x + xoffset).isValid())) {
									if (!(tiles[j + y][i + x].isValid())) {
										System.out.print("Piece valid, tile not. Tile:");
										System.out.print(j + x);
										System.out.print(",");
										System.out.print(i + y);
										System.out.print(". Piece valid loc:");
										System.out.print(y);
										System.out.print(",");
										System.out.println(x);
										return false;
									} else if (!(tiles[j + y][i + x].getPiece() == null)) {
										System.out.println("Piece already here.");
										return false;
									} else if (tiles[j + y][i + x].isValid()){
										validcount++;
										if (validcount == 6) {
											return true;
										}
									}
								}
							} catch (IndexOutOfBoundsException e) {
								System.out.println("Out of bounds!!");
							}

						}
					}
				} else {
					// return false;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the locations of the pieces that need to be painted when we are
	 * hovering over Tile start
	 * 
	 * 
	 * @param p
	 * @param start
	 * @return
	 */
	public void updateHoverPaintLocations(Piece p, Tile start)// Returns the
																// locations
																// that need to
																// be painted
	{
		int[][] paintLocations = new int[6][2];
		int xLoc = 0;
		int yLoc = 0;

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (true)// tiles[i][j].equals(start))
				{
					for (int y = 0; y < p.getDim(); y++) {
						for (int x = 0; x < p.getDim(); x++) {
							try // If we're trying to place a piece out of range
								// of the board
							{
								if ((p.getTile(y, x).isValid())) {
									paintLocations[xLoc][yLoc] = i + y;
									System.out.println(paintLocations[xLoc][yLoc]);
									yLoc++;
									paintLocations[xLoc][yLoc] = j + x;
									System.out.println(paintLocations[xLoc][yLoc]);
									xLoc++;
								}
							} catch (IndexOutOfBoundsException e) {
								// Do nothing
							}
						}
					}
				}
			}
		}
		paintLocs = paintLocations;
	}

	/**
	 * Default false, puzzle overrides.
	 */
	public boolean canRemovePiece(Piece p) {
		return false;
	}

	// Sets the selected piece in memory to the given newly selected piece.
	public void selectPiece(Piece p) {
		this.selectedPiece = p;
	}

	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	/**
	 * Common to both Puzzle and Lightning boards. Release has it's own
	 * override.
	 */
	public int getStars() {

		int uncoveredTiles = 0;
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j].isValid() && tiles[i][j].getPiece() == null) {
					uncoveredTiles++;
				}
			}
		}
		// Return the number of stars.
		return (uncoveredTiles == 0) ? 3 : (uncoveredTiles <= 6) ? 2 : (uncoveredTiles <= 12) ? 1 : 0;
	}

	public boolean equals(Board b) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (!(tiles[i][j].equals(b.getTiles()[i][j]))) {
					return false;
				}
			}
		}
		return true;
	}

	public abstract Board copy();

	public void shiftPiece(Piece p, Tile start) {
	}

	public boolean canShiftPiece(Piece p, Tile start) {
		return false;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public boolean isComplete() {
		if (this.getStars() == 3)
			return true;
		else
			return false;
	}

	public Point getPosition(Tile tilepnt) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (tiles[j][i] == tilepnt) {
					return new Point(j, i);
				}
			}
		}
		return null;

	}
}
