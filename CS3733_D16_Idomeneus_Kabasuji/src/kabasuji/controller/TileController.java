package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.Level;
import kabasuji.model.LightningLevel;
import kabasuji.model.Piece;
import kabasuji.model.PuzzleLevel;
import kabasuji.model.ReleaseLevel;
import kabasuji.model.Tile;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PieceView;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.ZoomPanel;
import misc.MusicPlayer;

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

	/* Top Level Model */
	Kabasuji kabasuji;
	/* Board */
	Board board;
	/* 2D Tile Array in Board */
	Tile[][] tiles;
	/* Selected tile */
	Tile selfTile;
	/* Bullpen */
	Bullpen bullpen;
	/* Selected Piece*/
	Piece selectedPiece;
	/* Selected Level */
	Level currentlevel;

	/* Top Level Boundary */
	PlayLevelPanel panel;
	/* BoardView */
	BoardView boardview;
	/* BullpenView */
	BullpenView bullpenview;
	/* List of tile view */
	JLabelIcon[] tileimgs;
	/* Zoom Panel */
	ZoomPanel zoompanel;
	
	/* Tile View */
	JLabelIcon tile;
	/* original filename */
	String fn;
	
	/**
	 * Constructor for TileController.
	 * @param kabasuji
	 * @param panel the screen jpanel
	 * @param tile the view object on the board
	 * @param selfTile the model tile of reference on the board
	 */
	public TileController(Kabasuji kabasuji, PlayLevelPanel panel, JLabelIcon tile, Tile selfTile) {
		this.kabasuji = kabasuji;
		this.panel = panel;
		updateParameters();
		this.tiles = board.getTiles();
		this.zoompanel = panel.getZoomPanel();
		this.tile = tile;
		this.fn = tile.getFileName();
		this.selfTile = selfTile;
		this.tileimgs = boardview.getTileImages();
	}
	/**
	 * Update the parameters of the current level.
	 */
	public void updateParameters() {
		currentlevel = kabasuji.getSelectedLevel();
		bullpen = currentlevel.getBullpen();
		board = currentlevel.getBoard();
		bullpenview = panel.getBullpenView();
		boardview = panel.getBoardView();
		selectedPiece = bullpen.getSelectedPiece();
		if (bullpen.getSelectedPiece() == null) {
			selectedPiece = board.getSelectedPiece();
		}
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to add/remove piece from board.
	 */
	public void mousePressed(MouseEvent me) {
		updateParameters();
		if (bullpen.getSelectedPiece() != null) {
			if (SwingUtilities.isLeftMouseButton(me)) {
				if (currentlevel.canMoveBullpenToBoard(selfTile)) {
					board.addPiece(selectedPiece, selfTile);
					new MusicPlayer("success.wav").setVolume(-25);
					displayHoverPiece("bluenightbutton.png", true, false);
					
					bullpen.selectPiece(null);
					int numreplace = bullpen.getPieces().indexOf(selectedPiece);
					if(currentlevel instanceof LightningLevel){
						bullpen.replacePieceRand(numreplace);
					} else{
					bullpen.removePiece(selectedPiece);
					}
					bullpenview.setupBullpen();
					panel.getZoomPanel().removeAll();

					// update display of stars
					updateStarDisplay();

					// update to show new number of moves if in puzzle mode
					if (currentlevel instanceof PuzzleLevel) {
						// decrement the number of moves left
						((PuzzleLevel) currentlevel)
								.setMovesUsed(((PuzzleLevel) currentlevel).getMovesUsed() + 1);
						panel.setMovesLeftNum((Integer) ((PuzzleLevel) currentlevel).getMovesLeft());
					}
					// update to show new number of moves if in puzzle mode
					else if (currentlevel instanceof ReleaseLevel) {
						// decrement the number of moves left
						((ReleaseLevel) currentlevel)
								.setMovesUsed(((ReleaseLevel) currentlevel).getMovesUsed() + 1);
						panel.setMovesLeftNum((Integer) ((ReleaseLevel) currentlevel).getMovesLeft());
					}
				} else {
					new MusicPlayer("fail.wav").setVolume(-15);;
				}
			}
		} else if (board.getSelectedPiece() != null) {
			if (currentlevel instanceof PuzzleLevel) {
				if (currentlevel.canMoveBoardToBoard(selfTile)) {
					((PuzzleLevel) currentlevel).moveBoardToBoard(selfTile);
					displayHoverPiece("bluenightbutton.png", true, false);
					new MusicPlayer("success.wav").setVolume(-25);
					board.selectPiece(null);
					boardview.setupBoard();
					panel.getZoomPanel().removeAll();
					// updates the stars display
					updateStarDisplay();
					
//					// decrement the number of moves left
					((PuzzleLevel) currentlevel)
							.setMovesUsed(((PuzzleLevel) currentlevel).getMovesUsed() + 1);
					panel.setMovesLeftNum((Integer) ((PuzzleLevel) currentlevel).getMovesLeft());
					
				} else {
					new MusicPlayer("fail.wav").setVolume(-15);
				}
			}
		}
		if (kabasuji.getSelectedLevel() instanceof PuzzleLevel) {
			if (SwingUtilities.isRightMouseButton(me)) {
				try{
				if (board.getSelectedPiece() == null && bullpen.getSelectedPiece() == null) {
					board.selectPiece(selfTile.getPiece());
					boardSelectPiece(selfTile.getPiece());
					displayHoverPiece("square3.png", false, false);
					zoompanel.removeAll();
					zoompanel.displayPieceView(selfTile.getPiece());
				}
				}catch(NullPointerException e){
					System.out.println("TileController.java: no piece exists there");
				}
			}
		}

		// If the number of stars are 3, display the winning screen
		int currNumStars1 = currentlevel.getStars();
		if (currNumStars1 == 3) {
			try {
				Thread.sleep(100); // 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			panel.winningScreen();
		}
		panel.repaint();

		// If the number of moves become 0, display a lose screen in Puzzle
		// Level
		if ((currentlevel instanceof PuzzleLevel)) {
			int getMoves = ((PuzzleLevel) currentlevel).getMovesUsed();
			int maxMoves = ((PuzzleLevel) currentlevel).getMaxMoves();
			if ((getMoves == maxMoves) && (currNumStars1 == 0)) {
				try {
					Thread.sleep(100); // 1000 milliseconds is one second.
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				panel.losingScreen();
			}
			panel.repaint();
		}

		// If the number of moves become 0, display a lose screen in Release
		// Level
		if ((currentlevel instanceof ReleaseLevel)) {
			int getMoves = ((ReleaseLevel) currentlevel).getMovesUsed();
			int maxMoves = ((ReleaseLevel) currentlevel).getMaxMoves();
			if ((getMoves == maxMoves) && (currNumStars1 == 0)) {
				try {
					Thread.sleep(100); // 1000 milliseconds is one second.
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				panel.losingScreen();
			}
			panel.repaint();
		}
	}
	/**
	 * Mouse Enter displays whether the piece can or cannot be placed onto the board.
	 */
	public void mouseEntered(MouseEvent e) {
		updateParameters();
		String hoverfn = null;
		if (bullpen.getSelectedPiece() != null) {
			if (currentlevel.canMoveBullpenToBoard(selfTile)) {
				hoverfn = "square2.png";
			} else {
				hoverfn = "rednightbutton.png";
			}
		} else if (board.getSelectedPiece() != null) {
			if (currentlevel.canMoveBoardToBoard(selfTile)) {
				hoverfn = "square3.png";
			} else {
				hoverfn = "rednightbutton.png";
			}
		} else if (hoverfn == null) {
			// no piece is selected
			return;
		}
		// set image to hover
		displayHoverPiece(hoverfn, false, false);
	}
	/**
	 * Mouse Exit returns the pieces affected back to the original image.
	 */
	public void mouseExited(MouseEvent e) {
		updateParameters();
		if (selectedPiece == null){
			// if selectedPiece doesn't exist
			return;
		}
		// set to original image filename
		displayHoverPiece("general1button.png", false, true);
	}
	/**
	 * Displays the selected piece hovered over the board.
	 * @param hpfn filename of image
	 * @param setNewFilename choice to set the new file name of the view object
	 * @param setOriginalImg choice to set the original file name of the view object
	 */
	public void displayHoverPiece(String hpfn, boolean setNewFilename, boolean setOriginalImg) {
		updateParameters();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] == selfTile) {
					int xoffset = (int) selectedPiece.findReferencePoint().getX();
					int yoffset = (int) selectedPiece.findReferencePoint().getY();
					for (int y = -yoffset; y < selectedPiece.getDim() - yoffset; y++) {
						for (int x = -xoffset; x < selectedPiece.getDim() - xoffset; x++) {
							try {
								if ((selectedPiece.getTile(y + yoffset, x + xoffset).isValid())
										&& tiles[i + y][j + x].isValid()) {
									if (setNewFilename) {
										tileimgs[(i + y) * tiles.length + (j + x)].setFileName(hpfn);
									}
									if (setOriginalImg) {
										String origfn = tileimgs[(i + y) * tiles.length + (j + x)].getFileName();
										tileimgs[(i + y) * tiles.length + (j + x)].setImg(origfn);
									} else {
										tileimgs[(i + y) * tiles.length + (j + x)].setImg(hpfn);
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
	/**
	 * Stamps the selected piece onto the board.
	 * @param p piece of interest.
	 */
	public void boardSelectPiece(Piece p) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j].getPiece() == p) {
					tileimgs[i * tiles.length + j].setImg("boardtile.png");
					tileimgs[i * tiles.length + j].setFileName("boardtile.png");

				}
			}
		}
	}

	/**
	 * Updates the display of stars ( 1-3 ).
	 */
	public void updateStarDisplay() {
		/* Check if the number of stars has been updated */
		int currNumStars = kabasuji.getSelectedLevel().getStars();
		System.out.print("Calculated Number of Stars: ");
		System.out.println(currNumStars);
		System.out.print("Stored Number of Stars: ");
		System.out.println(kabasuji.getSelectedLevel().getBoard().getNumStars());
		if (currNumStars != kabasuji.getSelectedLevel().getBoard().getNumStars()) {
			System.out.println("Entered star condition!");
			// update the stored number of stars
			kabasuji.getSelectedLevel().getBoard().setNumStars(currNumStars);

			panel.updateStars(); // draw the correct number of stars

			/*
			 * If this is the first star, change the next level button to be
			 * unlocked
			 */
			if (currNumStars == 1) {
				panel.updateNextLevel();
			}
		}
		panel.repaint();
	}
}
