package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Board;
import kabasuji.model.Builder;
import kabasuji.model.PuzzleBoard;
import kabasuji.model.Screen;
import kabasuji.view.BoardView;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.GoToMainMenuBuilderController;
import levelbuilder.controller.IncrementPieceBuilderController;
import levelbuilder.controller.SaveLevelController;
import kabasuji.model.Tile;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BuilderPuzzleLevelPanel extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;
	JTextField boardDimensions;

	/**
	 * Create the panel.
	 */
	public BuilderPuzzleLevelPanel(Builder builder, TopLevelApplicationBuilder app, JTextField boardDimensions) {
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

		JLabelIcon background = new JLabelIcon("BuilderPuzzleLevel.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		JLabelIcon bullpen = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.9),
				(int) (Screen.height * 0.38));
		bullpen.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.55));
		background.add(bullpen);
		
		JLabelIcon board = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.5),
				(int) (Screen.height * 0.5));
		board.setLocation((int) (Screen.width * 0.22), (int) (Screen.height * 0.02));
		
		// get the puzzle board
		PuzzleBoard tboard = (PuzzleBoard) builder.getSelectedLevel().getBoard();
		
		BuilderBoardView boardview = new BuilderBoardView(tboard, board, builder, app);
		background.add(board);
		
		// Create the first set of JLabels
		JLabel[] piece1Lbl = new JLabel[12];
		// Run the loop to initialize and set their positions
		for (int i = 0; i < 12; i++){
			piece1Lbl[i] = new JLabel(String.valueOf(builder.getNum(i)));
			piece1Lbl[i].setBounds(30 + i *60, 65, 20, 20);
			bullpen.add(piece1Lbl[i]);
		}
		
		// Create the second set of labels
		JLabel[] piece2Lbl = new JLabel[12];
		// Run the loop to initialize and set their positions
		for (int i = 0; i < 12; i++){
			piece2Lbl[i] = new JLabel(String.valueOf(builder.getNum(i+12)));
			piece2Lbl[i].setBounds(30 + i *60, 65 + 70, 20, 20);
			bullpen.add(piece2Lbl[i]);
		}
		
		// Create the third set of labels
		JLabel[] piece3Lbl = new JLabel[11];
		// Run the loop to initialize and set their positions
		for (int i = 0; i < 11; i++){
			piece3Lbl[i] = new JLabel(String.valueOf(builder.getNum(i+12+12)));
			piece3Lbl[i].setBounds(30 + i *60, 65 + 140, 20, 20);
			bullpen.add(piece3Lbl[i]);
		}
		
		// Create the first row of pieces in the bullpen
		JLabelIcon[] piece = new JLabelIcon[12];
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

		JLabelIcon undoBtn = new JLabelIcon("generalbutton.png", 70, 70);
		undoBtn.setLocation((int) (Screen.width * 0.72) + (int) (undoBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel undoLbl = new JLabel("<html>Undo</html>", SwingConstants.CENTER);
		undoLbl.setBounds(0, 0, 70, 70);
		undoLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		undoBtn.add(undoLbl);
		background.add(undoBtn);

		JLabelIcon redoBtn = new JLabelIcon("generalbutton.png", 70, 70);
		redoBtn.setLocation((int) (Screen.width * 0.82) + (int) (undoBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.05));
		JLabel redoLbl = new JLabel("<html>Redo</html>", SwingConstants.CENTER);
		redoLbl.setBounds(0, 0, 70, 70);
		redoLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		redoBtn.add(redoLbl);
		background.add(redoBtn);

		JTextField numMoves = new JTextField();
		numMoves.setBounds((int) (Screen.width * 0.08 + 10), (int) (Screen.height * 0.30), 40, 20);
		numMoves.setFont(new Font("Onyx", Font.BOLD, 18));
		background.add(numMoves);
		
		JLabelIcon saveBtn = new JLabelIcon("generalbutton.png", 70, 70);
		saveBtn.setLocation((int) (Screen.width * 0.72) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel saveLbl = new JLabel("<html>Save<br>Level</html>", SwingConstants.CENTER);
		saveLbl.setBounds(0, 0, 70, 70);
		saveLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		saveBtn.add(saveLbl);
		background.add(saveBtn);
		saveBtn.addMouseListener(new SaveLevelController(builder, app, saveBtn, numMoves));

		JLabelIcon deleteBtn = new JLabelIcon("generalbutton.png", 70, 70);
		deleteBtn.setLocation((int) (Screen.width * 0.82) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel deleteLbl = new JLabel("<html>Delete<br>Level</html>", SwingConstants.CENTER);
		deleteLbl.setBounds(0, 0, 70, 70);
		deleteLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		deleteBtn.add(deleteLbl);
		background.add(deleteBtn);

		JLabelIcon mainmenubtn = new JLabelIcon("generalbutton.png", 70, 70);
		mainmenubtn.setLocation((int) (Screen.width * 0.78) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * .35));
		JLabel mainmenulbl = new JLabel("<html>Main<br>Menu</html>", SwingConstants.CENTER);
		mainmenulbl.setBounds(0, 0, 70, 70);
		mainmenulbl.setFont(new Font("Onyx", Font.BOLD, 18));
		mainmenubtn.add(mainmenulbl);
		mainmenubtn.addMouseListener(
				new GoToMainMenuBuilderController(builder, app,mainmenubtn));
		background.add(mainmenubtn);
	}
}
