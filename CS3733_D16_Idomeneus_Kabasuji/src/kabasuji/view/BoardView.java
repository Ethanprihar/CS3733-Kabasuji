package kabasuji.view;

import javax.swing.JPanel;
import kabasuji.controller.TileController;
import kabasuji.model.Board;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import kabasuji.model.Tile;

import javax.swing.JLabel;

import java.awt.Color;
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

	/**
	 * BoardView Constructor
	 * 
	 * @param kabasuji
	 */
	public BoardView(Kabasuji kabasuji, PlayLevelPanel panel) {
		this.kabasuji = kabasuji;
		this.board = kabasuji.getSelectedLevel().getBoard();
		this.panel = panel;
		this.tiles = board.getTiles();
	}

	public void setupBoard() {
		// get dimesions of board tile array
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
		tilesidescaled = (int) (tilesidelength * .99);
		offset = (int) (tilesidelength - tilesidescaled);

		updateBoard();

		JLabelIcon background = new JLabelIcon("opaque_canvas.png", (int) (Screen.height * 0.54),
				(int) (Screen.height * 0.54));
		add(background);
		repaint();
	}

	public void updateBoard() {
		// display the tiles on the container panel and scales them to fit
		// row/column
		// includes centering as well
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				// create a button image with specified dimension
				// only display tile if it's valid
				if (tiles[i][j].isValid()) {
					String imgfn;
					if (tiles[i][j].isHint()) {
						imgfn = "hint.png";
					} else {
						imgfn = "boardtile.png";
					}
					displayTile(i, j, imgfn);
					tile[i * row + j]
							.addMouseListener(new TileController(kabasuji, panel, tile[i * row + j], tiles[i][j]));
				}
			}
		}
	}

	/**
	 * Displays Tiles on the board.
	 * 
	 * @param i
	 *            col
	 * @param j
	 *            row
	 * @param pic
	 *            name of filename of pic
	 */
	public void displayTile(int i, int j, String pic) {
		// Create JLabelIcon to corresponding Tile including label
		tile[i * row + j] = new JLabelIcon(pic, tilesidescaled, tilesidescaled);
		tile[i * row + j].setLocation((int) (tilesidelength * (j + (sqmatrixlength - row) / 2)) + offset,
				(int) (tilesidelength * (i + (sqmatrixlength - col) / 2)) + offset);
		// Only does labeling, trivial
		String stringnum = "";
		int tilenumlbl = tiles[i][j].getNumber();
		if(tilenumlbl != 0){
			stringnum = stringnum + tilenumlbl;
		}
		JLabel numlbl = new JLabel(stringnum, SwingConstants.CENTER);
		numlbl.setBounds(0, 0, tilesidescaled, tilesidescaled);
		numlbl.setFont(new Font("Arial", Font.BOLD, (int) (tilesidescaled * 0.5)));
		
		// Determine what color of text should be displayed then set the text color
		Color textcolor;
		switch(tiles[i][j].getColor())
		{
		case 1: textcolor = Color.RED;
		break;
		case 2: textcolor = Color.BLUE;
		break;
		case 3: textcolor = Color.YELLOW;
		break;
		default: textcolor = Color.darkGray;
		}
		numlbl.setForeground(textcolor);
		
		// Add label to image
		tile[i * row + j].add(numlbl);
		// Add Tile to Board
		add(tile[i * row + j]);
	}

	/**
	 * getter for JLabel[] tileimages.
	 * 
	 * @return
	 */
	public JLabelIcon[] getTileImages() {
		return tile;
	}

}