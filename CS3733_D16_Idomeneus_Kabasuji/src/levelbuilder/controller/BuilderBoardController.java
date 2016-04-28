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
	int i;
	int j;
	boolean selected;
	int type;

	public BuilderBoardController(Board board, JLabelIcon tile, int i, int j, Builder builder, TopLevelApplicationBuilder app, int type) {
		this.board=  board;
		this.tile = tile;
		this.i = i;
		this.j = j;
		this.app = app;
		this.builder = builder;
		this.fn = tile.getFileName();
		this.type = type;
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
				tile.removeAll();
				tile.setImg("general1button.png");
				// Call the move class to make the currentTile in valid
				if (type != 1)
				{
					builder.getSelectedLevel().getBoard().getTiles()[i][j].setHint(false);
				}
				builder.getSelectedLevel().getBoard().getTiles()[i][j].setValid(false);
				builder.updateHistory();
				//BuilderSelectTileMove builderSelectTileMove = new BuilderSelectTileMove(currentTile);
				//builderSelectTileMove.execute(builder);
			}
		}
		
		// If the mousePressed event is a left click, then make the tile a hint tile
		else if (SwingUtilities.isRightMouseButton(me)){
			selected = true;
			if (selected){
				tile.setImg("tile.png");
				JLabelIcon hintImage = new JLabelIcon("hint.png", tile.getWidth(), tile.getHeight());
				
				// Call the move class to make the currentTile a hint tile
				System.out.println("Just called the tile controller");
				if (type != 1){
					builder.getSelectedLevel().getBoard().getTiles()[i][j].setHint(true);
					tile.add(hintImage);
				}
				builder.getSelectedLevel().getBoard().getTiles()[i][j].setValid(true);
				builder.updateHistory();
				//BuilderHintTileMove builderHintTileMove = new BuilderHintTileMove(currentTile);
				//builderHintTileMove.execute(builder);
			}
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (!selected){
			tile.setImg("generalhoverbutton.png");
		}
	}

	public void mouseExited(MouseEvent e) {
		if (!selected){
			tile.setImg(fn);
		}
	}
}
