package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;
import levelbuilder.view.BuilderReleaseBoardView;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Release Board in the builder; Modify BuilderBoardView;
 * 
 * When a desired tile is pressed, an action is attempted to
 * progress game and update board
 * @author Vishal Rathi, Odell Dotson
 *
 */
public class BuilderReleaseBoardController extends MouseAdapter {

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
	
	/** The current tile */
	Tile currentTile;
	
	/** Boolean for the selected tile */
	boolean selected;
	
	/** Boolean flag variable */
	boolean release = false;
	
	/** Click mode for the colors and numbers */
	int clickMode;
	
	/** The number to add in the release level */
	int numToAdd;
	
	/** The color to add in the release level */
	int colorToAdd;
	
	/** Builder release board view */
	BuilderReleaseBoardView releaseLevelPanel;

	/** 
	 * Constructor for the class
	 * @param board The Board 
	 * @param tile The tile
	 * @param currentTile The current tile
	 * @param builder The builder entity class
	 * @param app The top level application boundary
	 * @param clickMode The click mode
	 * @param numToAdd	The number to add in the release level
	 * @param colorToAdd The color to add to the release tile
	 * @param releaseLevelPanel The Release board view
	 */
	public BuilderReleaseBoardController(Board board, JLabelIcon tile, Tile currentTile, Builder builder, 
			TopLevelApplicationBuilder app, int clickMode, int numToAdd, int colorToAdd, 
			BuilderReleaseBoardView releaseLevelPanel) {
		this.board=  board;
		this.tile = tile;
		this.currentTile = currentTile;
		this.app = app;
		this.builder = builder;
		this.fn = tile.getFileName();
		this.clickMode = clickMode;
		this.numToAdd = numToAdd;
		this.colorToAdd = colorToAdd;
		this.releaseLevelPanel = releaseLevelPanel;
	}

	/**
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		
		if(((BuilderReleaseBoardView) releaseLevelPanel).getEditMode() == 1)
		{
			int numberToPaint = ((BuilderReleaseBoardView) releaseLevelPanel).getNumber();
			int colorToPaint = ((BuilderReleaseBoardView) releaseLevelPanel).getColor();
			release = true;
			if (SwingUtilities.isLeftMouseButton(me)){
				selected = true;
				if (selected){
					tile.removeAll();
					if(!currentTile.isHint())
					{
						currentTile.setNumber(numberToPaint);
						currentTile.setColor(colorToPaint);
						currentTile.setValid(true);
						String tileToDisplay = "releasetile";
						if(colorToPaint == 1)
						{
							tileToDisplay = tileToDisplay + "1_";
						}
						else if(colorToPaint == 2)
						{
							tileToDisplay = tileToDisplay + "2_";
						}
						else if(colorToPaint == 3)
						{
							tileToDisplay = tileToDisplay + "3_";
						}
						
						tileToDisplay = tileToDisplay + Integer.toString(numberToPaint) + ".PNG";
						tile.setImg(tileToDisplay);
						builder.updateHistory();
						//releaseLevelPanel.updateBoard();
					}
					else
					{
						currentTile.setNumber(numberToPaint);
						currentTile.setColor(colorToPaint);
						currentTile.setValid(true);
						currentTile.setHint(true);
						String tileToDisplay = "releasetile";
						if(colorToPaint == 1)
						{
							tileToDisplay = tileToDisplay + "1_";
						}
						else if(colorToPaint == 2)
						{
							tileToDisplay = tileToDisplay + "2_";
						}
						else if(colorToPaint == 3)
						{
							tileToDisplay = tileToDisplay + "3_";
						}
						
						tileToDisplay = tileToDisplay + Integer.toString(numberToPaint) + "_h.PNG";
						tile.setImg(tileToDisplay);
						builder.updateHistory();
						//releaseLevelPanel.updateBoard();
					}

				}
			}
		}
		// If the mousePressed event is a left click, then make the tile invalid
		else
		{
			System.out.println("Not in the replease painter mode, normal board update running now.");
			if (SwingUtilities.isLeftMouseButton(me)){
				//builder.updateHistory();
				//releaseLevelPanel.updateBoard();
				selected = true;
				if (selected){
					tile.removeAll();
					tile.setImg("general1button.png");
					System.out.println("Making a release board have an invalid tile.");
					currentTile.setValid(false);
					currentTile.setHint(false);
					currentTile.setNumber(0);
					currentTile.setColor(0);
					builder.updateHistory();
					//releaseLevelPanel.updateBoard();
					//BuilderSelectTileMove builderSelectTileMove = new BuilderSelectTileMove(currentTile);
					//builderSelectTileMove.execute(builder);
				}
			}
			
			// If the mousePressed event is a left click, then make the tile a hint tile
			else if (SwingUtilities.isRightMouseButton(me)){
				int numberToPaint = currentTile.getNumber();
				int colorToPaint = currentTile.getColor();
				selected = true;
				if (selected){
					if((currentTile.getNumber() == 0))
					{
						tile.setImg("tile.png");
						JLabelIcon hintImage = new JLabelIcon("hint.png", tile.getWidth(), tile.getHeight());
						tile.add(hintImage);
						currentTile.setHint(true);
						currentTile.setValid(true);
						currentTile.setNumber(0);
						currentTile.setColor(0);
						builder.updateHistory();
						///releaseLevelPanel.updateBoard();
					}
					else//If it is a hint tile.
					{
						currentTile.setNumber(numberToPaint);
						currentTile.setColor(colorToPaint);
						currentTile.setValid(true);
						currentTile.setHint(true);
						String tileToDisplay = "releasetile";
						if(colorToPaint == 1)
						{
							tileToDisplay = tileToDisplay + "1_";
						}
						else if(colorToPaint == 2)
						{
							tileToDisplay = tileToDisplay + "2_";
						}
						else if(colorToPaint == 3)
						{
							tileToDisplay = tileToDisplay + "3_";
						}
						
						tileToDisplay = tileToDisplay + Integer.toString(numberToPaint) + "_h.PNG";
						//System.out.println("FIle name:" + tileToDisplay);
						tile.setImg(tileToDisplay);
						builder.updateHistory();
						//releaseLevelPanel.updateBoard();
					}
				}
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
