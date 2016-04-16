package kabasuji.view;

import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Kabasuji;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.io.File;

public class PuzzleLevelPanel extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;
	/**
	 * Create the bullpen.
	 */
	public PuzzleLevelPanel(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Flip Horizontally");
		btnNewButton_1.setBounds(830, 11, 150, 50);
		btnNewButton_1.setBackground(Color.orange);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(true);
		
		JButton btnNewButton_2 = new JButton("Flip Vertically");
		btnNewButton_2.setBounds(830, 70, 150, 50);
		btnNewButton_2.setBackground(Color.orange);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setOpaque(true);
		
		JButton btnNewButton_3 = new JButton("Turn Clockwise");
		btnNewButton_3.setBounds(830, 199, 150, 50);
		btnNewButton_3.setBackground(Color.orange);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setOpaque(true);
		
		JButton btnNewButton_4 = new JButton("Turn Counter-Clockwise");
		btnNewButton_4.setBounds(830, 260, 150, 50);
		btnNewButton_4.setBackground(Color.orange);
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setOpaque(true);
		setLayout(null);
		
		add(btnNewButton_1);
		add(btnNewButton_2);
		add(btnNewButton_3);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Next Level");
		btnNewButton_5.setBounds(830, 455, 150, 50);
		btnNewButton_5.setBackground(Color.gray);
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setOpaque(true);
		
		JButton btnNewButton_6 = new JButton("Reset Level");
		btnNewButton_6.setBounds(830, 533, 150, 50);
		btnNewButton_6.setBackground(Color.orange);
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setOpaque(true);
		
		JLabelIcon btnNewButton_7 = new JLabelIcon("generalbutton.png",70,70);
		btnNewButton_7.setLocation(0, 0);
		btnNewButton_7.addMouseListener(new GoToMainMenuController(kabasuji, app, btnNewButton_7));
		
		JLabel movesLeft = new JLabel("Moves Left");
		movesLeft.setBounds(0, 547, 150, 50);
		movesLeft.setFont(new Font("Tahoma", Font.BOLD, 20));
		movesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel movesLeftNum = new JLabel("12");
		movesLeftNum.setBounds(0, 588, 150, 50);
		movesLeftNum.setFont(new Font("Tahoma", Font.BOLD, 20));
		movesLeftNum.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(btnNewButton_5);
		add(btnNewButton_6);
		add(btnNewButton_7);
		add(movesLeft);
		add(movesLeftNum);
		
		JPanel bullpen = new JPanel();
		bullpen.setBounds(155, 70, 585, 350);
		bullpen.setBackground(Color.lightGray);
		add(bullpen);
		bullpen.setLayout(null);
		
		JPanel board = new JPanel();
		board.setBounds(196, 450, 500, 250);
		board.setBackground(Color.WHITE);
		add(board);
		board.setLayout(null);
		
		String path = System.getProperty("user.dir") + File.separator + "src\\images\\tile.PNG";
		String path_bullpen = System.getProperty("user.dir") + File.separator + "src\\images\\bullpen_piece.PNG";

		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 6; j++){
				ImageIcon image = new ImageIcon(path);
				JLabel starlabel = new JLabel("", image, JLabel.CENTER);
				starlabel.setBounds(j*50, i*50, 50, 50);
				board.add(starlabel);
			}
		}
		
		for (int i = 0; i < 6; i++){
			ImageIcon image = new ImageIcon(path_bullpen);
			JLabel pieceLabel = new JLabel("", image, JLabel.CENTER);
			pieceLabel.setBounds(10 + i*50, 50, 50, 50);
			bullpen.add(pieceLabel);
		}
		
		for (int i = 0; i < 6; i++){
			ImageIcon image = new ImageIcon(path_bullpen);
			JLabel pieceLabel = new JLabel("", image, JLabel.CENTER);
			pieceLabel.setBounds(400, 10 + i*50, 50, 50);
			bullpen.add(pieceLabel);
		}
	}
}
