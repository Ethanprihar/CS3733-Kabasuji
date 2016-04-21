package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.GoToMainMenuBuilderController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BuilderLightningLevelPanel extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;
	//JTextField boardDimensions;

	/**
	 * Create the panel.
	 */
	public BuilderLightningLevelPanel(Builder builder, TopLevelApplicationBuilder app) {
		this.builder = builder;
		this.app = app;

		JLabelIcon background = new JLabelIcon("BuilderLightningLevel_New.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		JLabelIcon bullpen = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.9),
				(int) (Screen.height * 0.30));
		bullpen.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.60));
		background.add(bullpen);
		
		JLabelIcon board = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.5),
				(int) (Screen.height * 0.5));
		board.setLocation((int) (Screen.width * 0.22), (int) (Screen.height * 0.05));
		background.add(board);

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

		JLabelIcon saveBtn = new JLabelIcon("generalbutton.png", 70, 70);
		saveBtn.setLocation((int) (Screen.width * 0.72) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel saveLbl = new JLabel("<html>Save<br>Level</html>", SwingConstants.CENTER);
		saveLbl.setBounds(0, 0, 70, 70);
		saveLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		saveBtn.add(saveLbl);
		background.add(saveBtn);

		JLabelIcon deleteBtn = new JLabelIcon("generalbutton.png", 70, 70);
		deleteBtn.setLocation((int) (Screen.width * 0.82) + (int) (saveBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.18));
		JLabel deleteLbl = new JLabel("<html>Delete<br>Level</html>", SwingConstants.CENTER);
		deleteLbl.setBounds(0, 0, 70, 70);
		deleteLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		deleteBtn.add(deleteLbl);
		background.add(deleteBtn);
		
		JTextField numMoves = new JTextField();
		numMoves.setBounds((int) (Screen.width * 0.08 + 10), (int) (Screen.height * 0.30), 40, 20);
		numMoves.setFont(new Font("Onyx", Font.BOLD, 18));
		background.add(numMoves);

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
