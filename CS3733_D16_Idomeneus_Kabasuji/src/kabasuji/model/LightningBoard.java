package kabasuji.model;

@SuppressWarnings("serial")

/**
 * This class is the model class for the lightning board. It extends the abstract board class for all the shared logic
 * across the three different types of the boards. This class only has the logic specific to the lightning board.
 * @author Ethan
 *
 */
public class LightningBoard extends Board {

	/**
	 * Constructor for the lightning board
	 * @param t 2D array of tile
	 */
	public LightningBoard(Tile[][] t) {
		super(t);
	}

	/**
	 * This method determines if the given piece can be added to the lightning board or not. Overlaps are
	 * allowed on the lightning board.
	 * @param p The current piece which is being added
	 * @param start The start reference tile of the piece which is being added
	 * @return True if the piece can be added and false if the piece can not be added
	 */
	@Override
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
									} else {//if (!(tiles[i + y][j + x].getPiece() == null)) {
										// if a piece already exists there then
										// lightning level allows overlap
										System.out.println("Lightning tile is valid");
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
					System.out.println("Can't add piece");
				}
			}
		}
		System.out.println("Cant add piece");
		return false;
	}

	/**
	 * The method to copy the lightning board.
	 * @return The copied lightning board
	 */
	public LightningBoard copy() {
		Tile[][] t = new Tile[tiles.length][tiles.length];
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				t[i][j] = tiles[i][j].copy();
			}
		}
		return new LightningBoard(t);
	}
}
