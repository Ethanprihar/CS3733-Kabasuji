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
public class DeselectReleaseButtonsController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	Board board;
	JLabelIcon tile;
	String fn;
	boolean selected = false;
	boolean release = false;
	int color;
	JPanel releaseLevelPanel;
	JLabelIcon tile1;
	JLabelIcon tile2;
	JLabelIcon tile3;
	JLabelIcon tile4;
	JLabelIcon tile5;
	JLabelIcon tile6;
	JLabelIcon tile7;
	JLabelIcon tile8;

	public DeselectReleaseButtonsController(Builder builder, TopLevelApplicationBuilder app, int color, BuilderReleaseBoardView releaseLevelPanel, JLabelIcon tile, JLabelIcon tile1, JLabelIcon tile2, JLabelIcon tile3, JLabelIcon tile4, JLabelIcon tile5, JLabelIcon tile6, JLabelIcon tile7, JLabelIcon tile8) {
		this.app = app;
		this.builder = builder;
		this.color = color;
		this.releaseLevelPanel = releaseLevelPanel;
		this.tile = tile;
		this.tile1 = tile1;
		this.tile2 = tile2;
		this.tile3 = tile3;
		this.tile4 = tile4;
		this.tile5 = tile5;
		this.tile6 = tile6;
		this.tile7 = tile7;
		this.tile8 = tile8;
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
			tile.setVisible(false);
			tile1.setVisible(false);
			tile2.setVisible(false);
			tile3.setImg("general0button.png");
			tile4.setImg("general0button.png");
			tile5.setImg("general0button.png");
			tile6.setImg("general0button.png");
			tile7.setImg("general0button.png");
			tile8.setImg("general0button.png");
			((BuilderReleaseBoardView) releaseLevelPanel).setEditMode(0);
			System.out.println("Deselected");
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
