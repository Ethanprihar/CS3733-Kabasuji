package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
	int type;
	int[] numOfPiecesOnLoad;
	boolean valid = true;


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
	 */
	public void mousePressed(MouseEvent me) {
		// Created ChangeScreenBuilderMove and input desired screen
		if (type == 1){
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
			ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.Opening);
			// Attempt to execute action on model
			gtsm.execute(builder);
			// Created JPanel screen object and update boundary to reflect changes
			BuilderMainMenu lsp = new BuilderMainMenu(builder, app);
			app.setContentPanel(lsp);
		}
	}
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
