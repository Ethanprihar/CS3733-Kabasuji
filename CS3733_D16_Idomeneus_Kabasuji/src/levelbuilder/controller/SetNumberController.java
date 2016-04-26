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
public class SetNumberController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	Board board;
	JLabelIcon tile;
	String fn;
	boolean selected = false;
	boolean release = false;
	int number;
	JPanel releaseLevelPanel;

	public SetNumberController(Builder builder, TopLevelApplicationBuilder app, int number, BuilderReleaseBoardView releaseLevelPanel) {
		this.app = app;
		this.builder = builder;
		this.number = number;
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
			((BuilderReleaseBoardView) releaseLevelPanel).setNumber(number);
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
