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
 * Controller for Board gameplay; Modify BoardView; This controller sets the number buttons 
 * in the release level. There are six buttons and you can select anyone to get a particular
 * number from 1 to 6.
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * 
 * @author ocd
 *
 */
public class SetNumberController extends MouseAdapter {

	/** Builder entity class */
	Builder builder;
	
	/** Top level application */
	TopLevelApplicationBuilder app;
	
	/** Board for the level */
	Board board;
	
	/** Number 1 button */
	JLabelIcon tile;
	
	/** Number 2 button */
	JLabelIcon tile1;
	
	/** Number 3 button */
	JLabelIcon tile2;
	
	/** Number 4 button */
	JLabelIcon tile3;
	
	/** Number 5 button */
	JLabelIcon tile4;
	
	/** Number 6 button */
	JLabelIcon tile5;
	
	/** Color button 1 tick */
	JLabelIcon tick1;
	
	/** Color button 2 tick */
	JLabelIcon tick2;
	
	/** Color button 3 tick */
	JLabelIcon tick3;
	
	/** String image file name */
	String fn;
	
	/** Boolean flag variable to see if the button is selected */
	boolean selected = false;
	
	/** Boolean flag variable */
	boolean release = false;
	
	/** The number for each button (1 to 6) */
	int number;
	
	/** Builder Release Level Panel */
	JPanel releaseLevelPanel;

	/**
	 * Constructor for this class
	 * @param builder The builder entity class
	 * @param app The top level application
	 * @param number The number to be added
	 * @param releaseLevelPanel The release level panel
	 * @param tile The number 1 button
	 * @param tile1 The number 2 button
	 * @param tile2 The number 3 button
	 * @param tile3 The number 4 button
	 * @param tile4 The number 5 button
	 * @param tile5 The number 6 button
	 * @param tick1 The color button 1 tick
	 * @param tick2 The color button 2 tick
	 * @param tick3 The color button 3 tick
	 */
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
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
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
			}
			else if (number == 2){
				tile.setImg("general0button.png");
				tile1.setImg("general3button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");	
			}
			else if (number == 3){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general3button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");
			}
			else if (number == 4){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general3button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general0button.png");
			}
			else if (number == 5){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general3button.png");
				tile5.setImg("general0button.png");
			}
			else if (number == 6){
				tile.setImg("general0button.png");
				tile1.setImg("general0button.png");
				tile2.setImg("general0button.png");
				tile3.setImg("general0button.png");
				tile4.setImg("general0button.png");
				tile5.setImg("general3button.png");
			}
			
			// Make the code intelligent to figure out the active color
			int getCol = ((BuilderReleaseBoardView) releaseLevelPanel).getColor();
			if (getCol == 1){
				tick1.setVisible(true);
			}
			else if (getCol == 2){
				tick2.setVisible(true);
			}
			else if (getCol == 3){
				tick3.setVisible(true);
			}
			((BuilderReleaseBoardView) releaseLevelPanel).setNumber(number);
			((BuilderReleaseBoardView) releaseLevelPanel).setEditMode(1);
			app.repaint();
		}
	}
	
	/**
	 * Whenever mouse is hovered over the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e) {
		if (!selected){
			//tile.setImg("generalhoverbutton.png");
		}
	}

	/**
	 * Whenever mouse is exited after hovering on the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {
		if (!selected){
			//tile.setImg(fn);
		}
	}
}
