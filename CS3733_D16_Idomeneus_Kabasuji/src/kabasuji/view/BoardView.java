package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Board;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.model.Tile;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class BoardView extends JPanel {
	// the associated board
	Board board;
	// the JPanel that contains it
	Container panel;

	Tile[][] tiles;

	int row;
	int col;

	int sqmatrixlength;
	int tilesidelength;
	int tilesidescaled;

	int offset;

	/**
	 * Create the Main Menu Panel.
	 */

	public BoardView(Board board, Container panel) {
		this.board = board;
		this.panel = panel;
		this.tiles = board.getTiles();

		this.row = board.getTiles().length;
		this.col = board.getTiles()[0].length;

		// this is the largest length of the tile matrix
		// finds the smallest tile length
		if (row > col) {
			sqmatrixlength = row;
			this.tilesidelength = (int) (panel.getSize().getWidth() / sqmatrixlength);
		} else {
			sqmatrixlength = col;
			this.tilesidelength = (int) (panel.getSize().getHeight() / sqmatrixlength);
		}

		// scaling + offset to fit the container panel;
		tilesidescaled = (int) (tilesidelength * 0.8);
		offset = (int) ((tilesidelength - tilesidescaled) / 2);
		
		// sets the bounds of the boardview within the panel container
		setBounds(0, 0, (int) panel.getSize().getWidth(), (int) panel.getSize().getHeight());
		updateBoard();

	}
	public void updateBoard(){
		JLabelIcon[] tile = new JLabelIcon[row * col];

		// display the tiles on the container panel and scales them to fit
		// row/col
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				if (tiles[j][i].isValid()) {
					tile[i * row + j] = new JLabelIcon("generalbutton.png", tilesidescaled, tilesidescaled);
					tile[i * row + j].setLocation((int) (tilesidelength * (j + (sqmatrixlength - row) / 2)) + offset,
							(int) (tilesidelength * (i + (sqmatrixlength - col) / 2)) + offset);
					panel.add(tile[i * row + j]);
				}
			}
		}
		repaint();
	}

}