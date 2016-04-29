package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.LightningBoard;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.ReleaseBoard;
import kabasuji.view.JLabelIcon;
import levelbuilder.view.BuilderReleaseBoardView;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Board gameplay; Modify BoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author ocd
 *
 */
public class SetColorController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	Board board;
	JLabelIcon tile;
	JLabelIcon tile1;
	JLabelIcon tile2;
	String fn;
	boolean selected = false;
	boolean release = false;
	int color;
	JPanel releaseLevelPanel;

	public SetColorController(Builder builder, TopLevelApplicationBuilder app, int color, BuilderReleaseBoardView releaseLevelPanel, JLabelIcon tile, JLabelIcon tile1, JLabelIcon tile2) {
		this.app = app;
		this.builder = builder;
		this.color = color;
		this.tile = tile;
		this.tile1 = tile1;
		this.tile2 = tile2;
		this.releaseLevelPanel = releaseLevelPanel;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		selected = true;
		int levelType;
		levelType = (builder.getSelectedLevel().getBoard() instanceof PuzzleBoard) ? 0 : 
						(builder.getSelectedLevel().getBoard() instanceof LightningBoard) ? 1 :
							(builder.getSelectedLevel().getBoard() instanceof ReleaseBoard) ? 2 : -1;
		
		if(levelType == 2)
		{
			JLabelIcon tickimage = new JLabelIcon("tick.png", 30, 30);
			if (color == 1){
				tile1.remove(tickimage);
				tile2.remove(tickimage);
				tile.setImg("genera1button.png");
				tile.add(tickimage);
			}
			else if (color == 2){
				tile.remove(tickimage);
				tile2.removeAll();
				tile1.setImg("general2button.png");
				tile.add(tickimage);
			}
			else if (color == 3){
				tile.remove(tickimage);
				tile1.remove(tickimage);
				tile2.setImg("general3button.png");
				tile.add(tickimage);
			}
			((BuilderReleaseBoardView) releaseLevelPanel).setColor(color);
			((BuilderReleaseBoardView) releaseLevelPanel).setEditMode(1);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (!selected){
			//tile.setImg("generalhoverbutton.png");
		}
	}

	public void mouseExited(MouseEvent e) {
		if (!selected){
			//tile.setImg(fn);
		}
	}
}
