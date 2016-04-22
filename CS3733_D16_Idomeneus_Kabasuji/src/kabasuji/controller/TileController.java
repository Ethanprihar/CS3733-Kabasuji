package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.model.Board;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.Tile;
import kabasuji.view.BoardView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PlayLevelPanel;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When a desired tile is pressed, an action is attempted to progress game and
 * update board
 * 
 * @author jwu
 *
 */
public class TileController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Board board;
	JLabelIcon tile;

	PlayLevelPanel panel;

	BoardView boardview;

	String fn;
	int[][] highlightLocations;
	int xLoc;
	int yLoc;
	Piece selectedPiece;
	Tile[][] tiles;
	Tile selfTile;
	Kabasuji kabasuji;
	JLabelIcon[] tileimgs;

	public TileController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon tile, int highlightLocations[][], int y,
			int x, Tile selfTile) {
		this.panel = panel;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.tiles = board.getTiles();
		this.tile = tile;
		this.fn = tile.getFileName();
		this.highlightLocations = highlightLocations;
		xLoc = x;
		yLoc = y;
		this.selfTile = selfTile;
		this.kabasuji = kabasuji;
		this.boardview = panel.getBoardView();
		this.tileimgs = boardview.getTileImages();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {

	}

	public void mouseEntered(MouseEvent e) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		// Shows the shape of a piece.
		// for(int a = 0; a<6; a++)
		// {
		// for (int b = 0; b<6; b++)
		// {
		// System.out.print(selectedPiece.getTile(a, b).isValid());
		// }
		// System.out.println("");
		// }

		if (selectedPiece != null) {
			System.out.println("Have piece....");
			if (board.canAddPiece(selectedPiece, selfTile)) {
				System.out.println("Can place.");
				displayHoverPiece("generalclearedbutton.png");

			} else {
				System.out.println("Cannot place.");
				displayHoverPiece("general1button.png");

			}
		}
	}

	public void mouseExited(MouseEvent e) {
		if (selectedPiece != null) {
			displayHoverPiece(fn);
		}
		// tile.setImg(fn);
	}

	public void displayHoverPiece(String hpfn) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] == selfTile) {
					int xoffset = (int) selectedPiece.findReferencePoint().getX();
					int yoffset = (int) selectedPiece.findReferencePoint().getY();
					for (int y = -yoffset; y < selectedPiece.getDim() - yoffset; y++) {
						for (int x = -xoffset; x < selectedPiece.getDim() - xoffset; x++) {
							try {
								if ((selectedPiece.getTile(y + yoffset, x + xoffset).isValid())
										&& tiles[j + y][i + x].isValid()) {
									tileimgs[(j + y) * tiles.length + (i + x)].setImg(hpfn);
								}
							} catch (IndexOutOfBoundsException e) {
								System.out.println("Out of bounds!!");
							}
						}
					}
				}
			}
		}
	}
}
