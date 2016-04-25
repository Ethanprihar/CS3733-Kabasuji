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
			release = true;
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
					
					// Call the move class to make the currentTile in valid
					currentTile.setValid(false);
					currentTile.setHint(false);
					//BuilderSelectTileMove builderSelectTileMove = new BuilderSelectTileMove(currentTile);
					//builderSelectTileMove.execute(builder);
	//				int valid = 0;s
	//				int invalid = 0;
	//				int hint = 0;
	//				int nothint = 0;
	//				for(int i=0; i<builder.getSelectedLevel().getBoard().getTiles().length; i++)
	//				{
	//					for(int j=0; j<builder.getSelectedLevel().getBoard().getTiles().length; j++)
	//					{
	//						if(builder.getSelectedLevel().getBoard().getTile(i,j).isValid())
	//							valid++;
	//						else
	//							invalid++;
	//						if(builder.getSelectedLevel().getBoard().getTile(i,j).isHint())
	//							hint++;
	//						else
	//							nothint++;
	//					}
	//				}
	//				System.out.println("hints: " + hint + "    not hints: " + nothint + "    valid: " + valid + "    invalid: " + invalid);
				}
			}
			
			// If the mousePressed event is a left click, then make the tile a hint tile
			else if (SwingUtilities.isRightMouseButton(me)){
				builder.updateHistory();
				selected = true;
				if (selected){
					tile.setImg("tile.png");
					JLabelIcon hintImage = new JLabelIcon("hint.png", tile.getWidth(), tile.getHeight());
					tile.add(hintImage);
					
					// Call the move class to make the currentTile a hint tile
					System.out.println("Just called the tile controller");
					currentTile.setHint(true);
					currentTile.setValid(true);
					
					//BuilderHintTileMove builderHintTileMove = new BuilderHintTileMove(currentTile);
					//builderHintTileMove.execute(builder);
				}
			}
		}
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
