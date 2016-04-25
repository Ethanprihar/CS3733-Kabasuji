package levelbuilder.view;

import javax.swing.JPanel;

import levelbuilder.controller.BuilderBoardController;
import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;

import java.awt.Container;

public class BuilderBoardView extends JPanel {
	// the associated board
	Board board;
	Builder builder;
	TopLevelApplicationBuilder app;
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

	public BuilderBoardView(Board board, Container panel, Builder builder, TopLevelApplicationBuilder app) {
		this.board = board;
		this.panel = panel;
		this.builder = builder;
		this.app = app;
		this.tiles = board.getTiles();

		this.row = board.getTiles().length+2;
		this.col = board.getTiles()[0].length+2;
		this.tile = new JLabelIcon[row * col];

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
		tilesidescaled = (int) (tilesidelength * 0.99);
		offset = (int) ((tilesidelength - tilesidescaled) / 2);
		
		// sets the bounds of the boardview within the panel container
		setBounds(0, 0, (int) panel.getSize().getWidth(), (int) panel.getSize().getHeight());
		updateBoard();

	}
	
	// display the tiles on the container panel and scales them to fit
	// row/col
	// includes centering as well
	public void updateBoard(){

		for (int i = 0; i < col-2; i++) {
			for (int j = 0; j < row-2; j++) {
					if (tiles[i][j].isHint()) {
						displayTile(i,j,"general2button.png");
					}
					else if(!tiles[i][j].isValid())
					{
						displayTile(i,j,"general1button.png");
					}
					else //if(tiles[j][i].isValid())
					{
						displayTile(i,j,"tile.PNG");
					}
					tile[i*row+j].addMouseListener(new BuilderBoardController(board, tile[i*row+j], tiles[i][j], builder, app));


			}
		}
	}
	public void displayTile(int i,int j, String pic){
		tile[i * row + j] = new JLabelIcon(pic, tilesidescaled, tilesidescaled);
		tile[i * row + j].setLocation((int) (tilesidelength * (j+1 + (sqmatrixlength - row) / 2)) + offset,
				(int) (tilesidelength * (i+1 + (sqmatrixlength - col) / 2)) + offset);
		panel.add(tile[i * row + j]);
	}
	
	public void setTiles(Tile[][] t)
	{
		tiles = t;
	}
	
}