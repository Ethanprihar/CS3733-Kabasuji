package kabasuji.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is the model class for the board. It contains all the logic for the board as to whether a piece 
 * can be added to the board or removed from the board. It also calculates and stores the information for the 
 * stars and figure out the number of stars. All in all, all the logic about the state of the board is in here. 
 * @author Odell Dotson
 *
 */

@SuppressWarnings("serial")
public abstract class Board implements Serializable {

	/** The tiles for the board */
	Tile[][] tiles;
	
	/** Pieces arraylist in the level */
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	/** The selected piece */
	Piece selectedPiece; // The selected piece. May be null.
	
	/** Hover effect on the board for the piece */
	int[][] paintLocs = new int[6][2];
	
	/** The number of stars the player has at a given time */
	int numStars;

	/**
	 * Board constructor
	 * @param t The tiles for the board
	 */
	Board(Tile[][] t) {
		this.tiles = t;
		numStars = 0;
	}

	/**
	 * This method adds a piece to the board using a tile on the board as the
	 * anchor point for the overlapping of the piece's matrix of tiles onto the
	 * board's matrix of tiles. Only tiles in the piece's matrix that contain a
	 * piece will be copied to the board's matrix.
	 * @param p The current piece which is being added
	 * @param start The start reference tile of the piece which is being added
	 */
	public void addPiece(Piece p, Tile start) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] == start) {
					int xoffset = (int) p.findReferencePoint().getX();
					int yoffset = (int) p.findReferencePoint().getY();
					for (int y = -yoffset; y < p.getDim()-yoffset; y++) {
						for (int x = -xoffset; x < p.getDim()-xoffset; x++) {
							if (p.getTile(y+yoffset, x+xoffset).isValid()) {
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
	 * This method removes the specified piece from the board.
	 * @param p The piece to be removed
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
	 * This method determines if the given piece can be added to the board or not.
	 * @param p The current piece which is being added
	 * @param start The start reference tile of the piece which is being added
	 * @return True if the piece can be added and false if the piece can not be added
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
									if (!(tiles[i + y][j + x].isValid())) {
										System.out.print("Piece valid, tile not. Tile:");
										System.out.print(j + x);
										System.out.print(",");
										System.out.print(i + y);
										System.out.print(". Piece valid loc:");
										System.out.print(y);
										System.out.print(",");
										System.out.println(x);
										return false;
									} else if (!(tiles[i + y][j + x].getPiece() == null)) {
										System.out.println("Piece already here.");
										return false;
									} else if (tiles[i + y][j + x].isValid()){
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
	 * hovering over Tile start.
	 * @param p The current piece which is selected
	 * @param start The start reference tile of the piece which is being added
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
	 * This method determines if the specified piece can be removed or not.
	 * @param p The current piece which is selected
	 * @return False
	 */
	public boolean canRemovePiece(Piece p) {
		return false;
	}

	/**
	 * Sets the selected piece in memory to the given newly selected piece.
	 * @param p The current piece which is selected
	 */
	public void selectPiece(Piece p) {
		this.selectedPiece = p;
	}

	/**
	 * Getter to get the selected piece
	 * @return The selected piece
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	/**
	 * Get the number of stars the player has. Common to both Puzzle and Lightning boards. Release has it's own
	 * override.
	 * @return The number of stars (0 to 3)
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
	
	/**
	 * Returns the number of stored stars for that board.
	 * @return The number of stars for the board
	 */
	public int getNumStars() {
		return numStars;
	}
	
	/**
	 * Sets the stored number of stars for the board.
	 * @param The number to be set
	 */
	public void setNumStars(int stars) {
		numStars = stars;
	}

	/**
	 * This method determines if the specified board is equal to the current board.
	 * @param b The board to be checked
	 * @return True if it is equal and false if it is not equal
	 */
	public boolean equals(Board b) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (!(tiles[i][j].equals(b.getTile(i,j))))
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * The abstract method to copy the board.
	 * @return The copied board
	 */
	public abstract Board copy();

	/**
	 * This method shifts the specified the piece.
	 * @param p The current piece which is selected
	 * @param start The start reference tile of the piece which is being shifted
	 */
	public void shiftPiece(Piece p, Tile start) {
	}

	/**
	 * This method determines if the specified piece can be shifted.
	 * @param p The current piece which is selected
	 * @param start The start reference tile of the piece which is being shifted
	 * @return False
	 */
	public boolean canShiftPiece(Piece p, Tile start) {
		return false;
	}

	/**
	 * Getter method for the tiles.
	 * @return The tiles of the board
	 */
	public Tile[][] getTiles() {
		return tiles;
	}

	/**
	 * This method checks if the board is complete or not.
	 * @return True if it is complete and false if it is not
	 */
	public boolean isComplete() {
		if (this.getStars() == 3)
			return true;
		else
			return false;
	}
	
	/**
	 * Getter method for a particular tile.
	 * @param y The y reference point
	 * @param x The x reference point
	 * @return The particular tile
	 */
	public Tile getTile(int y, int x)
	{
		return tiles[y][x];
	}

	/**
	 * This method returns the position of the specified tile.
	 * @param tilepnt The specified tile
	 * @return The position or null if not any
	 */
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
	
	public String toString()
	{
		String returnString = "";
		for (int i = 0; i < tiles.length; i++)
		{
			for (int j = 0; j < tiles.length; j++)
			{
				returnString += tiles[i][j].toString();
			}
			returnString += "\n";
		}
		return returnString;
	}
}
