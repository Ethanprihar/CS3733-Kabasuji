package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.BuilderHintTileMove;
import levelbuilder.controller.moves.BuilderSelectTileMove;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author vkr
 *
 */
public class BuilderBoardController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	Board board;
	JLabelIcon tile;
	String fn;
	Tile currentTile;
	boolean selected;

	public BuilderBoardController(Board board, JLabelIcon tile, Tile currentTile, Builder builder, TopLevelApplicationBuilder app) {
		this.board=  board;
		this.tile = tile;
		this.currentTile = currentTile;
		this.app = app;
		this.builder = builder;
		this.fn = tile.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// If the mousePressed event is a left click, then make the tile invalid
		if (SwingUtilities.isLeftMouseButton(me)){
			selected = true;
			if (selected){
				tile.setImg("general1button.png");
				
				// Call the move class to make the currentTile valid
				BuilderSelectTileMove builderSelectTileMove = new BuilderSelectTileMove(currentTile);
				builderSelectTileMove.execute(builder);
			}
		}
		
		// If the mousePressed event is a left click, then make the tile a hint tile
		else if (SwingUtilities.isRightMouseButton(me)){
			selected = true;
			if (selected){
				tile.setImg("general2button.png");
				
				// Call the move class to make the currentTile a hint tile
				BuilderHintTileMove builderHintTileMove = new BuilderHintTileMove(currentTile);
				builderHintTileMove.execute(builder);
			}
			
		}
	}
	public void mouseEntered(MouseEvent e) {
		tile.setImg("general1button.png");
	}

	public void mouseExited(MouseEvent e) {
		if (!selected){
			tile.setImg(fn);
		}
	}
}
