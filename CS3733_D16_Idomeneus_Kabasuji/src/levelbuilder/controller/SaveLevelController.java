package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Piece;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.ErrorDialogBox;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for saving a level; saves level then goes To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to save the level and go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 *
 */
public class SaveLevelController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;	
	JLabelIcon button;	
	String fn;
	JTextField ec;


	public SaveLevelController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, JTextField ec) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.button = button;
		this.fn = button.getFileName();
		this.ec = ec;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		
		if (ec.getText().length() == 0){
			ErrorDialogBox.infoBox("The number of moves can't be left empty", "Invalid Input");
		}
		else {
			try {
				Integer.parseInt(ec.getText());
			}catch(NumberFormatException e){
				ErrorDialogBox.infoBox("The number of moves should be an integer", "Invalid Input");
			}
		}
		
		try
		{
			System.out.println("I am here 1");
			builder.setEndCondition(Integer.parseInt(ec.getText()));
			System.out.println("I am here 2");
			builder.saveLevel();
			builder.saveToDisc();
			ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
			// Attempt to execute action on model
			gtsm.execute(builder);
			// Created JPanel screen object and update boundary to reflect changes
			BuilderMainMenu lsp = new BuilderMainMenu(builder, app);
			app.setContentPanel(lsp);
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
