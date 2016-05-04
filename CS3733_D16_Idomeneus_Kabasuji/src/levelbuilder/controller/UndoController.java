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
 * Controller for undoing the moves in the level. Clicking on the undo button will undo all the moves.
 * 
 * The gui will reflect the changes.
 * 
 *@author Ethan Prihar
 *
 */
public class UndoController extends MouseAdapter {

	/** The builder entity class */
	Builder builder;
	
	/** The top level application */
	TopLevelApplicationBuilder app;
	
	/** The JPanel for the boundary class */
	JPanel contentPanel;	
	
	/** The button for the undo */
	JLabelIcon button;
	
	/** String image file name */
	String fn;
	
	/** The array of pieces in the builder bullpen */
	JLabel[][] pieces;
	
	/** The builder board view */
	BuilderBoardView board;

	/**
	 * Constructor for the class
	 * @param builder The builder entity class
	 * @param app The top level application
	 * @param button The button for the undo
	 * @param piece1 The first row of pieces in the bullpen
	 * @param piece2 The second row of pieces in the bullpen
	 * @param piece3 The third row of pieces in the bullpen
	 * @param b The board
	 */
	public UndoController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, JLabel[] piece1, JLabel[] piece2, JLabel[] piece3, BuilderBoardView b) {
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
			builder.undo();
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
