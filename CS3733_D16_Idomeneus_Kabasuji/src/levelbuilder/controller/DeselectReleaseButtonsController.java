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
 * Controller for deselecting the release color and number buttons.
 * 
 * When the button is pressed to deselect, all the active number and color buttons are deselected and
 * GUI reflects the changes.
 * 
 * @author Vishal Rathi
 */
public class DeselectReleaseButtonsController extends MouseAdapter {

	/** The builder entity class */
	Builder builder;
	
	/** The top level application boundary class */
	TopLevelApplicationBuilder app;
	
	/** The board */
	Board board;
	
	/** The JLabel for the tile */
	JLabelIcon tile;
	
	/** String image file name */
	String fn;
	
	/** Boolean flag */
	boolean selected = false;
	
	/** Boolean flag */
	boolean release = false;
	
	/** Color specification */
	int color;
	
	/** The JPanel for the boundary class */
	JPanel releaseLevelPanel;
	
	/** Button 1 */
	JLabelIcon tile1;
	
	/** Button 2 */
	JLabelIcon tile2;
	
	/** Button 3 */
	JLabelIcon tile3;
	
	/** Button 4 */
	JLabelIcon tile4;
	
	/** Button 5 */
	JLabelIcon tile5;
	
	/** Button 6 */
	JLabelIcon tile6;
	
	/** Button 7 */
	JLabelIcon tile7;
	
	/** Button 8 */
	JLabelIcon tile8;

	/**
	 * Constructor for this class
	 * @param builder The builder entity class
	 * @param app The top level application boundary class
	 * @param color The color specified by button click
	 * @param releaseLevelPanel The JPanel for the boundary class
	 * @param tile Button 1
	 * @param tile1 Button 2
	 * @param tile2 Button 3
	 * @param tile3 Button 4
	 * @param tile4 Button 5
	 * @param tile5 Button 6
	 * @param tile6 Button 7
	 * @param tile7 Button 8
	 * @param tile8 Button 9
	 */
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
