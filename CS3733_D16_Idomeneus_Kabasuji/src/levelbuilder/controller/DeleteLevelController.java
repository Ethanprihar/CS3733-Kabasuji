package levelbuilder.controller;

import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.BuilderMainMenu;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for deleting a level; delete level then goes To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to save the level and go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author Vishal Rathi
 */
public class DeleteLevelController extends MouseAdapter {

	/** The builder entity class */
	Builder builder;

	/** The top level boundary class */
	TopLevelApplicationBuilder app;
	
	/** The JPanel for the boundary class */
	JPanel contentPanel;	
	
	/** The JButton to delete the level */ 
	JLabelIcon button;	
	
	/** String image file name */
	String fn;


	/**
	 * Constructor for this class
	 * @param builder The entity builder class
	 * @param app The top level boundary class
	 * @param button The button to delete the level
	 */
	public DeleteLevelController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.button = button;
		this.fn = button.getFileName();
	}

	/**
	 * Whenever mouse is pressed (left button or right button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		try
		{
			builder.levels.remove(builder.getSelectedLevel());
			builder.deleteLevel();
			builder.saveToDisc();
			
			// Show a dialog box to let the user know that the level was saved successfully
//			JOptionPane message = new JOptionPane("Level deleted Successfully!");
//			Dialog dialog = message.createDialog("Success");
//			dialog.setVisible(true);
			
			ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
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
