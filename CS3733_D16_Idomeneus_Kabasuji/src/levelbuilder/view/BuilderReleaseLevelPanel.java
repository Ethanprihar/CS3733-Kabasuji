package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.JLabelIcon;
import levelbuilder.controller.GoToMainMenuBuilderController;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BuilderReleaseLevelPanel extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;

	/**
	 * Create the panel.
	 */
	public BuilderReleaseLevelPanel(Builder builder, TopLevelApplicationBuilder app) {
		this.builder = builder;
		this.app = app;

		JLabelIcon background = new JLabelIcon("BuilderReleaseLevel_New.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		JLabelIcon bullpen = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.9),
				(int) (Screen.height * 0.30));
		bullpen.setLocation((int) (Screen.width * 0.05), (int) (Screen.height * 0.60));
		background.add(bullpen);
		
		JLabelIcon board = new JLabelIcon("boardpanel_opaque.png", (int) (Screen.width * 0.52),
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
		numMoves.setBounds((int) (Screen.width * 0.08 + 10), (int) (Screen.height * 0.15), 40, 20);
		numMoves.setFont(new Font("Onyx", Font.BOLD, 18));
		background.add(numMoves);
		
		JLabelIcon numBtn1 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn1.setLocation((int) (Screen.width * 0) + (int) (numBtn1.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtnLbl = new JLabel("<html>1</html>", SwingConstants.CENTER);
		numBtnLbl.setBounds(0, 0, 20, 20);
		numBtnLbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn1.add(numBtnLbl);
		background.add(numBtn1);
		
		JLabelIcon numBtn2 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn2.setLocation((int) (Screen.width * 0.035) + (int) (numBtn2.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn2Lbl = new JLabel("<html>2</html>", SwingConstants.CENTER);
		numBtn2Lbl.setBounds(0, 0, 20, 20);
		numBtn2Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn2.add(numBtn2Lbl);
		background.add(numBtn2);
		
		JLabelIcon numBtn3 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn3.setLocation((int) (Screen.width * 0.07) + (int) (numBtn3.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn3Lbl = new JLabel("<html>3</html>", SwingConstants.CENTER);
		numBtn3Lbl.setBounds(0, 0, 20, 20);
		numBtn3Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn3.add(numBtn3Lbl);
		background.add(numBtn3);
		
		JLabelIcon numBtn4 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn4.setLocation((int) (Screen.width * 0.105) + (int) (numBtn4.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn4Lbl = new JLabel("<html>4</html>", SwingConstants.CENTER);
		numBtn4Lbl.setBounds(0, 0, 20, 20);
		numBtn4Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn4.add(numBtn4Lbl);
		background.add(numBtn4);
		
		JLabelIcon numBtn5 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn5.setLocation((int) (Screen.width * 0.14) + (int) (numBtn5.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn5Lbl = new JLabel("<html>5</html>", SwingConstants.CENTER);
		numBtn5Lbl.setBounds(0, 0, 20, 20);
		numBtn5Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn5.add(numBtn5Lbl);
		background.add(numBtn5);
		
		JLabelIcon numBtn6 = new JLabelIcon("generalbutton.png", 20, 20);
		numBtn6.setLocation((int) (Screen.width * 0.175) + (int) (numBtn6.getSize().getWidth() / 2),
				(int) (Screen.height * 0.25));
		JLabel numBtn6Lbl = new JLabel("<html>6</html>", SwingConstants.CENTER);
		numBtn6Lbl.setBounds(0, 0, 20, 20);
		numBtn6Lbl.setFont(new Font("Onyx", Font.BOLD, 18));
		numBtn6.add(numBtn6Lbl);
		background.add(numBtn6);
		
		JLabelIcon colorBtn1 = new JLabelIcon("general1button.png", 30, 30);
		colorBtn1.setLocation((int) (Screen.width * 0.02) + (int) (colorBtn1.getSize().getWidth() / 2),
				(int) (Screen.height * 0.35));	
		background.add(colorBtn1);
		
		JLabelIcon colorBtn2 = new JLabelIcon("general2button.png", 30, 30);
		colorBtn2.setLocation((int) (Screen.width * 0.08) + (int) (colorBtn2.getSize().getWidth() / 2),
				(int) (Screen.height * 0.35));	
		background.add(colorBtn2);
		
		JLabelIcon colorBtn3 = new JLabelIcon("general3button.png", 30, 30);
		colorBtn3.setLocation((int) (Screen.width * 0.14) + (int) (colorBtn3.getSize().getWidth() / 2),
				(int) (Screen.height * 0.35));	
		background.add(colorBtn3);
		
		JLabelIcon colorClearBtn = new JLabelIcon("generalbutton.png", 30, 30);
		colorClearBtn.setLocation((int) (Screen.width * 0.08) + (int) (colorClearBtn.getSize().getWidth() / 2),
				(int) (Screen.height * 0.45));	
		background.add(colorClearBtn);

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
