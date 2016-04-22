package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.controller.moves.IncrementPieceBuilderMove;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Moving Screens; Go To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author vkr
 *
 */
public class IncrementPieceBuilderController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;	
	JLabel pieceCount;
	int numPiece;

	public IncrementPieceBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabel pieceCount, int numPiece) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.pieceCount = pieceCount;
		this.numPiece = numPiece;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		
		// If it is a left click, increment the count
		if (SwingUtilities.isLeftMouseButton(me)){
		
			// Get the current text of the JLabel
			String pieceNum = pieceCount.getText();
			
			// Convert the current text to integer
			int newPieceNum = Integer.parseInt(pieceNum);
			
			// Increment the count because of the mouse press event
			newPieceNum = newPieceNum + 1;
			
			// Convert the incremented integer back to string 
			String newStringNum = Integer.toString(newPieceNum);
			
			// Call the move class which gives information to the entity class about the incremented piece count		
			IncrementPieceBuilderMove incrementMove = new IncrementPieceBuilderMove(numPiece);
			// Execute the move
			incrementMove.execute(builder);
			
			// Set the new string in the JLabel
			pieceCount.setText(newStringNum);
		}
	}
}
