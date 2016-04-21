package kabasuji.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.model.Board;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author jwu
 *
 */
public class TileController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Board board;
	JLabelIcon tile;
	String fn;
	int[][] highlightLocations;
	int xLoc;
	int yLoc;
	Piece selectedPiece;
	Tile selfTile;
	Kabasuji kabasuji;

	public TileController(Board board, JLabelIcon tile, int highlightLocations[][], int y, int x, Tile selfTile, Kabasuji kabasuji) {
		this.board=  board;
		this.tile = tile;
		this.fn = tile.getFileName();
		this.highlightLocations = highlightLocations;
		xLoc = x;
		yLoc = y;
		this.selfTile = selfTile;
		this.kabasuji = kabasuji;
	}
	
	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {

	}
	public void mouseEntered(MouseEvent e) {
		selectedPiece = kabasuji.getSelectedLevel().getBullpen().getSelectedPiece();
		
		//Shows the shape of a piece.
//		for(int a = 0; a<6; a++)
//		{
//			for (int b = 0; b<6; b++)
//			{
//				System.out.print(selectedPiece.getTile(a, b).isValid());
//			}
//			System.out.println("");
//		}
		
		if(selectedPiece != null)
		{
			System.out.println("Have piece....");

			if(board.canAddPiece(selectedPiece, selfTile))
			{
				System.out.println("Can place.");

			}
			else
			{
				System.out.println("Cannot place.");

			}
		}
		else
		{
			tile.setImg("generalhoverbutton.png");	
		}
	}

	public void mouseExited(MouseEvent e) {
		tile.setImg(fn);
	}
}
