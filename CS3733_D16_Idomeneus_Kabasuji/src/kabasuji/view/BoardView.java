package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.BoardController;
import kabasuji.controller.GoToLevelSelectController;
import kabasuji.controller.GoToMainMenuController;
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
	Kabasuji kabasuji;
	// the associated board
	Board board;
	// the JPanel that contains it
	Container panel;

	Tile[][] tiles;

	int row;
	int col;
	
	JLabelIcon[] tile;

	int sqmatrixlength;
	int tilesidelength;
	int tilesidescaled;

	int offset;

	/**
	 * Create the Main Menu Panel.
	 */

	public BoardView(Kabasuji kabasuji) {
		this.kabasuji = kabasuji;
		this.board = kabasuji.getSelectedLevel().getBoard();
//		this.panel = panel;
		this.tiles = board.getTiles();

	}
	public void setupBoard(){
//		panel = getParent();
		row = board.getTiles().length;
		col = board.getTiles()[0].length;
		tile = new JLabelIcon[row * col];
		
		setLayout(null);

		// this is the largest length of the tile matrix
		// finds the smallest tile length
		if (row > col) {
			sqmatrixlength = row;
			this.tilesidelength = (int) (getSize().getWidth() / sqmatrixlength);
		} else {
			sqmatrixlength = col;
			this.tilesidelength = (int) (getSize().getHeight() / sqmatrixlength);
		}
		// scaling + offset to fit the container panel;
		tilesidescaled = (int) (tilesidelength * 0.95);
		offset = (int) (tilesidelength - tilesidescaled);
		
		updateBoard();
		
		JLabelIcon background = new JLabelIcon("opaque_canvas.png", (int) (Screen.height *0.54),
				(int) (Screen.height *0.54));
		add(background);
		repaint();
	}
	public void updateBoard(){
		// display the tiles on the container panel and scales them to fit
		// row/col
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				if (tiles[j][i].isValid()) {
					displayTile(i,j,"boardtile.png");
					tile[i*row+j].addMouseListener(new BoardController(board, tile[i*row+j]));
				}
			}
		}
	}
	public void displayTile(int i,int j, String pic){
		tile[i * row + j] = new JLabelIcon(pic, tilesidescaled, tilesidescaled);
		tile[i * row + j].setLocation((int) (tilesidelength * (j + (sqmatrixlength - row) / 2)) + offset,
				(int) (tilesidelength * (i + (sqmatrixlength - col) / 2)) + offset);
		JLabel numlbl = new JLabel(""+tiles[j][i].getNumber(), SwingConstants.CENTER);
		numlbl.setBounds(0, 0, tilesidescaled, tilesidescaled);
		numlbl.setFont(new Font("Arial", Font.BOLD, (int)(tilesidescaled*0.5)));
		tile[i*row+j].add(numlbl);
		add(tile[i * row + j]);
	}
	
}