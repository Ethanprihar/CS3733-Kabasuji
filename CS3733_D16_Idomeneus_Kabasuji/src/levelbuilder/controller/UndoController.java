package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderBoardView;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for saving a level; saves level then goes To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to save the level and go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 *
 */
public class UndoController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;	
	JLabelIcon button;	
	String fn;
	JLabel[][] pieces;
	BuilderBoardView board;


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
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
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
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
