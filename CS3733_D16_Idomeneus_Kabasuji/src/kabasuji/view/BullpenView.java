package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.BoardController;
import kabasuji.controller.GoToLevelSelectController;
import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectPieceBullpenController;
import kabasuji.model.Board;
import kabasuji.model.Bullpen;
import kabasuji.model.Kabasuji;
import kabasuji.model.LightningLevel;
import kabasuji.model.Piece;
import kabasuji.model.Screen;
import kabasuji.model.Tile;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * BullpenView, all bullpen related activities are displayed here.
 * 
 * @author jwu
 *
 */
public class BullpenView extends JPanel {
	// Entities associated
	Kabasuji kabasuji;
	Bullpen bullpen;
	ArrayList<Piece> pieces;

	// Boundaries associated
	PlayLevelPanel panel;
	JLabelIcon[] imgpieces;
	PieceView[] pieceview;

	// array dimension of bullpen for piece fitting/organization
	int row;
	int col;

	// variables for location calculations
	int piecesidelength; // minimum size of piece to fill smallest dimension of
							// bullpen
	int piecesidescaled; // scaled size to allow slight segmentation
	int offset; // offset value due to scaling size
	int centeroffsetx;
	int centeroffsety;

	/**
	 * Construct BullpenView.
	 * 
	 * @param kabasuji
	 * @param panel
	 * @param row
	 *            preferred pieces per row
	 * @param col
	 *            preferred pieces per col
	 */
	public BullpenView(Kabasuji kabasuji, PlayLevelPanel panel, int row, int col) {
		this.kabasuji = kabasuji;
		this.panel = panel;
		this.row = row;
		this.col = col;

		setLayout(null);
		setOpaque(false);

	}

	/**
	 * Sets up the Bullpen.
	 */
	public void setupBullpen() {

		removeAll();

		this.bullpen = kabasuji.getSelectedLevel().getBullpen();
		this.pieces = bullpen.getPieces();

		// determine size of JLabelIcon[] and corresponding PieceView[]
		this.imgpieces = new JLabelIcon[pieces.size()];
		this.pieceview = new PieceView[pieces.size()];

		// this is the largest length of the tile matrix
		// finds the smallest tile length
		if ((getSize().getWidth() / row) < (getSize().getHeight() / col)) {
			this.piecesidelength = (int) (getSize().getWidth() / row);
		} else {
			this.piecesidelength = (int) (getSize().getHeight() / col);
		}

		// scaling + offset to fit the container panel;
		this.piecesidescaled = (int) (piecesidelength * 0.8);
		this.offset = (int) ((piecesidelength - piecesidescaled) / 2);
		this.centeroffsetx = (int) (getSize().getWidth() - (piecesidelength * row)) / 2;
		this.centeroffsety = (int) (getSize().getHeight() - (piecesidelength * col)) / 2;

		// draw/redraw bullpen pieces
		updateBullpen();

		// create background canvas
		JLabelIcon background = new JLabelIcon("opaque_canvas.png", (int) (Screen.width * 0.25),
				(int) (Screen.height * 0.85));
		background.setLocation(0, 0);
		add(background);
		// repaint everything
		repaint();
	}

	/**
	 * Redisplays the bullpen with current bullpen model data.
	 */
	public void updateBullpen() {
		// display the tiles on the container panel and scales them to fit
		// row/col
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				boolean randompieces = false;
				if(kabasuji.getSelectedLevel() instanceof LightningLevel){
					randompieces = true;
				}
				displayPiece(i, j, "opaquetile.png", randompieces);
			}
		}
	}

	/**
	 * Displays Piece on corresponding JLabel on Bullpen.
	 * 
	 * @param i
	 *            column
	 * @param j
	 *            row
	 * @param pic
	 *            name of desired picture
	 */
	public void displayPiece(int i, int j, String pic, boolean random) {
		// create JLabelIcon to contain piece
		try {
			Random r = new Random();
			int n = 0;
			if (random) {
				n = r.nextInt(pieces.size());
			} else {
				n = i * row + j;
			}
			imgpieces[i * row + j] = new JLabelIcon(pic, piecesidescaled, piecesidescaled);
			imgpieces[i * row + j].setLocation((int) (piecesidelength * (j) + offset + centeroffsetx),
					(int) (piecesidelength * (i) + offset + centeroffsety));
			// get piece and setup the tiles on piece
			Piece piece = pieces.get(n);
			pieceview[i * row + j] = new PieceView(piece);
			pieceview[i * row + j].setBounds(0, 0, piecesidescaled, piecesidescaled);
			pieceview[i * row + j].setupPiece();
			imgpieces[i * row + j].add(pieceview[i * row + j]);
			// add JLabelIcon to BullpenView container
			add(imgpieces[i * row + j]);
			// attach Controllers
			imgpieces[i * row + j].addMouseListener(
					new SelectPieceBullpenController(kabasuji, panel, imgpieces[i * row + j], n));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Out of bounds!!");
		}
	}

	/**
	 * getter for JLabel[] image containers of pieces.
	 * 
	 * @return
	 */
	public JLabelIcon[] getImgPieces() {
		return imgpieces;
	}

	/**
	 * getter for PieceView[] pieceview containers.
	 * 
	 * @return
	 */
	public PieceView[] getPieceView() {
		return pieceview;
	}

	/*
	 * Setter for row and column.
	 */
	public void setDimension(int r, int c) {
		this.row = r;
		this.col = c;
	}
}
