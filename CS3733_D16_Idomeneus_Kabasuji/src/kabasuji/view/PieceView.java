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

public class PieceView extends JPanel {
	// the associated piece
	Piece piece;
	// the JPanel that contains it
	Container panel;

	Tile[][] tiles;

	JLabelIcon[] tileview;

	int row;
	int col;

	int piecesidelength;
	int piecesidescaled;
	int offset;

	/**
	 * Create the Piece View
	 */

	public PieceView(Piece piece, Container panel) {
		this.piece = piece;
		this.panel = panel;
		this.tiles = piece.getTiles();
		this.row = tiles.length;
		this.col = tiles[0].length;
		this.tileview = new JLabelIcon[row * col];

		// this is the largest length of the tile matrix
		// finds the smallest tile length
		if ((panel.getSize().getWidth() / row) < (panel.getSize().getHeight() / col)) {
			this.piecesidelength = (int) (panel.getSize().getWidth() / row);
		} else {
			this.piecesidelength = (int) (panel.getSize().getHeight() / col);
		}
		// scaling + offset to fit the container panel;
		this.piecesidescaled = (int) (piecesidelength * 0.8);
		this.offset = (int) ((piecesidelength - piecesidescaled) / 2);
		// sets the bounds of the pieceview within the panel container
		setBounds(0, 0, (int) panel.getSize().getWidth(), (int) panel.getSize().getHeight());
		updatePiece();

	}

	public void updatePiece() {
		// display the tiles on the container panel and scales them to fit
		// row/col
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				displayTiles(i, j, "general2button.png");
			}
		}
		repaint();
	}
	// if tile is valid, display tile and necessary components
	public void displayTiles(int i, int j, String pic) {
		if (tiles[i][j].isValid()) {
			tileview[i * row + j] = (new JLabelIcon(pic, piecesidescaled, piecesidescaled));
			tileview[i * row + j].setLocation((int) (piecesidelength * (j) + offset),
					(int) (piecesidelength * (i) + offset));
			panel.add(tileview[i * row + j]);

		}
	}

	// get container
	public Container getPanel() {
		return panel;
	}
}
