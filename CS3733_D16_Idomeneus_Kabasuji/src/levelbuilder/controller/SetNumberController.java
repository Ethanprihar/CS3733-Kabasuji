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
	JLabelIcon tile1;
	JLabelIcon tile2;
	JLabelIcon tile3;
	JLabelIcon tile4;
	JLabelIcon tile5;
	JLabelIcon tick1;
	JLabelIcon tick2;
	JLabelIcon tick3;
	String fn;
	boolean selected = false;
	boolean release = false;
	int number;
	JPanel releaseLevelPanel;

	public SetNumberController(Builder builder, TopLevelApplicationBuilder app, int number, BuilderReleaseBoardView releaseLevelPanel, JLabelIcon tile, JLabelIcon tile1, JLabelIcon tile2, JLabelIcon tile3, JLabelIcon tile4, JLabelIcon tile5, JLabelIcon tick1, JLabelIcon tick2, JLabelIcon tick3) {
		this.app = app;
		this.builder = builder;
		this.number = number;
		this.tile = tile;
		this.tile1 = tile1;
		this.tile2 = tile2;
		this.tile3 = tile3;
		this.tile4 = tile4;
		this.tile5 = tile5;
		this.tick1 = tick1;
		this.tick2 = tick2;
		this.tick3 = tick3;
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
			if (number == 1){
				tile.setImg("general3button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");
				
				if ((!(tick1.isVisible())) && (!(tick2.isVisible())) && (!(tick3.isVisible()))){
					tick1.setVisible(true);
				}
			}
			else if (number == 2){
				tile.setImg("general0button.png");
				tile1.setImg("general3button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");
				
				if ((!(tick1.isVisible())) && (!(tick2.isVisible())) && (!(tick3.isVisible()))){
					tick1.setVisible(true);
				}
			}
			else if (number == 3){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general3button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");
				
				if ((!(tick1.isVisible())) && (!(tick2.isVisible())) && (!(tick3.isVisible()))){
					tick1.setVisible(true);
				}
			}
			else if (number == 4){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general3button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");
				
				if ((!(tick1.isVisible())) && (!(tick2.isVisible())) && (!(tick3.isVisible()))){
					tick1.setVisible(true);
				}
			}
			else if (number == 5){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general3button.png");
				tile5.setImg("general0button.png");
				
				if ((!(tick1.isVisible())) && (!(tick2.isVisible())) && (!(tick3.isVisible()))){
					tick1.setVisible(true);
				}
			}
			else if (number == 6){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general3button.png");
				
				if ((!(tick1.isVisible())) && (!(tick2.isVisible())) && (!(tick3.isVisible()))){
					tick1.setVisible(true);
				}
			}
			((BuilderReleaseBoardView) releaseLevelPanel).setNumber(number);
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
