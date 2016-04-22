package kabasuji.view;

import javax.swing.JPanel;
import kabasuji.controller.TileController;
import kabasuji.model.Board;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.model.Tile;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BoardView extends JPanel {
	
	/** Entities associated **/
	Kabasuji kabasuji;
	Board board;
	Tile[][] tiles;
	
	/** Boundaries associated **/
	PlayLevelPanel panel;
	JLabelIcon[] tile;

	// desired dimensions to fit
	int row;
	int col;

	// location manipulation variables for gui display
	int sqmatrixlength;
	int tilesidelength;
	int tilesidescaled;
	int offset;
	
	int[][] highlightLocations;

	/**
	 * BoardView Constructor
	 * @param kabasuji
	 */
	public BoardView(Kabasuji kabasuji, PlayLevelPanel panel) {
		this.kabasuji = kabasuji;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.panel = panel;
		this.tiles = board.getTiles();
	}
	public void setupBoard(){
		// get dimesions of board tile array
		row = board.getTiles().length;
		col = board.getTiles()[0].length;
		tile = new JLabelIcon[row * col];
		highlightLocations = new int[col][row];
		
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
		tilesidescaled = (int) (tilesidelength * 0.98);
		offset = (int) (tilesidelength - tilesidescaled);
		
		updateBoard();
		
		JLabelIcon background = new JLabelIcon("opaque_canvas.png", (int) (Screen.height *0.54),
				(int) (Screen.height *0.54));
		add(background);
		repaint();
	}
	public void updateBoard(){
		// display the tiles on the container panel and scales them to fit row/column
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				if (tiles[j][i].isValid()) {
					displayTile(i,j,"boardtile.png");
					tile[i*row+j].addMouseListener(
							new TileController(kabasuji, panel, tile[i*row+j], 
									highlightLocations, j, i, 
									tiles[j][i]
									));
				}
			}
		}
	}
	/**
	 * Displays Tiles on the board.
	 * @param i col
	 * @param j row
	 * @param pic name of filename of pic
	 */
	public void displayTile(int i,int j, String pic){
		// Create JLabelIcon to corresponding Tile including label
		tile[i * row + j] = new JLabelIcon(pic, tilesidescaled, tilesidescaled);
		tile[i * row + j].setLocation((int) (tilesidelength * (j + (sqmatrixlength - row) / 2)) + offset,
				(int) (tilesidelength * (i + (sqmatrixlength - col) / 2)) + offset);
		// Only does labeling, trivial
		JLabel numlbl = new JLabel(""+tiles[j][i].getNumber(), SwingConstants.CENTER);
		numlbl.setBounds(0, 0, tilesidescaled, tilesidescaled);
		numlbl.setFont(new Font("Arial", Font.BOLD, (int)(tilesidescaled*0.5)));
		tile[i*row+j].add(numlbl);
		// Add Tile to Board
		add(tile[i * row + j]);
	}
	/**
	 * getter for JLabel[] tileimages.
	 * @return
	 */
	public JLabelIcon[] getTileImages(){
		return tile;
	}
	
}