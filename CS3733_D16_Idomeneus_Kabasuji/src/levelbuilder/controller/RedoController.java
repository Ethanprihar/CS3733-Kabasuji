package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.model.Builder;
import kabasuji.view.JLabelIcon;
import levelbuilder.view.BuilderBoardView;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for redoing a level. By clicking on the redo button, we can redo all the moves.
 * 
 * When the button is pressed to attempt to save the level and go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @ Author Ethan Prihar
 */
public class RedoController extends MouseAdapter {

	/** Builder entity class */
	Builder builder;
	
	/** Top level boundary class */
	TopLevelApplicationBuilder app;
	
	/** JPanel for the boundary class */
	JPanel contentPanel;
	
	/** JButton for the redo */
	JLabelIcon button;	
	
	/** String image file name */
	String fn;
	
	/** JLabel for the pieces */
	JLabel[][] pieces;
	
	/** The builder board view for the level */
	BuilderBoardView board;

	/**
	 * Constructor for this class
	 * @param builder The builder entity class
	 * @param app The top level application
	 * @param button The button for the redo
	 * @param piece1 The first row of bullpen pieces
	 * @param piece2 The second row of bullpen pieces
	 * @param piece3 The third row of bullpen pieces
	 * @param b The board view for the level
	 */
	public RedoController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, JLabel[] piece1, JLabel[] piece2, JLabel[] piece3, BuilderBoardView b) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.button = button;
		this.fn = button.getFileName();
		pieces = new JLabel[3][];
		pieces[0] = piece1;
		pieces[1] = piece2;
		pieces[2] = piece3;
		board = b;
	}

	/**
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		try
		{
			builder.redo();
			int counter = 0;
			for(int i=0; i<pieces.length; i++)
			{
				for(JLabel num: pieces[i])
				{
					num.setText(Integer.toString(builder.getNum(counter)));
					counter++;
				}
			}
			board.setTiles(builder.getSelectedLevel().getBoard().getTiles());
			board.updateBoard();
		}
		catch (Exception exc)
		{
			//exc.printStackTrace(); // If there was an error, print the info.
		}
	}
	
	/**
	 * Whenever mouse is hovered over the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	/**
	 * Whenever mouse is exited after hovering on the object, change the image.
	 * @param MouseEvent e
	 */
	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
