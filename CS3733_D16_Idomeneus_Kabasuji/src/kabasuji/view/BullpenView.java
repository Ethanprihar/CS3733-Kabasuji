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

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class BullpenView extends JPanel {
	// the associated board
	Bullpen bullpen;

	PlayLevelPanel panel;
	ArrayList<Piece> pieces;

	JLabelIcon[] imgpieces;

	PieceView[] pieceview;

	int row;
	int col;

	int piecesidelength;
	int piecesidescaled;
	int offset;

	/**
	 * Create the Main Menu Panel.
	 */

	public BullpenView(Bullpen bullpen, PlayLevelPanel panel, int row, int col) {
		this.bullpen = bullpen;
		this.panel = panel;
		this.pieces = bullpen.getPieces();

		this.row = row;
		this.col = col;


	}
	public void setupBullpen(){
		
		this.imgpieces = new JLabelIcon[pieces.size()];
		this.pieceview = new PieceView[pieces.size()];

		setLayout(null);
		// this is the largest length of the tile matrix
		// finds the smallest tile length
		if ((getSize().getWidth() / row) < (getSize().getHeight() / col)) {
			this.piecesidelength = (int) (getSize().getWidth() / row);
		} else {
			this.piecesidelength = (int) (getSize().getHeight() / col);
		}

		// scaling + offset to fit the container panel;
		this.piecesidescaled = (int) (piecesidelength * 0.8);
		offset = (int) ((piecesidelength - piecesidescaled) / 2);
		
		updateBullpen();
		
		JLabelIcon background = new JLabelIcon("opaque_canvas.png", (int) (Screen.width * 0.25), (int) (Screen.height * 0.85));
		background.setLocation(0,0);
		add(background);
	}

	public void updateBullpen() {
		// display the tiles on the container panel and scales them to fit
		// row/col
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				displayPiece(i, j, "opaquetile.png");
			}
		}
	}

	public void displayPiece(int i, int j, String pic) {
		imgpieces[i * row + j] = new JLabelIcon(pic, piecesidescaled, piecesidescaled);
		imgpieces[i * row + j].setLocation((int) (piecesidelength * (j) + offset),
				(int) (piecesidelength * (i) + offset));
		Piece piece = pieces.get(i * row + j);
		pieceview[i * row + j] = new PieceView(piece);
		pieceview[i * row + j].setBounds(0, 0, piecesidescaled, piecesidescaled);
		pieceview[i * row + j].setupPiece();
		imgpieces[i*row+j].add(pieceview[i * row + j]);
		add(imgpieces[i * row + j]);
		imgpieces[i * row + j].addMouseListener(new SelectPieceBullpenController(bullpen, panel, imgpieces[i * row + j], i * row + j));
	}

	public JLabelIcon[] getImgPieces() {
		return imgpieces;
	}
	public PieceView[] getPieceView(){
		return pieceview;
	}
}
