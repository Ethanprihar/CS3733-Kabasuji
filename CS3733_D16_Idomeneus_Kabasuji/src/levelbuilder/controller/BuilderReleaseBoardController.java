package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.LightningBoard;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.ReleaseBoard;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;
import levelbuilder.view.BuilderReleaseBoardView;
import levelbuilder.view.BuilderReleaseLevelPanel;
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
public class BuilderReleaseBoardController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	Board board;
	JLabelIcon tile;
	String fn;
	Tile currentTile;
	boolean selected;
	boolean release = false;
	int clickMode;
	int numToAdd;
	int colorToAdd;
	BuilderReleaseBoardView releaseLevelPanel;

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
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		
		if(((BuilderReleaseBoardView) releaseLevelPanel).getEditMode() == 1)
		{
			int numberToPaint = ((BuilderReleaseBoardView) releaseLevelPanel).getNumber();
			int colorToPaint = ((BuilderReleaseBoardView) releaseLevelPanel).getColor();
			release = true;
			if (SwingUtilities.isLeftMouseButton(me)){
				builder.updateHistory();
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
					}

				}
			}
//			else if (SwingUtilities.isRightMouseButton(me)){
//				builder.updateHistory();
//				selected = true;
//				if (selected){
//					tile.setImg("tile.png");
//					JLabelIcon hintImage = new JLabelIcon("hint.png", tile.getWidth(), tile.getHeight());
//					tile.add(hintImage);
//					
//					currentTile.setHint(true);
//					currentTile.setValid(true);
//				}
//			}
		}
		// If the mousePressed event is a left click, then make the tile invalid
		else
		{
			if (SwingUtilities.isLeftMouseButton(me)){
				builder.updateHistory();
				selected = true;
				if (selected){
					tile.removeAll();
					tile.setImg("general1button.png");
					currentTile.setValid(false);
					currentTile.setHint(false);
					currentTile.setNumber(0);
					currentTile.setColor(0);
					//BuilderSelectTileMove builderSelectTileMove = new BuilderSelectTileMove(currentTile);
					//builderSelectTileMove.execute(builder);
				}
			}
			
			// If the mousePressed event is a left click, then make the tile a hint tile
			else if (SwingUtilities.isRightMouseButton(me)){
				int numberToPaint = currentTile.getNumber();
				int colorToPaint = currentTile.getColor();
				builder.updateHistory();
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
					}
				}
			}
		}
		builder.updateHistory();
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
