package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Tile;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
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
	Bullpen bullpen;
	JLabelIcon tile;

	PlayLevelPanel panel;

	BoardView boardview;
	BullpenView bullpenview;

	String fn;
	Piece selectedPiece;
	Tile[][] tiles;
	Tile selfTile;
	Kabasuji kabasuji;
	JLabelIcon[] tileimgs;

	public TileController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon tile, Tile selfTile) {
		this.panel = panel;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.tiles = board.getTiles();
		this.tile = tile;
		this.fn = tile.getFileName();
		this.selfTile = selfTile;
		this.kabasuji = kabasuji;
		this.boardview = panel.getBoardView();
		this.bullpenview = panel.getBullpenView();
		this.tileimgs = boardview.getTileImages();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		bullpen = kabasuji.getSelectedLevel().getBullpen();
		bullpenview = panel.getBullpenView();
		if (board.canAddPiece(selectedPiece, selfTile)) {
			board.addPiece(selectedPiece, selfTile);
			displayHoverPiece("bluenightbutton.png", true, false);
			bullpen.selectPiece(null);
			bullpen.removePiece(selectedPiece);
			bullpenview.setupBullpen();
			panel.getZoomPiece().removeAll();
			panel.repaint();
			// update to show new number of moves if in puzzle mode
			if (kabasuji.getSelectedLevel() instanceof PuzzleLevel) {
				// decrement the number of moves left
				((PuzzleLevel)kabasuji.getSelectedLevel()).setMovesUsed(((PuzzleLevel)kabasuji.getSelectedLevel()).getMovesUsed() + 1);
				panel.setMovesLeftNum((Integer) ((PuzzleLevel) kabasuji.getSelectedLevel()).getMovesLeft());
			}
			// update to show new number of moves if in puzzle mode
			else if (kabasuji.getSelectedLevel() instanceof ReleaseLevel) {
				// decrement the number of moves left
				((ReleaseLevel)kabasuji.getSelectedLevel()).setMovesUsed(((ReleaseLevel)kabasuji.getSelectedLevel()).getMovesUsed() + 1);
				panel.setMovesLeftNum((Integer) ((ReleaseLevel) kabasuji.getSelectedLevel()).getMovesLeft());
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();

		if (selectedPiece != null) {
			System.out.println("Have piece....");
			if (board.canAddPiece(selectedPiece, selfTile)) {
				System.out.println("Can place.");
				displayHoverPiece("bluenightbutton.png", false, false);
			} else {
				System.out.println("Cannot place.");
				displayHoverPiece("rednightbutton.png", false, false);

			}
		}
	}

	public void mouseExited(MouseEvent e) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		if (selectedPiece != null) {
			displayHoverPiece("general1button.png", false, true);
			// tile.setImg(fn);
		}
	}

	public void displayHoverPiece(String hpfn, boolean setNewFilename, boolean setOriginalImg) {
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
									if (setNewFilename) {
										tileimgs[(j + y) * tiles.length + (i + x)].setFileName(hpfn);
									}
									if (setOriginalImg) {
										String origfn = tileimgs[(j + y) * tiles.length + (i + x)].getFileName();
										tileimgs[(j + y) * tiles.length + (i + x)].setImg(origfn);
									} else {
										tileimgs[(j + y) * tiles.length + (i + x)].setImg(hpfn);
									}
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
