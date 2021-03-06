package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.ReleaseBoard;
import kabasuji.model.Screen;
import kabasuji.model.Tile;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.DeselectReleaseButtonsController;
import levelbuilder.controller.GoToMainMenuBuilderController;
import levelbuilder.controller.IncrementPieceBuilderController;
import levelbuilder.controller.RandomizeReleaseController;
import levelbuilder.controller.RedoController;
import levelbuilder.controller.SaveLevelController;
import levelbuilder.controller.SetColorController;
import levelbuilder.controller.SetNumberController;
import levelbuilder.controller.TestLevelBuilderController;
import levelbuilder.controller.UndoController;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
/**
 * this class is the boundary class that is displayed while the user builds a release level
 * @author V & J
 *
 */
public class BuilderReleaseLevelPanel extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;	
	JTextField boardDimensions;
	int[] numOfPiecesOnLoad = new int[35];
	
	/** Main menu button.*/
	JLabelIcon mainmenubtn;
	/** Save button.*/
	JLabelIcon saveBtn;
	/** Delete level button.*/
	JLabelIcon deleteBtn;
	/** Undo button.*/
	JLabelIcon undoBtn;
	/** Redo button.*/
	JLabelIcon redoBtn;
	/** Test button.*/
	JLabelIcon testBtn;
	/** Color 1 button.*/
	JLabelIcon colorBtn1;
	/** Color 2 button.*/
	JLabelIcon colorBtn2;
	/** Color 3 button.*/
	JLabelIcon colorBtn3;
	/** Clearing color and number button.*/
	JLabelIcon colorClearBtn;
	/** Randomize release level button button.*/
	JLabelIcon randomizeReleaseBtn;
	/** Number 1 button.*/
	JLabelIcon numBtn1;
	/** Number 2 button.*/
	JLabelIcon numBtn2;
	/** Number 3 button.*/
	JLabelIcon numBtn3;
	/** Number 4 button.*/
	JLabelIcon numBtn4;
	/** Number 5 button.*/
	JLabelIcon numBtn5;
	/** Number 6 button.*/
	JLabelIcon numBtn6;
	/** Bullpen piece labels. button.*/
	JLabel[] piece1Lbl;
	/** Piece addition button.*/
	JLabelIcon[] piece;
	/** Number of moves text field.*/
	JTextField numMoves;
	
	BuilderReleaseBoardView boardview;

	/**
	 * creates the release level panel
	 * @param builder the entity class that stores the state data
	 * @param app the top level boundary class this panel is displayed in
	 * @param boardDimensions the height and width of the board
	 */
	public BuilderReleaseLevelPanel(Builder builder, TopLevelApplicationBuilder app, JTextField boardDimensions) {
		this.builder = builder;
		this.app = app;
		this.boardDimensions = boardDimensions;
		
		
		// Get the board dimensions as an integer
		String boardDimensionstext = boardDimensions.getText();
		int dimensions = Integer.parseInt(boardDimensionstext);
		
		// Create tiles to add to the board
		Tile[][] boardTile = new Tile[dimensions][dimensions];
		
		for (int i = 0; i < dimensions; i++){
			for (int j = 0; j < dimensions; j++){
				boardTile[i][j] = new Tile(true, true, 0, 0);
			}
		}

		//Create background, bullpen and board, add all three.
		JLabelIcon background = new JLabelIcon("BuilderReleaseLevel_New.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		JLabelIcon bullpen = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.9),
				(int) (Screen.height * 0.38));
		bullpen.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.55));
		background.add(bullpen);
		
		JLabelIcon board = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.5),
				(int) (Screen.height * 0.5));
		board.setLocation((int) (Screen.width * 0.22), (int) (Screen.height * 0.02));
		//background.add(board);
		
		// get the release board
		ReleaseBoard tboard = (ReleaseBoard) builder.getSelectedLevel().getBoard();
		boardview = new BuilderReleaseBoardView(tboard, board, builder, app);
		background.add(board);
		
		// Create the first set of JLabels
		piece1Lbl = new JLabel[12];
		// Run the loop to initialize and set their positions
		for (int i = 0; i < 12; i++){
			piece1Lbl[i] = new JLabel(String.valueOf(builder.getNum(i)));
			numOfPiecesOnLoad[i] = builder.getNum(i);
			piece1Lbl[i].setBounds(30 + i *60, 65, 20, 20);
			bullpen.add(piece1Lbl[i]);
		}
		
		// Create the second set of labels
		JLabel[] piece2Lbl = new JLabel[12];
		// Run the loop to initialize and set their positions
		for (int i = 0; i < 12; i++){
			piece2Lbl[i] = new JLabel(String.valueOf(builder.getNum(i+12)));
			numOfPiecesOnLoad[i+12] = builder.getNum(i+12);
			piece2Lbl[i].setBounds(30 + i *60, 65 + 70, 20, 20);
			bullpen.add(piece2Lbl[i]);
		}
		
		// Create the third set of labels
		JLabel[] piece3Lbl = new JLabel[11];
		// Run the loop to initialize and set their positions
		for (int i = 0; i < 11; i++){
			piece3Lbl[i] = new JLabel(String.valueOf(builder.getNum(i+24)));
			numOfPiecesOnLoad[i+24] = builder.getNum(i+24);
			piece3Lbl[i].setBounds(30 + i *60, 65 + 140, 20, 20);
			bullpen.add(piece3Lbl[i]);
		}
		
		
		// Create the first row of pieces in the bullpen
		piece = new JLabelIcon[12];
		// Run the loop to initialize and set the positions
		for (int i = 0; i < 12; i++){
			// Create a piece in the builder bullpen
			piece[i] = new JLabelIcon("tile" + i + ".png", 60, 60);
			piece[i].setLocation(i*piece[i].getWidth() + 10, 10);
			piece[i].addMouseListener(new IncrementPieceBuilderController(builder, app, piece1Lbl[i], i));
			bullpen.add(piece[i]);
		}
		
		// Create the second row of pieces in the bullpen
		JLabelIcon[] piece2 = new JLabelIcon[12];
		// Run the loop to initialize and set the positions
		for (int i = 0; i < 12; i++){
			// Create a piece in the builder bullpen
			int newInt = i + 12;
			String newString = Integer.toString(newInt);
			piece2[i] = new JLabelIcon("tile" + newString + ".png", 60, 60);
			piece2[i].setLocation(i*piece2[i].getWidth() + 10, piece2[i].getHeight() + 20);
			piece2[i].addMouseListener(new IncrementPieceBuilderController(builder, app, piece2Lbl[i], newInt));
			bullpen.add(piece2[i]);
		}
		
		// Create the third row of pieces in bullpen
		JLabelIcon[] piece3 = new JLabelIcon[11];
		// Run the loop to initialize and set the positions
		for (int i = 0; i < 11; i++){
			// Create a piece in the builder bullpen
			int newInt1 = i + 24;
			String newString1 = Integer.toString(newInt1);
			piece3[i] = new JLabelIcon("tile" + newString1 + ".png", 60, 60);
			piece3[i].setLocation(i*piece3[i].getWidth() + 10, 2*piece3[i].getHeight() + 30);
			piece3[i].addMouseListener(new IncrementPieceBuilderController(builder, app, piece3Lbl[i], newInt1));
			bullpen.add(piece3[i]);
		}

		undoBtn = new JLabelIcon("generalbutton.png", 70, 70);
		undoBtn.setLocation((int) (Screen.width * 0.72) + (int) (undoBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel undoLbl = new JLabel("<html>Undo</html>", SwingConstants.CENTER);
		undoLbl.setBounds(0, 0, 70, 70);
		undoLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		undoBtn.add(undoLbl);
		background.add(undoBtn);
		undoBtn.addMouseListener(new UndoController(builder, app, undoBtn, piece1Lbl, piece2Lbl, piece3Lbl, boardview));

		redoBtn = new JLabelIcon("generalbutton.png", 70, 70);
		redoBtn.setLocation((int) (Screen.width * 0.82) + (int) (undoBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel redoLbl = new JLabel("<html>Redo</html>", SwingConstants.CENTER);
		redoLbl.setBounds(0, 0, 70, 70);
		redoLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		redoBtn.add(redoLbl);
		background.add(redoBtn);
		redoBtn.addMouseListener(new RedoController(builder, app, redoBtn, piece1Lbl, piece2Lbl, piece3Lbl, boardview));
		
		numMoves = new JTextField();
		if(builder.getSelectedLevel().getEndCondition() > 0)
		{
			numMoves.setText(Integer.toString(builder.getSelectedLevel().getEndCondition()));
		}
		numMoves.setBounds((int) (Screen.width * 0.08 + 10), (int) (Screen.height * 0.15), 40, 20);
		numMoves.setFont(new Font("Onyx", Font.BOLD, 18));
		background.add(numMoves);
		
		saveBtn = new JLabelIcon("generalbutton.png", 70, 70);
		saveBtn.setLocation((int) (Screen.width * 0.72) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel saveLbl = new JLabel("<html>Save<br>Level</html>", SwingConstants.CENTER);
		saveLbl.setBounds(0, 0, 70, 70);
		saveLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		saveBtn.add(saveLbl);
		background.add(saveBtn);
		saveBtn.addMouseListener(new SaveLevelController(builder, app, saveBtn, numMoves, 3, numOfPiecesOnLoad));

		deleteBtn = new JLabelIcon("generalbutton.png", 70, 70);
		deleteBtn.setLocation((int) (Screen.width * 0.82) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel deleteLbl = new JLabel("<html>Delete<br>Level</html>", SwingConstants.CENTER);
		deleteLbl.setBounds(0, 0, 70, 70);
		deleteLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		deleteBtn.add(deleteLbl);
		background.add(deleteBtn);
		
		numBtn1 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn1.setLocation((int) (Screen.width * 0) + (int) (numBtn1.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtnLbl = new JLabel("<html>1</html>", SwingConstants.CENTER);
		numBtnLbl.setBounds(0, 0, 20, 20);
		numBtnLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn1.add(numBtnLbl);
		background.add(numBtn1);
		
		numBtn2 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn2.setLocation((int) (Screen.width * 0.035) + (int) (numBtn2.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn2Lbl = new JLabel("<html>2</html>", SwingConstants.CENTER);
		numBtn2Lbl.setBounds(0, 0, 20, 20);
		numBtn2Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn2.add(numBtn2Lbl);
		background.add(numBtn2);
		
		numBtn3 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn3.setLocation((int) (Screen.width * 0.07) + (int) (numBtn3.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn3Lbl = new JLabel("<html>3</html>", SwingConstants.CENTER);
		numBtn3Lbl.setBounds(0, 0, 20, 20);
		numBtn3Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn3.add(numBtn3Lbl);
		background.add(numBtn3);
		
		numBtn4 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn4.setLocation((int) (Screen.width * 0.105) + (int) (numBtn4.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn4Lbl = new JLabel("<html>4</html>", SwingConstants.CENTER);
		numBtn4Lbl.setBounds(0, 0, 20, 20);
		numBtn4Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn4.add(numBtn4Lbl);
		background.add(numBtn4);
		
		numBtn5 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn5.setLocation((int) (Screen.width * 0.14) + (int) (numBtn5.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn5Lbl = new JLabel("<html>5</html>", SwingConstants.CENTER);
		numBtn5Lbl.setBounds(0, 0, 20, 20);
		numBtn5Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn5.add(numBtn5Lbl);
		background.add(numBtn5);
		
		numBtn6 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn6.setLocation((int) (Screen.width * 0.175) + (int) (numBtn6.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn6Lbl = new JLabel("<html>6</html>", SwingConstants.CENTER);
		numBtn6Lbl.setBounds(0, 0, 20, 20);
		numBtn6Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn6.add(numBtn6Lbl);
		background.add(numBtn6);
		
		colorBtn1 = new JLabelIcon("general1button.png", 30, 30);
		colorBtn1.setLocation((int) (Screen.width * 0.02) + (int) (colorBtn1.getSize().getWidth() / 2),
				(int) (Screen.height * 0.35));
		JLabelIcon tick1 = new JLabelIcon("tick.png", 30, 30);
		tick1.setBounds(0, 0, 20, 20);
		tick1.setFont(new Font("Onyx", Font.BOLD, 18));
		colorBtn1.add(tick1);
		tick1.setVisible(false);
		background.add(colorBtn1);
		
		colorBtn2 = new JLabelIcon("general2button.png", 30, 30);
		colorBtn2.setLocation((int) (Screen.width * 0.08) + (int) (colorBtn2.getSize().getWidth() / 2),
				(int) (Screen.height * 0.35));
		JLabelIcon tick2 = new JLabelIcon("tick.png", 30, 30);
		tick2.setBounds(0, 0, 20, 20);
		tick2.setFont(new Font("Onyx", Font.BOLD, 18));
		colorBtn2.add(tick2);
		tick2.setVisible(false);
		background.add(colorBtn2);
		
		colorBtn3 = new JLabelIcon("general3button.png", 30, 30);
		colorBtn3.setLocation((int) (Screen.width * 0.14) + (int) (colorBtn3.getSize().getWidth() / 2),
				(int) (Screen.height * 0.35));
		JLabelIcon tick3 = new JLabelIcon("tick.png", 30, 30);
		tick3.setBounds(0, 0, 20, 20);
		tick3.setFont(new Font("Onyx", Font.BOLD, 18));
		colorBtn3.add(tick3);
		tick3.setVisible(false);
		background.add(colorBtn3);
		
		colorBtn1.addMouseListener(new SetColorController(builder, app, 1, boardview, tick1, tick2, tick3, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6));
		colorBtn2.addMouseListener(new SetColorController(builder, app, 2, boardview, tick1, tick2, tick3, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6));
		colorBtn3.addMouseListener(new SetColorController(builder, app, 3, boardview, tick1, tick2, tick3, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6));
		
		numBtn1.addMouseListener(new SetNumberController(builder, app, 1, boardview, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6, tick1, tick2, tick3));
		numBtn2.addMouseListener(new SetNumberController(builder, app, 2, boardview, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6, tick1, tick2, tick3));
		numBtn3.addMouseListener(new SetNumberController(builder, app, 3, boardview, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6, tick1, tick2, tick3));
		numBtn4.addMouseListener(new SetNumberController(builder, app, 4, boardview, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6, tick1, tick2, tick3));
		numBtn5.addMouseListener(new SetNumberController(builder, app, 5, boardview, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6, tick1, tick2, tick3));
		numBtn6.addMouseListener(new SetNumberController(builder, app, 6, boardview, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6, tick1, tick2, tick3));
	
		colorClearBtn = new JLabelIcon("generalbutton.png", 30, 30);
		colorClearBtn.setLocation((int) (Screen.width * 0.08) + (int) (colorClearBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.45));	
		background.add(colorClearBtn);
		colorClearBtn.addMouseListener(new DeselectReleaseButtonsController(builder, app, 4, boardview, tick1, tick2, tick3, numBtn1, numBtn2, numBtn3, numBtn4, numBtn5, numBtn6));

		mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.72) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * .31));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(
				new GoToMainMenuBuilderController(builder, app,mainmenubtn));
		background.add(mainmenubtn);
		
		// Add a test level button to the GUI so that the user can test the built level
		testBtn = new JLabelIcon("generalbutton.png", 70, 70);
		testBtn.setLocation((int) (Screen.width * 0.82) + (int) (testBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.31));
		JLabel testLbl = new JLabel("<html>Test<br>Level</html>", SwingConstants.CENTER);
		testLbl.setBounds(0, 0, 70, 70);
		testLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		testBtn.add(testLbl);
		background.add(testBtn);
		
		// Add a mouse listener for the controller
		testBtn.addMouseListener(new TestLevelBuilderController(builder, app, testBtn, numOfPiecesOnLoad, numMoves));
		
		
		randomizeReleaseBtn = new JLabelIcon( "generalbutton.png", 140, 50);
		randomizeReleaseBtn.setLocation((int) (Screen.width * 0.72) + (int) (testBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.44));
		JLabel randomizeLbl = new JLabel("<html>Randomize<br>Level</html>", SwingConstants.CENTER);
		randomizeLbl.setBounds(0, 0, 140, 50);
		randomizeLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		randomizeReleaseBtn.add(randomizeLbl);
		background.add(randomizeReleaseBtn);
		randomizeReleaseBtn.addMouseListener(new RandomizeReleaseController(builder, boardview, app, randomizeReleaseBtn));
		
	}
	
	/**
	 * returns the main menu button
	 * @return the main menu button
	 */
	public JLabelIcon getMainMenuButton() {
		return mainmenubtn;
	}
	
	/**
	 * returns the save button
	 * @return the save button
	 */
	public JLabelIcon getSaveButton() {
		return saveBtn;
	}
	
	/**
	 * returns the delete button
	 * @return the delete button
	 */
	public JLabelIcon getDeleteButton() {
		return deleteBtn;
	}
	
	/**
	 * returns the undo button
	 * @return the undo button
	 */
	public JLabelIcon getUndoButton() {
		return undoBtn;
	}
	
	/**
	 * returns the redo button
	 * @return the redo button
	 */
	public JLabelIcon getRedoButton() {
		return redoBtn;
	}
	
	/**
	 * returns the test button
	 * @return the test button
	 */
	public JLabelIcon getTestButton() {
		return testBtn;
	}
	
	/**
	 * returns the first color button
	 * @return the first color button
	 */
	public JLabelIcon getColorButton1() {
		return colorBtn1;
	}
	
	/**
	 * returns the second color button
	 * @return the second color button
	 */
	public JLabelIcon getColorButton2() {
		return colorBtn2;
	}
	
	/**
	 * returns the third color button
	 * @return the third color button
	 */
	public JLabelIcon getColorButton3() {
		return colorBtn3;
	}
	
	/**
	 * returns the clear color and number button
	 * @return the clear color and number button
	 */
	public JLabelIcon getClearColorButton() {
		return colorClearBtn;
	}
	
	/**
	 * returns the first row of number that correspond to how many of a certain piece there are
	 * @return
	 */
	public JLabelIcon[] getFirstRowPieces() {
		return piece;
	}
	
	/**
	 * returns how many of a certain piece there are
	 * @param index the location that we get the number of pieces from
	 * @return the number of pieces
	 */
	public String getNumPieces(int index) {
		return piece1Lbl[index].getText();
	}
	
	/**
	 * sets the displayed max moves value
	 * @param s the number of moves
	 */
	public void setNumMoves(String s) {
		numMoves.setText(s);
	}
	
	/**
	 * returns the number button specified
	 * @param i the number of the button to return
	 * @return the number button specified
	 */
	public JLabelIcon getNumButton(int i) {
		switch(i) {
			case 1: return numBtn1;
			case 2: return numBtn2;
			case 3: return numBtn3;
			case 4: return numBtn4;
			case 5: return numBtn5;
			case 6: return numBtn6;
			default: return numBtn1;
		}
	}
	
	/**
	 * returns the board view
	 * @return
	 */
	public BuilderReleaseBoardView getBoardview() {
		return boardview;
	}

}
