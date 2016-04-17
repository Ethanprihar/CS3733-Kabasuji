package levelbuilder.view;

import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToMainMenuController;
import kabasuji.controller.SelectLevelController;
import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import levelbuilder.controller.GoToMainMenuBuilderController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.io.File;

public class BuilderPuzzleLevelPanel extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;
	/**
	 * Create the bullpen.
	 */
	public BuilderPuzzleLevelPanel(Builder builder, TopLevelApplicationBuilder app) {
		this.builder = builder;
		this.app = app;
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Delete Level");
		btnNewButton_1.setBounds(830, 11, 150, 50);
		btnNewButton_1.setBackground(Color.orange);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(true);
	
		setLayout(null);
		
		add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("Undo");
		btnNewButton_5.setBounds(830, 455, 150, 50);
		btnNewButton_5.setBackground(Color.orange);
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setOpaque(true);
		
		JButton btnNewButton_6 = new JButton("Redo");
		btnNewButton_6.setBounds(830, 533, 150, 50);
		btnNewButton_6.setBackground(Color.orange);
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setOpaque(true);
		
		JButton btnNewButton_7 = new JButton("Save Level");
		btnNewButton_7.setBounds(830, 613, 150, 50);
		btnNewButton_7.setBackground(Color.orange);
		btnNewButton_7.setForeground(Color.BLACK);
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setOpaque(true);
		
		JButton btnNewButton_8 = new JButton("Main Menu");
		btnNewButton_8.setBounds(830, 215, 150, 50);
		btnNewButton_8.setBackground(Color.orange);
		btnNewButton_8.setForeground(Color.BLACK);
		btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setOpaque(true);
		
		//btnNewButton_8.addMouseListener(new GoToMainMenuBuilderController(builder, app, null));
		//Added null because I had to change constructor for highlight color changes. - Odell
		
		JLabel movesLeft = new JLabel("Moves");
		movesLeft.setBounds(0, 145, 150, 50);
		movesLeft.setFont(new Font("Tahoma", Font.BOLD, 20));
		movesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField movesLeftNum = new JTextField("12");
		movesLeftNum.setBounds(0, 186, 150, 50);
		movesLeftNum.setFont(new Font("Tahoma", Font.BOLD, 20));
		movesLeftNum.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(btnNewButton_5);
		add(btnNewButton_6);
		add(btnNewButton_7);
		add(btnNewButton_8);
		add(movesLeft);
		add(movesLeftNum);
		
		JPanel bullpen = new JPanel();
		bullpen.setBounds(155, 450, 585, 350);
		bullpen.setBackground(Color.lightGray);
		add(bullpen);
		bullpen.setLayout(null);
		
		JPanel board = new JPanel();
		board.setBounds(196, 70, 500, 250);
		board.setBackground(Color.WHITE);
		add(board);
		board.setLayout(null);
		
		String path = System.getProperty("user.dir") + File.separator + "src\\images\\tile.PNG";
		String path_bullpen = System.getProperty("user.dir") + File.separator + "src\\images\\PiecesImage585x350.png";

		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 6; j++){
				ImageIcon image = new ImageIcon(path);
				JLabel starlabel = new JLabel("", image, JLabel.CENTER);
				starlabel.setBounds(j*50, i*50, 50, 50);
				board.add(starlabel);
			}
		}
		
		ImageIcon image = new ImageIcon(path_bullpen);
		JLabel pieceLabel = new JLabel("", image, JLabel.CENTER);
		pieceLabel.setBounds(0, 0, 585, 350);
		bullpen.add(pieceLabel);
	}
}
