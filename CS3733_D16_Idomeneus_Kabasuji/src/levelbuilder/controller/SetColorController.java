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
	JLabelIcon num1;
	JLabelIcon num2;
	JLabelIcon num3;
	JLabelIcon num4;
	JLabelIcon num5;
	JLabelIcon num6;
	String fn;
	boolean selected = false;
	boolean release = false;
	int color;
	JPanel releaseLevelPanel;

	public SetColorController(Builder builder, TopLevelApplicationBuilder app, int color, BuilderReleaseBoardView releaseLevelPanel, JLabelIcon tile, JLabelIcon tile1, JLabelIcon tile2, JLabelIcon num1, JLabelIcon num2, JLabelIcon num3, JLabelIcon num4, JLabelIcon num5, JLabelIcon num6) {
		this.app = app;
		this.builder = builder;
		this.color = color;
		this.tile = tile;
		this.tile1 = tile1;
		this.tile2 = tile2;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
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
			if (color == 1){
				tile.setVisible(true);
				tile1.setVisible(false);
				tile2.setVisible(false);
			}
			else if (color == 2){
				tile.setVisible(false);
				tile1.setVisible(true);
				tile2.setVisible(false);
			}
			else if (color == 3){
				tile.setVisible(false);
				tile1.setVisible(false);
				tile2.setVisible(true);
			}
			
			// Make the code intelligent to figure out the active number
			int getNum = ((BuilderReleaseBoardView) releaseLevelPanel).getNumber();
			if (getNum == 1){
				num1.setImg("general3button.png");
			}
			else if (getNum == 2){
				num2.setImg("general3button.png");
			}
			else if (getNum == 3){
				num3.setImg("general3button.png");
			}
			else if (getNum == 4){
				num4.setImg("general3button.png");
			}
			else if (getNum == 5){
				num5.setImg("general3button.png");
			}
			else if (getNum == 6){
				num6.setImg("general3button.png");
			}
			((BuilderReleaseBoardView) releaseLevelPanel).setColor(color);
			((BuilderReleaseBoardView) releaseLevelPanel).setEditMode(1);
			app.repaint();
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
