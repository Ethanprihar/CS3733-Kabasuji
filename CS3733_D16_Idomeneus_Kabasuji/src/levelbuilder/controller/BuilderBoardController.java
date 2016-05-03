package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;
//import levelbuilder.controller.moves.BuilderHintTileMove;
//import levelbuilder.controller.moves.BuilderSelectTileMove;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Board in the builder; Modify BuilderBoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * @author Vishal Rathi
 *
 */
public class BuilderBoardController extends MouseAdapter {

	/** Builder entity class */
	Builder builder;
	
	/** Top level boundary class for builder */
	TopLevelApplicationBuilder app;
	
	/** Board entity class */
	Board board;
	
	/** JLabel for the tile */
	JLabelIcon tile;
	
	/** String image file name */
	String fn;
	
	/** i dimension for the tile */
	int i;
	
	/** j dimension for the tile */
	int j;
	
	/** Boolean for the selected tile */
	boolean selected;
	
	/** Type for the level; 0 for puzzle and 1 for lightning */
	int type;

	/**
	 * Constructor for the BuilderBoardController
	 * @param board The board
	 * @param tile The specific tile
	 * @param i The i dimension
	 * @param j The j dimension
	 * @param builder The builder entity class
	 * @param app The TopLevelApplication boundary class
	 * @param type The type of the level
	 */
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
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
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
	
	/**
	 * Whenever mouse is hovered over the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e) {
		if (!selected){
			tile.setImg("generalhoverbutton.png");
		}
	}

	/**
	 * Whenever mouse is exited after hovering on the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {
		if (!selected){
			tile.setImg(fn);
		}
	}
}
