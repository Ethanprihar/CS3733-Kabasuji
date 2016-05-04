package levelbuilder.view;

import javax.swing.JPanel;

import levelbuilder.controller.BuilderBoardController;
import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;

import java.awt.Container;

@SuppressWarnings("serial")
public class BuilderBoardView extends JPanel {
	/**board to select*/
	Board board;
	/**builder to get view data from*/
	Builder builder;
	/**application to get data from*/
	TopLevelApplicationBuilder app;
	/**the JPanel that contains it*/
	Container panel;
	/**the type of the view.*/
	int type;

	/**tiles of the board*/
	Tile[][] tiles;

	/**row dimension*/
	int row;
	/**column dimension*/
	int col;

	/**tile labels*/
	JLabelIcon[] tile;

	/**square matrix length*/
	int sqmatrixlength;
	/**tile side length*/
	int tilesidelength;
	/***tile side scaled*/
	int tilesidescaled;

	/**the scaling offset*/
	int offset;

	/**
	 * Builds a board view.
	 * @param board Board to build viewer from
	 * @param panel the panel to display to
	 * @param builder The buidder for data
	 * @param app the top level applicaiton
	 * @param type the type of the level.
	 */
	public BuilderBoardView(Board board, Container panel, Builder builder, TopLevelApplicationBuilder app, int type) {
		this.board = board;
		this.panel = panel;
		this.builder = builder;
		this.app = app;
		this.tiles = board.getTiles();
		this.type = type;

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
	

	/**
	 * 	display the tiles on the container panel and scales them to fit
	 * in row/col
	 * includes centering as well
	 */
	public void updateBoard(){
		
		board = builder.getSelectedLevel().getBoard();
		tiles = board.getTiles();
		
		panel.removeAll();
		for (int i = 0; i < col-2; i++) {
			for (int j = 0; j < row-2; j++) {
					if (tiles[i][j].isHint()) {
						displayTile(i,j,"tile.png");
						JLabelIcon hint = new JLabelIcon("hint.png", tile[i * row + j].getWidth(), tile[i * row + j].getWidth());
						tile[i * row + j].add(hint);
					}
					else if(!tiles[i][j].isValid())
					{
						displayTile(i,j,"general1button.png");
					}
					else //if(tiles[j][i].isValid())
					{
						displayTile(i,j,"tile.PNG");
					}
					tile[i*row+j].addMouseListener(new BuilderBoardController(board, tile[i*row+j], i,j, builder, app, type));


			}
		}
		panel.repaint();
	}
	
	/**
	 * Displays a tile.
	 * @param i i location of tile
	 * @param j j location of tile
	 * @param pic The icon to be displayed. (file name.)
	 */
	public void displayTile(int i,int j, String pic){
		tile[i * row + j] = new JLabelIcon(pic, tilesidescaled, tilesidescaled);
		tile[i * row + j].setLocation((int) (tilesidelength * (j+1 + (sqmatrixlength - row) / 2)) + offset,
				(int) (tilesidelength * (i+1 + (sqmatrixlength - col) / 2)) + offset);
		tile[i * row + j].setImg(pic);
		panel.add(tile[i * row + j]);
	}
	
	/**
	 * Sets the tiles in the viewer.
	 * @param t Tiles to set.
	 */
	public void setTiles(Tile[][] t)
	{
		tiles = t;
	}
	
}