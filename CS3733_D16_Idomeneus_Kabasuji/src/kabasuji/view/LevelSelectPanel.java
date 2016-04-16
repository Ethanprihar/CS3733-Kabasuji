package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelSelectPanel extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the panel.
	 */
	public LevelSelectPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		JLabelIcon[] levelselectbtn = new JLabelIcon[15];
		JLabel[] buttonlbl = new JLabel[15];

		JLabelIcon background = new JLabelIcon("LevelSelectScreen.png", Screen.width, Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				levelselectbtn[i * 5 + j] = new JLabelIcon("generalbutton.png", 70, 70);
				levelselectbtn[i * 5 + j].setLocation(
						(int) (Screen.width / 7 * (j + 1) + levelselectbtn[i * 5 + j].getSize().getWidth() / 2),
						(int) (Screen.height / 10 * (i*2 + 2) + levelselectbtn[i * 5 + j].getSize().getHeight() / 2));
				buttonlbl[i * 5 + j] = new JLabel("<html>Select<br>" + "Level " + (i * 5 + j + 1) + "</html>",
						SwingConstants.CENTER);
				buttonlbl[i * 5 + j].setBounds(0, 0, 70, 70);
				buttonlbl[i * 5 + j].setFont(new Font("Onyx", Font.BOLD, 18));
				levelselectbtn[i * 5 + j].add(buttonlbl[i * 5 + j]);
				levelselectbtn[i * 5 + j].addMouseListener(new SelectLevelController(kabasuji, app,levelselectbtn[i * 5 + j], i * 5 + j + 1));
				background.add(levelselectbtn[i * 5 + j]);
			}
		}

	}
}
