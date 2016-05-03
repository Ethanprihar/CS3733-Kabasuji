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
 * Controller for the bullpen in the builder. All the piece in the bullpen in the builder can be clicked.
 * The JLabel will increment by 1 on each click on the individual piece.
 * 
 * When the piece is pressed, increment the corresponding JLabel count
 * 
 * @author Vishal Rathi
 *
 */

public class IncrementPieceBuilderController extends MouseAdapter {

	/** The builder entity class */
	Builder builder;
	
	/** The top level boundary class */
	TopLevelApplicationBuilder app;
	
	/** The JPanel for the boundary class */
	JPanel contentPanel;
	
	/** Variable to keep track of the piece count*/
	JLabel pieceCount;
	
	/** The number of the piece (1 to 35) clicked */
	int numPiece;

	/**
	 * Constructor
	 * @param builder The builder entity class
	 * @param app The top level application boundary class
	 * @param pieceCount The piece count for each piece
	 * @param numPiece The reference for the particular piece
	 */
	public IncrementPieceBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabel pieceCount,
			int numPiece) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();
		this.pieceCount = pieceCount;
		this.numPiece = numPiece;
	}

	/**
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		//
		// // If it is a left click, increment the count
		// if (SwingUtilities.isLeftMouseButton(me)){

		// Get the current text of the JLabel
		String pieceNum = pieceCount.getText();

		// Convert the current text to integer
		int newPieceNum = Integer.parseInt(pieceNum);

		// Increment the count because of the mouse press event
		newPieceNum = newPieceNum + 1;

		// Convert the incremented integer back to string
		String newStringNum = Integer.toString(newPieceNum);

		// Call the move class which gives information to the entity class about
		// the incremented piece count
		IncrementPieceBuilderMove incrementMove = new IncrementPieceBuilderMove(numPiece);
		// Execute the move
		incrementMove.execute(builder);

		// Set the new string in the JLabel
		pieceCount.setText(newStringNum);
		builder.updateHistory();
		// }
	}
}
