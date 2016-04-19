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
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PieceView extends JPanel {
	// the associated piece
	Piece piece;

	Tile[][] tiles;

	JLabelIcon[] tileview;
	
	Point centroid;

	int row;
	int col;

	int piecesidelength;
	int piecesidescaled;
	int offset;

	/**
	 * Create the Piece View
	 */

	public PieceView(Piece piece) {
		this.piece = piece;
		this.tiles = piece.getTiles();

		setLayout(null);

	}
	public void setupPiece(){
		
		setOpaque(false);
		this.row = tiles.length;
		this.col = tiles[0].length;
		this.tileview = new JLabelIcon[row * col];

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
		updatePiece();
		repaint();
	}
	
	public void updatePiece() {
		centroid = calculateCentroid();
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
	}
	// if tile is valid, display tile and necessary components
	public void displayTiles(int i, int j, String pic) {
		if (tiles[i][j].isValid()) {
			tileview[i * row + j] = (new JLabelIcon(pic, piecesidescaled, piecesidescaled));
			tileview[i * row + j].setLocation((int) (piecesidelength * j  + offset + getSize().getWidth()*0.5 - centroid.getX()),
					(int) (piecesidelength *i + offset + getSize().getHeight()*0.5 - centroid.getY()));
			add(tileview[i * row + j]);
		}
	}
	public Point calculateCentroid(){
		Point pnt = new Point();
		double x = 0;
		double y= 0;
		double xsum = 0;
		double ysum = 0;
		int count =0;
		for(int i = 0; i< col; i++){
			for(int j =0; j < row ; j++){
				if(tiles[i][j].isValid()){
					xsum += piecesidelength *(j+0.5) ;
					ysum += piecesidelength *(i+0.5);
					count ++;
				}
			}
		}
		x = xsum/count;
		y = ysum/count;
		pnt.setLocation(x, y);
		return pnt;
	}
	public Point getCentroid(){
		return centroid;
	}
}
