package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import kabasuji.model.Builder;
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

	/** The builder entity class */
	Builder builder;
	
	/** The top level application */
	TopLevelApplicationBuilder app;
	
	/** The JPanel for the boundary class */
	JPanel contentPanel;
	
	/** The button for the saving the level */
	JLabelIcon button;	
	
	/** String image file name */
	String fn;
	
	/** The text field for the end condition i.e the number of moves or time */
	JTextField ec;
	
	/** The type of the level; 1 for Puzzle; 2 for lightning; 3 for release */
	int type;
	
	/** The array to get information about the number of pieces from before if the level
	 * is being edited.
	 */
	int[] numOfPiecesOnLoad;
	
	/** Boolean flag variable */
	boolean valid = true;

	/**
	 * Constructor for this class
	 * @param builder The builder entity class
	 * @param app The top level application
	 * @param button The button for saving
	 * @param ec The end condition i.e. the number of moves or time
	 * @param type The type of the level i.e. Puzzle, Lightning or Release
	 * @param numOfPiecesOnLoad The previous history about the pieces in a level
	 */
	public SaveLevelController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, JTextField ec, int type, int[]numOfPiecesOnLoad) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.button = button;
		this.fn = button.getFileName();
		this.ec = ec;
		this.type = type;
		this.numOfPiecesOnLoad = numOfPiecesOnLoad;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 * @param MouseEvent me
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		if ((type == 1) || (type == 3)){
			valid = true;
			if (ec.getText().length() == 0){
				ErrorDialogBox.infoBox("The number of moves can't be left empty", "Invalid Input");
				valid = false;
				
			}
			else {
				try {
					valid = true;
					int getMoves = Integer.parseInt(ec.getText());
					if (getMoves <= 0){
						ErrorDialogBox.infoBox("The number of moves can't be zero or less, you idiot :P", "Invalid Input");
						valid = false;
					}
				}catch(NumberFormatException e){
					ErrorDialogBox.infoBox("The number of moves should be an integer", "Invalid Input");
					valid = false;
				}
			}
		}
		else if (type == 2){
			valid = true;
			if (ec.getText().length() == 0){
				ErrorDialogBox.infoBox("The time field can't be left empty", "Invalid Input");
				valid = false;
			}
			else {
				try {
					valid = true;
					int getTime = Integer.parseInt(ec.getText());
					if (getTime < 0){
						ErrorDialogBox.infoBox("The time can't be zero or less, you idiot :P", "Invalid Input");
						valid = false;
					}
				}catch(NumberFormatException e){
					ErrorDialogBox.infoBox("The time (seconds) should be an integer", "Invalid Input");
					valid = false;
				}
			}
		}
		
		// Get the number of pieces chosen
		int[] pieces = builder.getPieces();
		int count = 0;
		for (int i = 0; i < pieces.length; i++){
			if (pieces[i] == 0){
				count = count + 1;
			}
		}
		
		// Error code for no pieces chosen
		if (count == pieces.length){
			ErrorDialogBox.infoBox("Please choose at least one piece", "Invalid Input");
			valid = false;
		}

		if (valid == true){
			builder.setEndCondition(Integer.parseInt(ec.getText()));
			builder.saveLevel(numOfPiecesOnLoad);
			builder.saveToDisc();
			
//			// Show a dialog box to let the user know that the level was saved successfully
//			JOptionPane message = new JOptionPane("Level Saved Successfully!");
//			Dialog dialog = message.createDialog("Success");
//			dialog.setVisible(true);
			
			ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
			// Attempt to execute action on model
			gtsm.execute(builder);
			// Created JPanel screen object and update boundary to reflect changes
			BuilderMainMenu lsp = new BuilderMainMenu(builder, app);
			app.setContentPanel(lsp);
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
